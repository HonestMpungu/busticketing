package za.ca.cput.busticketing.controller.bus;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ca.cput.busticketing.entity.bus.BusCapacity;
import za.ca.cput.busticketing.service.bus.BusCapacityService;

import java.util.List;
import java.util.Optional;

/*

Author : Asanda Mabaso - 205049990

 */
@Controller
@RequestMapping(path="/buscapacity")
public class BusCapacityController {

    @Autowired
    private  BusCapacityService busCapacityService;

    //display the list of bus capacity
    @GetMapping(path="/all")
    public String viewBusCapacityPage( Model model){
        List<BusCapacity> listBusCapacity = busCapacityService.getAllBusCapacity();
        model.addAttribute( "listOfBusCapacity" , listBusCapacity);
        return "buscapacity/show-buscapacity";
    }

    @PostMapping("/save")
    public String addCapacity(BusCapacity busCapacity, BindingResult result, Model model) {
        busCapacityService.save(busCapacity);
        return "redirect:/buscapacity/all";
    }

    //form to be called first when wanting to add a new bus capacity
    @GetMapping("/form")
    public String displayAddBusCapacityForm(BusCapacity busCapacity) {
        return "buscapacity/add-buscapacity";
    }

    @GetMapping("/updateform/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Optional<BusCapacity> buscapacity = busCapacityService.getByID(id);
        model.addAttribute("buscapacity", buscapacity.orElse( null ));
        return "buscapacity/update-buscapacity";
    }

    @PostMapping("/updater")
    public String updateBusCapacity(BusCapacity buscapacity, BindingResult result, Model model) {

        busCapacityService.update(buscapacity);
        return "redirect:/buscapacity/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBusCapacity(@PathVariable("id") Integer id, Model model) {
        Optional<BusCapacity> buscapacity = busCapacityService.getByID( id );
        if(buscapacity.isPresent())
            busCapacityService.delete(buscapacity.get().getId());
        return "redirect:/buscapacity/all";
    }

}
