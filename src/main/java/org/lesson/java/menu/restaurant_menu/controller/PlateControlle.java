package org.lesson.java.menu.restaurant_menu.controller;

import java.util.List;

import org.lesson.java.menu.restaurant_menu.model.Plate;
import org.lesson.java.menu.restaurant_menu.service.AllergenService;
import org.lesson.java.menu.restaurant_menu.service.CourseService;
import org.lesson.java.menu.restaurant_menu.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/plates")
public class PlateControlle {

    @Autowired
    private PlateService plateService;

    @Autowired
    private AllergenService allergenService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String home(Model model) {
        List<Plate> plates = plateService.findAll();
        model.addAttribute("plates", plates);
        return "plates/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Plate plate = plateService.findById(id);

        model.addAttribute("plate", plate);
        return "plates/show";
    }

    @GetMapping("/create")

    public String create(Model model) {
        model.addAttribute("plate", new Plate());
        model.addAttribute("allergens", allergenService.findAll());
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("edit", false);
        return "plates/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("plate") Plate formPlate, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("allergens", allergenService.findAll());
            model.addAttribute("courses", courseService.findAll());
            model.addAttribute("edit", false);

            return "plates/create-or-edit";
        }
        plateService.create(formPlate);

        return "redirect:/plates";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("plate", plateService.findById(id));
        model.addAttribute("allergens", allergenService.findAll());
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("edit", true);

        return "plates/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("plate") Plate formPlate, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("allergens", allergenService.findAll());
            model.addAttribute("courses", courseService.findAll());
            model.addAttribute("edit", false);

            return "plates/create-or-edit";
        }
        plateService.update(formPlate);

        return "redirect:/plates";

    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {

        plateService.destroy(id);

        return "redirect:/plates";
    }

}
