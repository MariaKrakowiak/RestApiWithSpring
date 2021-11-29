package com.example.mywebapp.bike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BikeController {

    @Autowired
    private BikeService service;

    @GetMapping("/bikes")
    public String showBikeList(Model model) {
        List<Bike> listBikes = service.listAll();
        model.addAttribute("listBikes", listBikes);
        return "bikes";
    }

    @GetMapping("/bikes/new")
    public String showNewForm(Model model) {
        model.addAttribute("bike", new Bike());
        model.addAttribute("pageTitle", "Add new bike");
        return "bike_form";
    }

    @PostMapping("/bikes/save")
    public String saveBike(Bike bike, RedirectAttributes ra) {
        service.save(bike);
        ra.addFlashAttribute("message", "The bike with id " + bike.getId() +" has been added successfully!");
        return "redirect:/bikes";
    }

    @GetMapping("/bikes/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Bike bike = service.get(id);
            model.addAttribute("bike", bike);
            model.addAttribute("pageTitle", "Edit bike (id: " + id + " )");
            return "bike_form";
        } catch (BikeNotFoundException e) {

            ra.addFlashAttribute("message", "There is no bike with id " + id);
            return "redirect:/bikes";
        }
    }

    @GetMapping("/bikes/delete/{id}")
    public String deleteBike(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The bike with id " + id + " has been deleted.");
        } catch (BikeNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/bikes";
    }


}


