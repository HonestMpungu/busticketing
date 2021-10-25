package za.ca.cput.busticketing.factory.card;

import za.ca.cput.busticketing.entity.card.CardStatus;

public class CardStatusFactory {
    public static CardStatus build(String name, String description) {
        return new CardStatus.Builder()
                .setName(name)
                .setDescription(description)
                .build();

    }
}
