package za.ca.cput.busticketing.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ca.cput.busticketing.entity.user.UserIdentificationtype;
import za.ca.cput.busticketing.service.user.UserIdentificationtypeService;

import java.util.List;
import java.util.Optional;


/**
 * @author anongxa
 * Student No:204513723
 *23/09/2021
 */

@Controller
@RequestMapping(path="/userIdentificationtype")
public class UserIdentificationtypeController {
    @Autowired
    private UserIdentificationtypeService userIdentificationtypeService;

    //display the list of UserIdentificationtypes
    @GetMapping(path="/all")
    public String viewUserIdentificationtypePage( Model model){
        List<UserIdentificationtype> listUserIdentificationtype = userIdentificationtypeService.getAll();
        model.addAttribute( "listOfUserIdentificationtype" , listUserIdentificationtype);
        return "userIdentificationtype/show-userIdentificationtype";
    }

    @PostMapping("/save")
    public String addCard(UserIdentificationtype userIdentificationtype, BindingResult result, Model model) {
        userIdentificationtypeService.save(userIdentificationtype);
        return "redirect:/UserIdentificationtype/all";
    }

    //form to be called first when wanting to add a new UserIdentificationtype
    @GetMapping("/form")
    public String displayAddUserIdentificationtypeForm(UserIdentificationtype userIdentificationtype) {
        return "userIdentificationtype/add-userIdentificationtype";
    }

    @GetMapping("/updateform/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Optional<UserIdentificationtype> userIdentificationtype = userIdentificationtypeService.getByID(id);
        model.addAttribute("userIdentificationtype", userIdentificationtype.orElse( null ));
        return "userIdentificationtype/update-userIdentificationtype";
    }

    @PostMapping("/updater")
    public String updateCard(UserIdentificationtype userIdentificationtype, BindingResult result, Model model) {

        userIdentificationtypeService.update(userIdentificationtype);
        return "redirect:/userIdentificationtype/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserIdentificationtype(@PathVariable("id") Integer id, Model model) {
        Optional<UserIdentificationtype> userIdentificationtype = userIdentificationtypeService.getByID( id );
        if(userIdentificationtype.isPresent())
            userIdentificationtypeService.delete(userIdentificationtype.get().getId());
        return "redirect:/userIdentificationtype/all";
    }

}
