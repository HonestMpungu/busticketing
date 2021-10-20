package za.ca.cput.busticketing.controller.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ca.cput.busticketing.entity.route.Route;
import za.ca.cput.busticketing.service.route.RouteService;


import java.util.List;
import java.util.Optional;
/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */
@Controller
@RequestMapping(path="/route")
public class RouteController
{

	@Autowired
	private RouteService routeService;

	//display the list of Routes
	@GetMapping(path="/all")
	public String viewRoutesPage( Model model){
		List<Route> listRoutes = routeService.getAllRoutes();
		model.addAttribute( "listOfRoutes" , listRoutes);
		return "route/show-route";
	}

	@PostMapping("/save")
	public String addRoute(Route route, BindingResult result, Model model) {
		routeService.save(route);
		return "redirect:/route/all";
	}

	//form to be called first when wanting to add a new Route
	@GetMapping("/form")
	public String displayAddRouteForm(Route route) {
		return "route/add-route";
	}

	@GetMapping("/updateform/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Optional<Route> route = routeService.getByID(id);
		model.addAttribute("route", route.orElse( null ));
		return "route/update-route";
	}

	@PostMapping("/updater")
	public String updateRoute(Route route, BindingResult result, Model model) {
		routeService.update(route);
		return "redirect:/route/all";
	}

	@GetMapping("/delete/{id}")
	public String deleteRoute(@PathVariable("id") Integer id, Model model) {
		Optional<Route> route = routeService.getByID( id );
		if(route.isPresent())
			routeService.delete(route.get().getId());
		return "redirect:/route/all";
	}

}
