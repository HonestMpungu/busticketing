package za.ca.cput.busticketing.factory.user;

import org.junit.jupiter.api.Test;
import za.ca.cput.busticketing.entity.user.UserCard;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 *
 */
class UserCardFactoryTest {

    @Test
    void create() {
        UserCard userCard = new UserCardFactory().build("Munya" , "Student");
        System.out.println(userCard);
        assertNotNull(userCard);
    }
}