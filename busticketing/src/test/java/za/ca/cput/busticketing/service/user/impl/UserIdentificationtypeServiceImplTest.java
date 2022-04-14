package za.ca.cput.busticketing.service.user.impl;

import za.ca.cput.busticketing.entity.user.UserIdentificationtype;

/**
 * @author anongxa
 * Student No:204513723
 * 23/09/2021
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserIdentificationtypeServiceImplTest {

  private static UserIdentificationtypeServiceImpl service = null;
    private static UserIdentificationtype userIdentificationtype= UserIdentificationtypeFactory.build();

    @Test
    void save() {
        UserIdentificationtype created = service.save(UserIdentificationtype);
        assertEquals(userIdentificationtype.getId(), created.getId());
        System.out.println("Created:" + created);
    }

    @Test
    void update() {
        UserIdentificationtype updated = new UserIdentificationtype.Builder().copy(UserIdentificationtype).setId(3434).build();
        assertNotNull(service.update(updated));
        System.out.println("Update:" + updated);

    }


}
