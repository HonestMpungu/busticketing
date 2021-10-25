package za.ca.cput.busticketing.factory.user;


import za.ca.cput.busticketing.entity.user.User;

/**
 *  @author M Manyati
 *  Student No:215211855
 *  Group:Part Time
 *  User Factory Class
 */

public class UserFactory {

    public static User build(String firstname, String lastname, String phone, String email, String password) {
        return new User.Builder()
                .setFirstname(firstname)
                .setLastname(lastname)
                .setPhone(phone)
                .setEmail(email)
                .setPassword(password)
                .build();
    }

}
