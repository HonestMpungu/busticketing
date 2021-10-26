package za.ca.cput.busticketing.factory.user;

/**
 * @author anongxa
 * Student No:204513723
 * 23/09/2021
 */

public class UserIdentificationFactoryTest {

    @Test
    void create() {

         UserIdentification userIdentification = new userIdentificationFactory().build();
        System.out.println(userIdentification);
        assertNotNull(userIdentification);

    }

}
