package org.lesson.java.menu.restaurant_menu.controller;

import java.util.List;

import org.lesson.java.menu.restaurant_menu.model.Allergen;
import org.lesson.java.menu.restaurant_menu.model.Plate;
import org.lesson.java.menu.restaurant_menu.service.AllergenService;
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
@RequestMapping("/allergens")
public class AllergenController {

    @Autowired
    private AllergenService allergenService;

    @GetMapping
    public String home(Model model) {
        List<Allergen> allergen = allergenService.findAll();
        model.addAttribute("allergens", allergen);
        return "allergen/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("allergen", new Allergen());
        model.addAttribute("edit", false);
        return "allergen/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("allergen") Allergen formAllergen, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {

            model.addAttribute("edit", false);

            return "allergen/create-or-edit";
        }
        allergenService.create(formAllergen);

        return "redirect:/allergens";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("allergen", allergenService.findById(id));
        model.addAttribute("edit", true);

        return "allergen/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("allergen") Allergen formallergen, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);

            return "allergen/create-or-edit";
        }
        allergenService.update(formallergen);

        return "redirect:/allergens";

    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {

        Allergen allergen = allergenService.findById(id);
        for (Plate allergenInPlate : allergen.getPlates()) {
            allergenInPlate.getAllergens().remove(allergen);
        }

        allergenService.destroy(allergen);

        return "redirect:/allergens";
    }

}
