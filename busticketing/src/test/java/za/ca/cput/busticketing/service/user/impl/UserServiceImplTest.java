package za.ca.cput.busticketing.service.user.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ca.cput.busticketing.entity.user.User;
import za.ca.cput.busticketing.factory.user.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 *
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserServiceImplTest {

    private static User user= new UserFactory().build("Munya","Manyati", "0733333333", "manyMunya@gmail.com","#wwww");
    private static UserServiceImpl service = null;
    @Test
    void save() {
        User created = service.save(user);
        assertEquals(user.getId(), created.getId());
        System.out.println("Created:" + created);
    }

    @Test
    void update() {
        User updated = new User.Builder().copy(user).setId(3434).build();
        assertNotNull(service.update(updated));
        System.out.println("Update:" + updated);

    }
}