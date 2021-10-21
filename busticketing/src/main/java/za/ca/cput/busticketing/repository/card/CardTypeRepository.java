package za.ca.cput.busticketing.repository.card;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.card.CardType;
/**
 * @author Honest Mpungu
 * Student No:215072081
 * Group:Part Time
 * 20/10/2021
 */

@Repository
public interface CardTypeRepository extends CrudRepository<CardType, Integer> {
}
