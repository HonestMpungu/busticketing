package za.ca.cput.busticketing.service.bus;

import za.ca.cput.busticketing.entity.bus.BusCapacity;

import java.util.List;
import java.util.Optional;

public interface BusCapacityService {

    List<BusCapacity> getAllBusCapacity();

    Optional<BusCapacity> getByID(Integer id);

    BusCapacity save(BusCapacity busCapacity);

    BusCapacity update(BusCapacity busCapacity);

    void delete(Integer id);
}
