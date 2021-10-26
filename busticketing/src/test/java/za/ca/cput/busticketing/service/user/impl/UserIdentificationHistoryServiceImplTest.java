package za.ca.cput.busticketing.service.user.impl;


import za.ca.cput.busticketing.entity.user.UserIdentificationHistory;

/**
 * @author anongxa
 * Student No:204513723
 * 23/09/2021
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserIdentificationHistoryServiceImplTest {

  private static UserIdentificationHistoryServiceImpl service = null;
    private static UserIdentificationHistory userIdentificationHistory= UserIdentificationHistoryFactory.build();

    @Test
    void save() {
        UserIdentificationHistory created = service.save(UserIdentificationHistory);
        assertEquals(userIdentificationHistory.getId(), created.getId());
        System.out.println("Created:" + created);
    }

    @Test
    void update() {
        UserIdentificationHistory updated = new UserIdentificationHistory.Builder().copy(UserIdentificationHistory.setId(3434).build();
        assertNotNull(service.update(updated));
        System.out.println("Update:" + updated);

    }


}
