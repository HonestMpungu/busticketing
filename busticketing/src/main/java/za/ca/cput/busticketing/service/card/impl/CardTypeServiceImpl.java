package za.ca.cput.busticketing.service.card.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.card.CardType;
import za.ca.cput.busticketing.repository.card.CardTypeRepository;
import za.ca.cput.busticketing.service.card.CardTypeService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * @author Honest Mpungu
 * Student No:215072081
 * Group:Part Time
 */
@Service
public class CardTypeServiceImpl implements CardTypeService {
    @Autowired
    private CardTypeRepository cardTypeRepository;

    @Override
    public List<CardType> getAll()
    {
        List<CardType> cardTypes = new ArrayList<CardType>();
        cardTypeRepository.findAll().forEach(cardTypes::add);
        return cardTypes;
    }

    @Override
    public Optional<CardType> getByID(Integer id )
    {
        return cardTypeRepository.findById( id );
    }

    @Override
    public CardType save( CardType cardType)
    {
        return cardTypeRepository.save( cardType );
    }

    @Override
    public CardType update( CardType cardType )
    {
        return save( cardType);
    }

    @Override
    public void delete( Integer id )
    {
        cardTypeRepository.deleteById( id );
    }

}
