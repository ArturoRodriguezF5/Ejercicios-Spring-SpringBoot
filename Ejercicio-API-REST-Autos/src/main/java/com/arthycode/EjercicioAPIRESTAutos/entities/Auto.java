package com.arthycode.EjercicioAPIRESTAutos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class  Auto {

    // Parameters for this object are encapsulated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private Integer cylinders;
    private Boolean electric;
    // Constructors for this class
    public Auto() {
    }
    public Auto(Long id, String brand, String model, Integer cylinders, Boolean electric) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.cylinders = cylinders;
        this.electric = electric;
    }
    // Getters and setters for this class

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCylinders() {
        return cylinders;
    }

    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    public Boolean getElectric() {
        return electric;
    }

    public void setElectric(Boolean electric) {
        this.electric = electric;
    }
    // Methods, toString

    @Override
    public String toString() {
        return "Auto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", cylinders=" + cylinders +
                ", electric=" + electric +
                '}';
    }
}
