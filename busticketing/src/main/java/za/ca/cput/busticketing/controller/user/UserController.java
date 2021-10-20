package za.ca.cput.busticketing.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ca.cput.busticketing.entity.user.User;
import za.ca.cput.busticketing.service.user.UserService;

import java.util.List;
import java.util.Optional;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * UserController class
 */

@Controller
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserService userService;

	//display the list of users
	@GetMapping(path="/all")
	public String viewUsersPage( Model model){
		List<User> listUsers = userService.getAllUsers();
		model.addAttribute( "listOfUsers" , listUsers);
		return "user/list";
	}

	@PostMapping("/save")
	public String addUser(User user, BindingResult result, Model model) {
		userService.save(user);
		return "redirect:/user/all";
	}

	//form to be called first when wanting to add a new user
	@GetMapping("/form")
	public String displayAddUserForm(User user) {
		return "user/signup";
	}

	@GetMapping("/updateform/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Optional<User> user = userService.getByID(id);
		model.addAttribute("user", user.orElse( null ));
		return "user/update";
	}

	@PostMapping("/updater")
	public String updateUser(User user,	BindingResult result, Model model) {

			userService.update(user);
		return "redirect:/user/all";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		Optional<User> user = userService.getByID( id );
		if(user.isPresent())
			userService.delete(user.get().getId());
		return "redirect:/user/all";
	}

}
