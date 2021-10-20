package za.ca.cput.busticketing.service.route.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.route.Route;
import za.ca.cput.busticketing.repository.route.RouteRepository;
import za.ca.cput.busticketing.service.route.RouteService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */

@Service
public class RouteServiceImpl implements RouteService
{

	private RouteRepository routeRepository;

	@Autowired
	public RouteServiceImpl( RouteRepository routeRepository) {
		this.routeRepository = routeRepository;
	}


	@Override
	public List<Route> getAllRoutes()
	{
		List<Route> routes = new ArrayList<Route>();
		routeRepository.findAll().forEach(routes::add);
		return routes;
	}

	@Override
	public Optional<Route> getByID(Integer id )
	{
		return routeRepository.findById(id);
	}

	@Override
	public Route save(Route route )
	{
		routeRepository.save( route );
		return route;
	}

	@Override
	public Route update( Route route )
	{
		save(route);
		return route;
	}

	@Override
	public void delete( Integer id )
	{
		routeRepository.deleteById(id);
	}

}
