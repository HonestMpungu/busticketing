package za.ca.cput.busticketing.service.bus;
/*

Author : Asanda Mabaso - 205049990

 */
import za.ca.cput.busticketing.entity.bus.Bus;
import za.ca.cput.busticketing.entity.bus.Capacity;

import java.util.List;
import java.util.Optional;

public interface CapacityService {
    List<Capacity> getAllCapacity();

    Optional<Capacity> getByID(Integer id);

    Capacity save(Capacity capacity);

    Capacity update(Capacity capacity);

    void delete(Integer id);

}
