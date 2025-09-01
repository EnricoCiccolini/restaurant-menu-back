package org.lesson.java.menu.restaurant_menu.controller;

import java.util.List;
import java.util.Optional;

import org.lesson.java.menu.restaurant_menu.model.Plate;
import org.lesson.java.menu.restaurant_menu.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/plates/api")
public class PlateRestController {
    @Autowired
    private PlateService plateService;

    @GetMapping
    public ResponseEntity<List<Plate>> index(@RequestParam(name = "name", required = false) String name) {
        List<Plate> plates;

        if (name != null) {
            plates = plateService.findAllByName(name);
        } else {

            plates = plateService.findAll();
        }

        return new ResponseEntity<>(plates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plate> show(@PathVariable Integer id) {

        Optional<Plate> plate = plateService.findByIdOptional(id);
        if (plate.isEmpty()) {
            return new ResponseEntity<Plate>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Plate>(plate.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Plate> create(@RequestBody Plate plate) {

        return new ResponseEntity<Plate>(plateService.create(plate), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plate> update(@RequestBody Plate plate, @PathVariable Integer id) {
        Optional<Plate> plateFound = plateService.findByIdOptional(id);
        if (plateFound.isEmpty()) {
            return new ResponseEntity<Plate>(HttpStatus.NOT_FOUND);
        }
        plate.setId(id);
        return new ResponseEntity<Plate>(plateService.update(plate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Plate> delete(@PathVariable Integer id) {
        Optional<Plate> plates = plateService.findByIdOptional(id);
        if (plates.isEmpty()) {
            return new ResponseEntity<Plate>(HttpStatus.NOT_FOUND);
        }
        plateService.destroy(id);
        return new ResponseEntity<Plate>(HttpStatus.OK);
    }

}
