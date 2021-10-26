package za.ca.cput.busticketing.service.user.impl;

import za.ca.cput.busticketing.entity.user.UserIdentification;

/**
 * @author anongxa
 * Student No:204513723
 * 23/09/2021
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserIdentificationServiceImplTest {

  private static UserIdentificationServiceImpl service = null;
    private static UserIdentification userIdentification= UserIdentificationFactory.build();

    @Test
    void save() {
        UserIdentification created = service.save(UserIdentification);
        assertEquals(userIdentification.getId(), created.getId());
        System.out.println("Created:" + created);
    }

    @Test
    void update() {
        UserIdentification updated = new UserIdentification.Builder().copy(UserIdentification).setId(3434).build();
        assertNotNull(service.update(updated));
        System.out.println("Update:" + updated);

    }
}
