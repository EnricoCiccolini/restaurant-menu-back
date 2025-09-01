package org.lesson.java.menu.restaurant_menu.repository;

import java.util.List;

import org.lesson.java.menu.restaurant_menu.model.Plate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateRepository extends JpaRepository<Plate, Integer> {
    public List<Plate> findByNameContaining(String name);
}
