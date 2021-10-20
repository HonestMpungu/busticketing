package za.ca.cput.busticketing.service.card;

import za.ca.cput.busticketing.entity.card.Card;

import java.util.List;
import java.util.Optional;
/**
 * @author Honest Mpungu
 * Student No:215072081
 * Group:Part Time
 */
public interface CardService
{
	List<Card> getAllCards();

	Optional<Card> getByID(Integer id);

	Card save(Card card);

	Card update(Card card);

	void delete(Integer id);
}
