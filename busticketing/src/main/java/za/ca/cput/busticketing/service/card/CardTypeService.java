package za.ca.cput.busticketing.service.card;
;
import za.ca.cput.busticketing.entity.card.CardType;

import java.util.List;
import java.util.Optional;
/**
 * @author Honest Mpungu
 * Student No:215072081
 * 20/10/2022
 * Group:Part Time
 */
public interface CardTypeService {
    List<CardType> getAll();

    Optional<CardType> getByID(Integer id);

    CardType save(CardType cardType);

    CardType update(CardType cardType);

    void delete(Integer id);
}
