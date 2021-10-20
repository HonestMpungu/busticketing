package za.ca.cput.busticketing.repository.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.route.BusStop;
/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */

@Repository
public interface BusStopRepository extends JpaRepository<BusStop,Integer> {
}
