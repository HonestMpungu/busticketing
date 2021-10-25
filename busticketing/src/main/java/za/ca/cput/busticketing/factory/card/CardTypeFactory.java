package za.ca.cput.busticketing.factory.card;

import za.ca.cput.busticketing.entity.card.CardType;

import java.util.UUID;

public class CardTypeFactory {
    public static CardType create(String name, String description) {
        return new CardType.Builder()
                .setName(name)
                .setDescription(description)
                .setId(Integer.valueOf(UUID.randomUUID().toString()))
                .build();
    }
}
