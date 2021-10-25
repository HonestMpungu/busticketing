package za.ca.cput.busticketing.factory.user;

import org.junit.jupiter.api.Test;
import za.ca.cput.busticketing.entity.user.User;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 *
 */
class UserFactoryTest {

    @Test
    void create() {

        User user = new UserFactory().build("Munya", "Manyati","07738098","mm@gmail.comm", "ttttttt");
        assertNotNull(user.getId());
        System.out.println("actual Value : " +user.getId().toString() + "   Expected : not Null");//Testing if the ID is being Generated
        assertEquals(user.getFirstName(),"Munya");
         System.out.println("actual Value : " +user.getLastName().toString() + "  Expected : Manyati" );
        assertEquals(user.getFirstName(),"Munya");
         System.out.println("actual Value : " +user.getPhone().toString() + "   Expected : 07738098" );
        assertNotNull(user.getFirstName());

    }
}