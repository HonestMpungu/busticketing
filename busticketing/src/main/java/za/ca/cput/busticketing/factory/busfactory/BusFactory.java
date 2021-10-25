package za.ca.cput.busticketing.factory.busfactory;

import za.ca.cput.busticketing.entity.bus.Bus;

public class BusFactory {


    public static Bus create(String name, String description) {
        return new Bus.Builder()
                .setName(name)
                .setDescription(description)
                .build();

    }
}
