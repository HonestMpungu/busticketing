package za.ca.cput.busticketing.service.route;
/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */

import za.ca.cput.busticketing.entity.route.BusStop;

import java.util.List;
import java.util.Optional;

public interface BusStopService {
    List<BusStop> getAllStops();

    Optional<BusStop> getByID(Integer id);

    BusStop save( BusStop busStop);

    BusStop update(BusStop busStop);

    void delete(Integer id);
}
