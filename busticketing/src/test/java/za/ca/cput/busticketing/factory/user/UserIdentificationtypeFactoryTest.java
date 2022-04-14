package za.ca.cput.busticketing.factory.user;

/**
 * @author anongxa
 * Student No:204513723
 * 23/09/2021
 */


public class UserIdentificationtypeFactoryTest {

    @Test
    void create() {

         UserIdentificationtype userIdentificationtype = new userIdentificationtypeFactory().build();
        System.out.println(userIdentificationtype);
        assertNotNull(userIdentificationtype);

    }
}
