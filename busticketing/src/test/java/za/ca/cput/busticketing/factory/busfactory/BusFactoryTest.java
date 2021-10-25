package za.ca.cput.busticketing.factory.busfactory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ca.cput.busticketing.entity.bus.Bus;

class BusFactoryTest {


    @Test
    void createBus() {

        Bus bus = new BusFactory().create("MecerBus", "book");
        assertNotNull(bus.getId());System.out.println("actual Value : " +bus.getId().toString() + "   Expected : not Null");//Testing if the ID is being Generated
        assertEquals(bus.getName(),"MecerBus"); System.out.println("actual Value : " +bus.getName().toString() + "  Expected : MecerBus" );
        assertEquals(bus.getDescription(),"book"); System.out.println("actual Value : " +bus.getDescription().toString() + "   Expected : book" );
        assertNotNull(bus.getDescription());
    }
}