package za.ca.cput.busticketing.service.route.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ca.cput.busticketing.entity.route.BusRoute;
import za.ca.cput.busticketing.entity.route.Route;
import za.ca.cput.busticketing.factory.route.BusRouteFactory;
import za.ca.cput.busticketing.factory.route.RouteFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class RouteServiceImplTest {

    private static RouteServiceImpl service = null;
    private Route route = RouteFactory.create("Cape Town", "BlackTar");

    @Test
    public void save() {
        Route created = service.save(route);
        assertEquals(created.getName(), route.getName());
        assertEquals(created.getDescription(), route.getDescription());

        System.out.println("Create: " + created);
    }



    @Test
    public void c_update() {
        Route updated = new Route.Builder().copy(route).setDescription("BlackTar").build();
        //assertNotNull(service.update(updated));

        System.out.println("Update: " + updated);

    }

}