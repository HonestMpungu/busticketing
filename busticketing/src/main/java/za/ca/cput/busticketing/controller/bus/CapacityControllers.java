package za.ca.cput.busticketing.controller.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ca.cput.busticketing.entity.bus.Capacity;
import za.ca.cput.busticketing.service.bus.CapacityService;


import java.util.List;
import java.util.Optional;
/*
Author : Asanda Mabaso - 205049990
Date : 27 June 2021
 */
@Controller
@RequestMapping(path="/capacity")
public class CapacityControllers {

    @Autowired
    private CapacityService capacityService;

    //display the list of capacity
    @GetMapping(path="/all")
    public String viewCapacityPage( Model model){
        List<Capacity> listCapacity = capacityService.getAllCapacity();
        model.addAttribute( "listOfCapacity" , listCapacity);
        return "capacity/show-capacity";
    }

    @PostMapping("/save")
    public String addCapacity(Capacity capacity, BindingResult result, Model model) {
        capacityService.save(capacity);
        return "redirect:/capacity/all";
    }

    //form to be called first when wanting to add a new capacity
    @GetMapping("/form")
    public String displayAddCapacityForm(Capacity capacity) {
        return "capacity/add-capacity";
    }

    @GetMapping("/updateform/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Optional<Capacity> capacity = capacityService.getByID(id);
        model.addAttribute("capacity", capacity.orElse( null ));
        return "capacity/update-capacity";
    }

    @PostMapping("/updater")
    public String updateCapacity(Capacity capacity, BindingResult result, Model model) {

        capacityService.update(capacity);
        return "redirect:/capacity/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCapacity(@PathVariable("id") Integer id, Model model) {
        Optional<Capacity> capacity = capacityService.getByID( id );
        if(capacity.isPresent())
            capacityService.delete(capacity.get().getId());
        return "redirect:/capacity/all";
    }

}
