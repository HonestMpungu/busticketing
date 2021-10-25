package za.ca.cput.busticketing.factory.route;

import za.ca.cput.busticketing.entity.route.BusRoute;

public class BusRouteFactory {
    public static BusRoute create(String name, String description) {
        return new BusRoute.Builder()
                .setName(name)
                .setDescription(description)
                .build();

    }
}

