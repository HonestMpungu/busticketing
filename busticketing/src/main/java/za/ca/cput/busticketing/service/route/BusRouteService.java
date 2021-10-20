package za.ca.cput.busticketing.service.route;

import za.ca.cput.busticketing.entity.route.BusRoute;

import java.util.List;
import java.util.Optional;

/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */
public interface BusRouteService {
    List<BusRoute> getAllBusRoutes();

    Optional<BusRoute> getByID(Integer id);

    BusRoute save( BusRoute busRoute);

    BusRoute update(BusRoute busRoute);

    void delete(Integer id);

}
