package za.ca.cput.busticketing.factory.busfactory;

import za.ca.cput.busticketing.entity.bus.BusCapacity;


public class BusCapacityFactory {

        public static BusCapacity create(String name, String description) {
            return new BusCapacity.Builder()
                    .setName(name)
                    .setDescription(description)
                    .build();

        }
}