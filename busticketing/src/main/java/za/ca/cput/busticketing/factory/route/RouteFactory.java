package za.ca.cput.busticketing.factory.route;

import za.ca.cput.busticketing.entity.route.Route;

public class RouteFactory {
    public static Route create(String name, String description) {
        return new Route.Builder()
                .setName(name)
                .setDescription(description)
                .build();

    }
}
