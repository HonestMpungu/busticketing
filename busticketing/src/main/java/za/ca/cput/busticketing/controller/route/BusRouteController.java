package za.ca.cput.busticketing.controller.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ca.cput.busticketing.entity.route.BusRoute;
import za.ca.cput.busticketing.service.route.BusRouteService;

import java.util.List;
import java.util.Optional;

/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */
@Controller
@RequestMapping(path= "/templates/busRoute")
public class BusRouteController {

    @Autowired
    private BusRouteService busRouteService;

    //display the list of BusRoute
    @GetMapping(path="/all")
    public String viewBusRoutePage( Model model){
        List<BusRoute> listBusRoute = busRouteService.getAllBusRoutes();
        model.addAttribute( "listOfBusRoute" , listBusRoute);
        return "templates/busRoute/show-busRoute";
    }

    @PostMapping("/save")
    public String addBusRoute(BusRoute busRoute, BindingResult result, Model model) {
        busRouteService.save(busRoute);
        return "redirect:/busRoute/all";
    }

    //form to be called first when wanting to add a new BusRoute
    @GetMapping("/form")
    public String displayAddBusRouteForm(BusRoute busRoute) {
        return "templates/busRoute/add-busRoute";
    }

    @GetMapping("/updateform/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Optional<BusRoute> busRoutes = busRouteService.getByID(id);
        model.addAttribute("BusRoute", busRoutes.orElse( null ));
        return "templates/busRoute/update-busRoute";
    }

    @PostMapping("/updater")
    public String updateBusRoute(BusRoute busRoute, BindingResult result, Model model) {
        busRouteService.update(busRoute);
        return "redirect:/busRoute/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBusRoute(@PathVariable("id") Integer id, Model model) {
        Optional<BusRoute> busRoute = busRouteService.getByID( id );
        if(busRoute.isPresent())
            busRouteService.delete(busRoute.get().getId());
        return "redirect:/busRoute/all";
    }

}
