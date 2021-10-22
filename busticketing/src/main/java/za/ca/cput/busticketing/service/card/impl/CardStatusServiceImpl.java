package za.ca.cput.busticketing.service.card.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.card.Card;
import za.ca.cput.busticketing.entity.card.CardStatus;
import za.ca.cput.busticketing.repository.card.CardRepository;
import za.ca.cput.busticketing.repository.card.CardStatusRepository;
import za.ca.cput.busticketing.service.card.CardStatusService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * CardStatusServiceImpl class
 */
@Service
public class CardStatusServiceImpl implements CardStatusService {

private CardStatusRepository cardStatusRepository;

	@Autowired
	public CardStatusServiceImpl(CardStatusRepository cardStatusRepository) {
		this.cardStatusRepository = cardStatusRepository;
	}


    @Override
    public List<CardStatus> getAllCardStatus()
    {
        List<CardStatus> cardStatus = new ArrayList<CardStatus>();
        cardStatusRepository.findAll().forEach(cardStatus::add);
        return cardStatus;
    }

    @Override
    public Optional<CardStatus> getByID(Integer id )
    {
        return cardStatusRepository.findById( id );
    }

    @Override
    public CardStatus save( CardStatus cardStatus)
    {
        return cardStatusRepository.save( cardStatus );
    }

    @Override
    public CardStatus update( CardStatus cardStatus )
    {
        return save( cardStatus);
    }

    @Override
    public void delete( Integer id )
    {
        cardStatusRepository.deleteById( id );
    }

}
