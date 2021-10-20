package za.ca.cput.busticketing.repository.card;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.card.CardStatus;

/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * CardStatus Repository class
 */
@Repository
public interface CardStatusRepository extends CrudRepository<CardStatus, Integer> {
}
