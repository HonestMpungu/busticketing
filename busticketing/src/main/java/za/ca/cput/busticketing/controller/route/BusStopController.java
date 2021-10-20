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
import za.ca.cput.busticketing.entity.route.BusStop;
import za.ca.cput.busticketing.service.route.BusRouteService;
import za.ca.cput.busticketing.service.route.BusStopService;

import java.util.List;
import java.util.Optional;

/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */
@Controller
@RequestMapping(path="/busStop")
public class BusStopController {

    @Autowired
    private BusStopService busStopService;

    //display the list of BusStop
    @GetMapping(path="/all")
    public String viewBusStopPage( Model model){
        List<BusStop> listBusStop = busStopService.getAllStops();
        model.addAttribute( "listOfBusStop" , listBusStop);
        return "busStop/show-busStop";
    }

    @PostMapping("/save")
    public String addBusStop(BusStop busStop, BindingResult result, Model model) {
        busStopService.save(busStop);
        return "redirect:/busStop/all";
    }

    //form to be called first when wanting to add a new BusRoute
    @GetMapping("/form")
    public String displayAddBusRouteForm(BusRoute busRoute) {
        return "busRoute/add-busRoute";
    }

    @GetMapping("/updateform/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Optional<BusStop> busStops = busStopService.getByID(id);
        model.addAttribute("BusStop", busStops.orElse( null ));
        return "busStop/update-busStop";
    }

    @PostMapping("/updater")
    public String updateBusRoute(BusStop busStop, BindingResult result, Model model) {
        busStopService.update(busStop);
        return "redirect:/busStop/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBusStop(@PathVariable("id") Integer id, Model model) {
        Optional<BusStop> busStop = busStopService.getByID( id );
        if(busStop.isPresent())
            busStopService.delete(busStop.get().getId());
        return "redirect:/busStop/all";
    }
}
