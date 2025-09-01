package org.lesson.java.menu.restaurant_menu.service;

import java.util.List;
import java.util.Optional;

import org.lesson.java.menu.restaurant_menu.model.Allergen;
import org.lesson.java.menu.restaurant_menu.repository.AllergenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllergenService {
    @Autowired
    private AllergenRepository allergenRepository;

    public List<Allergen> findAll() {

        return allergenRepository.findAll();

    }

    public Allergen findById(Integer id) {

        return allergenRepository.findById(id).get();

    }

    public Optional<Allergen> findByIdOptional(Integer id) {
        return allergenRepository.findById(id);
    }

    public Allergen create(Allergen allergen) {

        return allergenRepository.save(allergen);

    }

    public Allergen update(Allergen allergen) {

        return allergenRepository.save(allergen);

    }

    public void destroy(Allergen allergen) {

        allergenRepository.delete(allergen);
        ;

    }

}
