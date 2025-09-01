package org.lesson.java.menu.restaurant_menu.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "plates")
public class Plate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "name cannot be null or empty")
    @Size(min = 2, max = 100, message = "must have a minimum of 2 characters and a maximum of 100")
    private String name;

    @Lob
    private String description;

    @Lob
    private String image;

    @NotNull(message = "price cannot be null or empty")
    @Positive
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "allergen_plate", joinColumns = @JoinColumn(name = "plate_id"), inverseJoinColumns = @JoinColumn(name = "allergen_id"))
    private List<Allergen> allergens;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Allergen> getAllergens() {
        return this.allergens;
    }

    public void setAllergens(List<Allergen> allergen) {
        this.allergens = allergen;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
