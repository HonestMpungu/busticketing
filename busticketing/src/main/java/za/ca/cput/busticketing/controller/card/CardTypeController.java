package za.ca.cput.busticketing.controller.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ca.cput.busticketing.entity.card.CardType;
import za.ca.cput.busticketing.service.card.CardTypeService;

import java.util.List;
import java.util.Optional;

/**
 * @author Honest Mpungu
 * Student No:215072081
 * Group:Part Time
 * 20/10/2021
 */

@RestController
@RequestMapping("/cardType")
public class CardTypeController {


    @Autowired
	private CardTypeService cardTypeService;

	//display the list of cardTypes
	@GetMapping(path="/all")
	public String viewCardTypesPage( Model model){
		List<CardType> listCardTypes = cardTypeService.getAll();
		model.addAttribute( "listOfCardTypes" , listCardTypes);
		return "cardType/show-cardTypes";
	}

	@PostMapping("/save")
	public String addCardType(CardType cardType, BindingResult result, Model model) {
		cardTypeService.save(cardType);
		return "redirect:/cardType/all";
	}

	//form to be called first when wanting to add a new cardType
	@GetMapping("/form")
	public String displayAddCardTypeForm(CardType cardType) {
		return "cardType/add-cardType";
	}

	@GetMapping("/updateform/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Optional<CardType> cardType = cardTypeService.getByID(id);
		model.addAttribute("cardType", cardType.orElse( null ));
		return "cardType/update-cardType";
	}

	@PostMapping("/updater")
	public String updateCardType(CardType cardType, BindingResult result, Model model) {

		cardTypeService.update(cardType);
		return "redirect:/cardType/all";
	}

	@GetMapping("/delete/{id}")
	public String deleteCardType(@PathVariable("id") Integer id, Model model) {
		Optional<CardType> cardType = cardTypeService.getByID( id );
		if(cardType.isPresent())
			cardTypeService.delete(cardType.get().getId());
		return "redirect:/cardType/all";
	}

}
