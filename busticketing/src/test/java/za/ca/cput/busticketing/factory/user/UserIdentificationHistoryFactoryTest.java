package za.ca.cput.busticketing.factory.user;

/**
 * @author anongxa
 * Student No:204513723
 * 23/09/2021
 */
public class UserIdentificationHistoryFactoryTest {

    @Test
    void create() {

         UserIdentificationHistory userIdentificationHistory = new UserIdentificationHistoryFactory().build();
        System.out.println(userIdentificationHistory);
        assertNotNull(userIdentificationHistory);

    }

}
