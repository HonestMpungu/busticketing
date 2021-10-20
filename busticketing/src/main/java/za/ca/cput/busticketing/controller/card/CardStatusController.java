package za.ca.cput.busticketing.controller.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ca.cput.busticketing.entity.card.CardStatus;
import za.ca.cput.busticketing.service.card.CardStatusService;

import java.util.List;
import java.util.Optional;

/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * CardStatusController class
 */
@RestController
@RequestMapping("/cardStatus")
public class CardStatusController {


    @Autowired
	private CardStatusService cardStatusService;

	//display the list of cardStatus
	@GetMapping(path="/all")
	public String viewCardStatusPage( Model model){
		List<CardStatus> listCardStatus = cardStatusService.getAllCardStatus();
		model.addAttribute( "listOfCardStatus" , listCardStatus);
		return "cardStatus/show-cardStatus";
	}

	@PostMapping("/save")
	public String addCardStatus(CardStatus cardStatus, BindingResult result, Model model) {
		cardStatusService.save(cardStatus);
		return "redirect:/cardStatus/all";
	}

	//form to be called first when wanting to add a new cardStatus
	@GetMapping("/form")
	public String displayAddCardStatusForm(CardStatus cardStatus) {
		return "card/add-cardStatus";
	}

	@GetMapping("/updateform/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Optional<CardStatus> cardStatus = cardStatusService.getByID(id);
		model.addAttribute("cardStatus", cardStatus.orElse( null ));
		return "cardStatus/update-cardStatus";
	}

	@PostMapping("/updater")
	public String updateCardStatus(CardStatus cardStatus, BindingResult result, Model model) {

		cardStatusService.update(cardStatus);
		return "redirect:/cardStatus/all";
	}

	@GetMapping("/delete/{id}")
	public String deleteCardStatus(@PathVariable("id") Integer id, Model model) {
		Optional<CardStatus> cardStatus = cardStatusService.getByID( id );
		if(cardStatus.isPresent())
			cardStatusService.delete(cardStatus.get().getId());
		return "redirect:/cardStatus/all";
	}

}
