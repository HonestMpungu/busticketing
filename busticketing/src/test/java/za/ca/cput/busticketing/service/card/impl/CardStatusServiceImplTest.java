package za.ca.cput.busticketing.service.card.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ca.cput.busticketing.entity.card.CardStatus;
import za.ca.cput.busticketing.factory.card.CardStatusFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 *
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class CardStatusServiceImplTest {

  private static CardStatusServiceImpl service = null;
    private static CardStatus cardStatus= CardStatusFactory.build("Munya","Student");

    @Test
    void save() {
        CardStatus created = service.save(cardStatus);
        assertEquals(cardStatus.getId(), created.getId());
        System.out.println("Created:" + created);
    }

    @Test
    void update() {
        CardStatus updated = new CardStatus.Builder().copy(cardStatus).setId(3434).build();
        assertNotNull(service.update(updated));
        System.out.println("Update:" + updated);

    }

}