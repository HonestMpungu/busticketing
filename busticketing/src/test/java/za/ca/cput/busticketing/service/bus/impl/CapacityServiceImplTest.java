package za.ca.cput.busticketing.service.bus.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import za.ca.cput.busticketing.entity.bus.Capacity;
import za.ca.cput.busticketing.factory.busfactory.CapacityFactory;


@TestMethodOrder(MethodOrderer.MethodName.class)
class CapacityServiceImplTest {

    private static CapacityServiceImpl service = null;
    private static Capacity capacity= CapacityFactory.create("MecerBus", "150");

    @Test
    void save() {
        Capacity created = service.save(capacity);
        assertEquals(capacity.getId(), created.getId());
        System.out.println("Created:" + created);
    }

    @Test
    void update() {
        Capacity updated = new Capacity.Builder ().copy(capacity).setId("MecerBus").build();
        assertNotNull(service.update(updated));
        System.out.println("Update:" + updated);

    }
}