package za.ca.cput.busticketing.factory.card;

import org.junit.jupiter.api.Test;
import za.ca.cput.busticketing.entity.card.CardStatus;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 *
 */
class CardStatusFactoryTest {

    @Test
    void create() {

         CardStatus cardStatus = new CardStatusFactory().build("Munya" , "Student");
        System.out.println(cardStatus);
        assertNotNull(cardStatus);

    }
}