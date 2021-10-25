package za.ca.cput.busticketing.factory.user;

import za.ca.cput.busticketing.entity.user.UserCard;

public class UserCardFactory {
    public static UserCard build(String name, String description) {
        return new UserCard.Builder()
                .setName(name)
                .setDescription(description)
                .build();
    }
}
