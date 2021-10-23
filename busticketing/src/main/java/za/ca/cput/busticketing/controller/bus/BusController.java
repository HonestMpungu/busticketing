package za.ca.cput.busticketing.controller.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ca.cput.busticketing.entity.bus.Bus;
import za.ca.cput.busticketing.service.bus.BusService;

import java.util.List;
import java.util.Optional;
/*

Author : Asanda Mabaso - 205049990

 */
@Controller
@RequestMapping(path="/bus")
public class BusController {

	@Autowired
	private BusService busService;

	//display the list of buses
	@GetMapping(path="/all")
	public String viewBussPage( Model model){
		List<Bus> listBuses = busService.getAllBuses();
		model.addAttribute( "listOfBuses" , listBuses);
		return "bus/show-bus";
	}

	@PostMapping("/save")
	public String addBus(Bus bus, BindingResult result, Model model) {
		busService.save(bus);
		return "redirect:/bus/all";
	}

	//form to be called first when wanting to add a new Bus
	@GetMapping("/form")
	public String displayAddBusForm(Bus bus) {
		return "bus/add-bus";
	}

	@GetMapping("/updateform/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Optional<Bus> bus = busService.getByID(id);
		model.addAttribute("bus", bus.orElse( null ));
		return "bus/update-bus";
	}

	@PostMapping("/updater")
	public String updateBus(Bus bus, BindingResult result, Model model) {

		busService.update(bus);
		return "redirect:/bus/all";
	}

	@GetMapping("/delete/{id}")
	public String deleteBus(@PathVariable("id") Integer id, Model model) {
		Optional<Bus> bus = busService.getByID( id );
		if(bus.isPresent())
			busService.delete(bus.get().getId());
		return "redirect:/bus/all";
	}

}
