package org.lesson.java.menu.restaurant_menu.repository;

import java.util.Optional;

import org.lesson.java.menu.restaurant_menu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
