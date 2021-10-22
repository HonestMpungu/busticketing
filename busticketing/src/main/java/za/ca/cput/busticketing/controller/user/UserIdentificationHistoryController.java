package za.ca.cput.busticketing.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ca.cput.busticketing.entity.user.UserIdentificationHistory;
import za.ca.cput.busticketing.service.user.UserIdentificationHistoryService;

import java.util.List;
import java.util.Optional;

/**
 * @author anongxa
 * Student No:204513723
 *23/09/2021
 */

@Controller
@RequestMapping(path="/userIdentificationHistory")
public class UserIdentificationHistoryController {

    @Autowired
	private UserIdentificationHistoryService userIdentificationHistoryService;

	//display the list of UserIdentificationHistory
	@GetMapping(path="/all")
	public String viewUserIdentificationHistoryPage( Model model){
		List<UserIdentificationHistory> listUserIdentificationHistorys = userIdentificationHistoryService.getAll();
		model.addAttribute( "listOfUserIdentificationHistorys" , listUserIdentificationHistorys);
		return "userIdentificationHistory/show-userIdentificationHistory";
	}

	@PostMapping("/save")
	public String addUserIdentificationHistory(UserIdentificationHistory userIdentificationHistory, BindingResult result, Model model) {
		userIdentificationHistoryService.save(userIdentificationHistory);
		return "redirect:/userIdentificationHistory/all";
	}

	//form to be called first when wanting to add a new UserIdentificationHistory
	@GetMapping("/form")
	public String displayAddUserIdentificationHistoryForm(UserIdentificationHistory userIdentificationHistory) {
		return "userIdentificationHistory/add-userIdentificationHistory";
	}

	@GetMapping("/updateform/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Optional<UserIdentificationHistory> userIdentificationHistory = userIdentificationHistoryService.getByID(id);
		model.addAttribute("userIdentificationHistory",userIdentificationHistory.orElse( null ));
		return "userIdentificationHistory/update-userIdentificationHistory";
	}

	@PostMapping("/updater")
	public String updateUserIdentificationHistory(UserIdentificationHistory userIdentificationHistory, BindingResult result, Model model) {

        userIdentificationHistoryService.update(userIdentificationHistory);
		return "redirect:/userIdentificationHistory/all";
	}

	@GetMapping("/delete/{id}")
	public String deleteUserIdentificationHistory(@PathVariable("id") Integer id, Model model) {
		Optional<UserIdentificationHistory> userIdentificationHistory = userIdentificationHistoryService.getByID( id );
		if(userIdentificationHistory.isPresent())
            userIdentificationHistoryService.delete(userIdentificationHistory.get().getId());
		return "redirect:/userIdentificationHistory/all";
	}

}
