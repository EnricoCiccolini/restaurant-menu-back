package org.lesson.java.menu.restaurant_menu.service;

import java.util.List;
import java.util.Optional;

import org.lesson.java.menu.restaurant_menu.model.Course;
import org.lesson.java.menu.restaurant_menu.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {

        return courseRepository.findAll();

    }

    public Course findById(Integer id) {

        return courseRepository.findById(id).get();

    }

    public Optional<Course> findByIdOptional(Integer id) {
        return courseRepository.findById(id);
    }

    public Course create(Course plate) {

        return courseRepository.save(plate);

    }

    public Course update(Course plate) {

        return courseRepository.save(plate);

    }

    public void destroy(Integer id) {

        courseRepository.deleteById(id);

    }
}
