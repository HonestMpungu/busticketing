package za.ca.cput.busticketing.service.bus.impl;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import za.ca.cput.busticketing.entity.bus.Bus;
import za.ca.cput.busticketing.entity.bus.BusCapacity;
import za.ca.cput.busticketing.factory.busfactory.BusFactory;


@TestMethodOrder(MethodOrderer.MethodName.class)
class BusServiceImplTest {

    private static BusServiceImpl service = null;
    private static Bus bus= BusFactory.create("MecerBus", "150");

    @Test
    void save() {
        Bus created = service.save(bus);
        assertEquals(bus.getId(), created.getId());
        System.out.println("Created:" + created);
    }

    @Test
    void update() {
        Bus updated = new Bus.Builder().copy(bus).setId("MecerBus").build();
        assertNotNull(service.update(updated));
        System.out.println("Update:" + updated);

    }
}