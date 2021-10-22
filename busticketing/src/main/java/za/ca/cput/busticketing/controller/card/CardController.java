package za.ca.cput.busticketing.controller.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ca.cput.busticketing.entity.card.Card;
import za.ca.cput.busticketing.service.card.CardService;

import java.util.List;
import java.util.Optional;
/**
 * @author Honest Mpungu
 * Student No:215072081
 * Group:Part Time
 * 20/10/2021
 */
@Controller
@RequestMapping(path="/card")
public class CardController
{

	@Autowired
	private CardService cardService;

	//display the list of cards
	@GetMapping(path="/all")
	public String viewCardsPage( Model model){
		List<Card> listCards = cardService.getAllCards();
		model.addAttribute( "listOfCards" , listCards);
		return "card/show-cards";
	}

	@PostMapping("/save")
	public String addCard(Card card, BindingResult result, Model model) {
		cardService.save(card);
		return "redirect:/card/all";
	}

	//form to be called first when wanting to add a new card
	@GetMapping("/form")
	public String displayAddCardForm(Card card) {
		return "card/add-card";
	}

	@GetMapping("/updateform/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Optional<Card> card = cardService.getByID(id);
		model.addAttribute("card", card.orElse( null ));
		return "card/update-card";
	}

	@PostMapping("/updater")
	public String updateCard(Card card, BindingResult result, Model model) {

		cardService.update(card);
		return "redirect:/card/all";
	}

	@GetMapping("/delete/{id}")
	public String deleteCard(@PathVariable("id") Integer id, Model model) {
		Optional<Card> card = cardService.getByID( id );
		if(card.isPresent())
			cardService.delete(card.get().getId());
		return "redirect:/card/all";
	}

}
