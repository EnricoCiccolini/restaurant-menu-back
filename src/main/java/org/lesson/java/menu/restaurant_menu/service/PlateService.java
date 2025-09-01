package org.lesson.java.menu.restaurant_menu.service;

import java.util.List;
import java.util.Optional;

import org.lesson.java.menu.restaurant_menu.model.Plate;
import org.lesson.java.menu.restaurant_menu.repository.PlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateService {

    @Autowired
    private PlateRepository plateRepository;

    public List<Plate> findAll() {

        return plateRepository.findAll();

    }

    public List<Plate> findAllByName(String name) {

        return plateRepository.findByNameContaining(name);

    }

    public Plate findById(Integer id) {

        return plateRepository.findById(id).get();

    }

    public Optional<Plate> findByIdOptional(Integer id) {
        return plateRepository.findById(id);
    }

    public Plate create(Plate plate) {

        return plateRepository.save(plate);

    }

    public Plate update(Plate plate) {

        return plateRepository.save(plate);

    }

    public void destroy(Integer id) {

        plateRepository.deleteById(id);

    }
}
