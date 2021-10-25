package za.ca.cput.busticketing.service.bus.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ca.cput.busticketing.entity.bus.BusCapacity;
import za.ca.cput.busticketing.entity.bus.Capacity;
import za.ca.cput.busticketing.factory.busfactory.BusCapacityFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BusCapacityServiceImplTest {

    private static BusCapacityServiceImpl service = null;
    private static BusCapacity busCapacity= BusCapacityFactory.create("MecerBus", "150");

    @Test
    void save() {
        BusCapacity created = service.save(busCapacity);
        assertEquals(busCapacity.getId(), created.getId());
        System.out.println("Created:" + created);
    }

    @Test
    void update() {
        BusCapacity updated = new BusCapacity.Builder().copy(busCapacity).setId("MecerBus").build();
        assertNotNull(service.update(updated));
        System.out.println("Update:" + updated);

    }
}