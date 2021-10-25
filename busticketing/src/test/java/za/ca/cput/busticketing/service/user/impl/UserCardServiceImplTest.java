package za.ca.cput.busticketing.service.user.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ca.cput.busticketing.entity.user.UserCard;
import za.ca.cput.busticketing.factory.user.UserCardFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 *
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserCardServiceImplTest {

    private static UserCardServiceImpl service = null;
    private static UserCard userCard= UserCardFactory.build("Munya", "Student");

    @Test
    void update() {
        UserCard updated = new UserCard.Builder().copy(userCard).setId(3434).build();
        assertNotNull(service.update(updated));
        System.out.println("Update:" + updated);

    }
    @Test
    void save() {

        UserCard created = service.save(userCard);
        assertEquals(userCard.getId(), created.getId());
        System.out.println("Created:" + created);
    }

    @Test
    void delete() {
    }
}