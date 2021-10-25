package za.ca.cput.busticketing.factory.route;

import za.ca.cput.busticketing.entity.route.BusStop;

public class BusStopFactory {
    public static BusStop create(String name, String description) {
        return new BusStop.Builder()
                .setName(name)
                .setDescription(description)
                .build();

    }
}

