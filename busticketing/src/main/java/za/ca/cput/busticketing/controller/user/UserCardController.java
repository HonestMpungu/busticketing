package za.ca.cput.busticketing.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ca.cput.busticketing.entity.user.UserCard;
import za.ca.cput.busticketing.service.user.UserCardService;

import java.util.List;
import java.util.Optional;

/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * UserCardController class
 */
@Controller
@RequestMapping(path="/userCard")
public class UserCardController {
    @Autowired
    private UserCardService userCardService;

    //display the list of userCards
    @GetMapping(path="/all")
    public String viewUserCardsPage( Model model){
        List<UserCard> listUserCards = userCardService.getAllUserCards();
        model.addAttribute( "listOfUserCards" , listUserCards);
        return "userCard/show-userCard";
    }

    @PostMapping("/save")
    public String addUserCard(UserCard userCard, BindingResult result, Model model) {
        userCardService.save(userCard);
        return "redirect:/userCard/all";
    }

    //form to be called first when wanting to add a new userCard
    @GetMapping("/form")
    public String displayAddUserCardForm(UserCard userCard) {

        return "userCard/add-userCard";
    }

    @GetMapping("/updateform/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Optional<UserCard> userCard = userCardService.getByID(id);
        model.addAttribute("userCard", userCard.orElse( null ));
        return "userCard/update-userCard";
    }

    @PostMapping("/updater")
    public String updateUserCard(UserCard userCard,	BindingResult result, Model model) {

        userCardService.update(userCard);
        return "redirect:/userCard/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserCard(@PathVariable("id") Integer id, Model model) {
        Optional<UserCard> userCard = userCardService.getByID( id );
        if(userCard.isPresent())
            userCardService.delete(userCard.get().getId());
        return "redirect:/userCard/all";
    }

}
