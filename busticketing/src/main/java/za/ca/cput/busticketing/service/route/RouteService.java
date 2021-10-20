package za.ca.cput.busticketing.service.route;

import za.ca.cput.busticketing.entity.route.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService
{
	List<Route> getAllRoutes();

	Optional<Route> getByID(Integer id);

	Route save( Route route);

	Route update(Route route);

	void delete(Integer id);
}
