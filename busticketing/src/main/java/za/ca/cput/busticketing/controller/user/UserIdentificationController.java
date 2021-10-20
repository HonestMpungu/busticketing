package za.ca.cput.busticketing.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ca.cput.busticketing.entity.user.UserIdentification;
import za.ca.cput.busticketing.service.user.UserIdentificationService;

import java.util.List;
import java.util.Optional;

/**
 * @author anongxa
 * Student No:204513723
 *
 */

@RestController
@RequestMapping("/userIdentification")
public class UserIdentificationController {


    @Autowired
    private UserIdentificationService userIdentificationService;

    //display the list of UserIdentification
    @GetMapping(path="/all")
    public String viewUserIdentificationPage( Model model){
        List<UserIdentification> listUserIdentification = userIdentificationService.getAll();
        model.addAttribute( "listOfUserIdentification" , listUserIdentification);
        return "userIdentification/show-userIdentification";
    }

    @PostMapping("/save")
    public String adduserIdentification(UserIdentification userIdentification, BindingResult result, Model model) {
        userIdentificationService.save(userIdentification);
        return "redirect:/userIdentification/all";
    }

    //form to be called first when wanting to add a new userIdentification
    @GetMapping("/form")
    public String displayAddUserIdentificationForm(UserIdentification userIdentification) {
        return "userIdentification/add-userIdentification";
    }

    @GetMapping("/updateform/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Optional<UserIdentification> userIdentification = userIdentificationService.getByID(id);
        model.addAttribute("userIdentification", userIdentification.orElse( null ));
        return "userIdentification/update-userIdentification";
    }

    @PostMapping("/updater")
    public String updateuserIdentification(UserIdentification userIdentification, BindingResult result, Model model) {

        userIdentificationService.update(userIdentification);
        return "redirect:/userIdentification/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteuserIdentification(@PathVariable("id") Integer id, Model model) {
        Optional<UserIdentification> userIdentification = userIdentificationService.getByID( id );
        if(userIdentification.isPresent())
            userIdentificationService.delete(userIdentification.get().getId());
        return "redirect:/userIdentification/all";
    }

}
