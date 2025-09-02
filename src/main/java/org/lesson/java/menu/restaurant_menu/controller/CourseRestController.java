package org.lesson.java.menu.restaurant_menu.controller;

import java.util.List;

import org.lesson.java.menu.restaurant_menu.model.Course;
import org.lesson.java.menu.restaurant_menu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/courses/api")
public class CourseRestController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> index() {
        List<Course> course;

        course = courseService.findAll();

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

}
