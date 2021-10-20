package za.ca.cput.busticketing.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.user.UserCard;
import za.ca.cput.busticketing.repository.user.UserCardRepository;
import za.ca.cput.busticketing.service.user.UserCardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * UserCardServiceImpl class
 */
@Service
public class UserCardServiceImpl implements UserCardService {
    private UserCardRepository userCardRepository;

    @Autowired
    public UserCardServiceImpl(UserCardRepository busRepository) {
        this.userCardRepository = userCardRepository;
    }

    @Override
    public List<UserCard> getAllUserCards()
    {
        List<UserCard> userCards = new ArrayList<UserCard>();
        userCardRepository.findAll().forEach(userCards::add);
        return userCards;
    }

    @Override
    public Optional<UserCard> getByID(Integer id )
    {
        return userCardRepository.findById(id);
    }

    @Override
    public UserCard save( UserCard userCard )
    {
        userCardRepository.save(userCard);
        return userCard;
    }

    @Override
    public UserCard update( UserCard userCard)
    {
        save(userCard);
        return userCard;
    }

    @Override
    public void delete( Integer id )
    {
        userCardRepository.deleteById(id);
    }
}
