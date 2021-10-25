package za.ca.cput.busticketing.factory.busfactory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import za.ca.cput.busticketing.entity.bus.Capacity;



class CapacityFactoryTest {

    @Test
    void createCapacity() {

        Capacity capacity = new CapacityFactory().create("MecerBus", "150");
        assertNotNull(capacity.getId());System.out.println("actual Value : " +capacity.getId().toString() + "   Expected : not Null");//Testing if the ID is being Generated
        assertEquals(capacity.getName(),"MecerBus"); System.out.println("actual Value : " +capacity.getName().toString() + "  Expected : MecerBus" );
        assertEquals(capacity.getDescription(),"150"); System.out.println("actual Value : " +capacity.getDescription().toString() + "   Expected : 150" );
        assertNotNull(capacity.getDescription());
    }
}