package za.ca.cput.busticketing.repository.route;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.route.BusRoute;
import za.ca.cput.busticketing.entity.route.Route;
/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */

@Repository
public interface RouteRepository  extends CrudRepository<Route, Integer> {
}
