package za.ca.cput.busticketing.repository.bus;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.bus.BusCapacity;
/*

Author : Asanda Mabaso - 205049990

 */
@Repository
public interface BusCapacityRepository  extends CrudRepository<BusCapacity, Integer> {
}
