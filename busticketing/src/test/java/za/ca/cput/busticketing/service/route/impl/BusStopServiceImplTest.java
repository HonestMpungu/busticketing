package za.ca.cput.busticketing.service.route.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ca.cput.busticketing.entity.route.BusRoute;
import za.ca.cput.busticketing.entity.route.BusStop;
import za.ca.cput.busticketing.factory.route.BusRouteFactory;
import za.ca.cput.busticketing.factory.route.BusStopFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BusStopServiceImplTest {

    private static BusStopServiceImpl service = null;
    private BusStop busStop = BusStopFactory.create("Cape Town", "BlackTar");

    @Test
    public void save() {
        BusStop created = service.save(busStop);
        assertEquals(created.getName(), busStop.getName());
        assertEquals(created.getDescription(), busStop.getDescription());

        System.out.println("Create: " + created);
    }



    @Test
    public void c_update() {
        BusStop updated = new BusStop.Builder().copy(busStop).setDescription("BlackTar").build();
        //assertNotNull(service.update(updated));

        System.out.println("Update: " + updated);

    }


}