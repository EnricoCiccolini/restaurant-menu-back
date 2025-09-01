package org.lesson.java.menu.restaurant_menu.controller;

import java.util.List;

import org.lesson.java.menu.restaurant_menu.model.Course;
import org.lesson.java.menu.restaurant_menu.service.CourseService;
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
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String home(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "course/index";
    }

    @GetMapping("/create")

    public String create(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("edit", false);
        return "course/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("course") Course formCourse, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            model.addAttribute("courses", courseService.findAll());
            model.addAttribute("edit", false);

            return "plates/create-or-edit";
        }
        courseService.create(formCourse);

        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("course", courseService.findById(id));
        model.addAttribute("edit", true);

        return "course/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("course") Course formCourse, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", true);

            return "course/create-or-edit";
        }
        courseService.update(formCourse);

        return "redirect:/courses";

    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {

        courseService.destroy(id);

        return "redirect:/courses";
    }
}
