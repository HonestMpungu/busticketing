package za.ca.cput.busticketing.factory.busfactory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ca.cput.busticketing.entity.bus.BusCapacity;

class BusCapacityFactoryTest {

    @Test
    void createBusCapacity() {

        BusCapacity busCapacity = new BusCapacityFactory().create("Translux", "120 Available Seats");
        System.out.println(busCapacity);
        assertNotNull(busCapacity);

    }
}

