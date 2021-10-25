package za.ca.cput.busticketing.repository.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.route.BusRoute;
import za.ca.cput.busticketing.entity.route.BusStop;
/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */

@Repository
public interface BusStopRepository  extends CrudRepository<BusStop, Integer> {
}
