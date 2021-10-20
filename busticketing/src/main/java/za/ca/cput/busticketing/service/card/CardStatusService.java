package za.ca.cput.busticketing.service.card;

import za.ca.cput.busticketing.entity.card.CardStatus;

import java.util.List;
import java.util.Optional;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * CardStatusServiceImpl class
 */
public interface CardStatusService {
    List<CardStatus> getAllCardStatus();

    Optional<CardStatus> getByID(Integer id);

    CardStatus save(CardStatus cardStatus);

    CardStatus update(CardStatus cardStatus);

    void delete(Integer id);
}
