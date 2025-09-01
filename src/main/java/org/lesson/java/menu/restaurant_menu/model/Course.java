package org.lesson.java.menu.restaurant_menu.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "courses")
@JsonIgnoreProperties({ "plates" })
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "name cannot be null or empty")
    @Size(min = 3, max = 100, message = "must have a minimum of 2 characters and a maximum of 100")
    private String name;

    @OneToMany(mappedBy = "course", cascade = (CascadeType.REMOVE))

    private List<Plate> plates;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plate> getPlates() {
        return this.plates;
    }

    public void setPlates(List<Plate> plates) {
        this.plates = plates;
    }

}
