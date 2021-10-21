package za.ca.cput.busticketing.service.card.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.card.Card;
import za.ca.cput.busticketing.repository.card.CardRepository;
import za.ca.cput.busticketing.service.card.CardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * @author Honest Mpungu
 * Student No:215072081
 * Group:Part Time
 * 20/10/2021
 */

@Service
public class CardServiceImpl implements CardService
{
	@Autowired
	private CardRepository cardRepository;

	@Override
	public List<Card> getAllCards()
	{
		List<Card> cards = new ArrayList<Card>();
		cardRepository.findAll().forEach(cards::add);
		return cards;
	}

	@Override
	public Optional<Card> getByID( Integer id )
	{
		return cardRepository.findById( id );
	}

	@Override
	public Card save( Card card)
	{
		return cardRepository.save( card );
	}

	@Override
	public Card update( Card card )
	{
		return save( card);
	}

	@Override
	public void delete( Integer id )
	{
		cardRepository.deleteById( id );
	}

}
