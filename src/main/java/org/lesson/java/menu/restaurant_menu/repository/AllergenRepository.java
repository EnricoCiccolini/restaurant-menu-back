package org.lesson.java.menu.restaurant_menu.repository;

import org.lesson.java.menu.restaurant_menu.model.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergenRepository extends JpaRepository<Allergen, Integer> {

}
