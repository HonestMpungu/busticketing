package za.ca.cput.busticketing.service.route.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ca.cput.busticketing.entity.route.BusRoute;
import za.ca.cput.busticketing.factory.route.BusRouteFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class BusRouteServiceImplTest {

    private static BusRouteServiceImpl service = null;
    private BusRoute busRoute = BusRouteFactory.create("Cape Town", "BlackTar");

    @Test
    public void save() {
        BusRoute created = service.save(busRoute);
        assertEquals(created.getName(), busRoute.getName());
        assertEquals(created.getDescription(), busRoute.getDescription());

        System.out.println("Create: " + created);
    }



    @Test
    public void c_update() {
        BusRoute updated = new BusRoute.Builder().copy(busRoute).setDescription("BlackTar").build();
        //assertNotNull(service.update(updated));

        System.out.println("Update: " + updated);

    }


}