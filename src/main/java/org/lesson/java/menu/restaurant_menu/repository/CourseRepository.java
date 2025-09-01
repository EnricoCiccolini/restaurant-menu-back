package org.lesson.java.menu.restaurant_menu.repository;

import org.lesson.java.menu.restaurant_menu.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
