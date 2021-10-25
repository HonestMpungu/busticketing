package za.ca.cput.busticketing.factory.busfactory;

import za.ca.cput.busticketing.entity.bus.Capacity;

public class CapacityFactory {


    public static Capacity create(String name, String description) {
        return new Capacity.Builder()
                .setName(name)
                .setDescription(description)
                .build();

    }
}
