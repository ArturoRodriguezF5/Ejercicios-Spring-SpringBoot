package com.arthycode.SpringRestApiHeladeria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Helado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String flavour;
    private Boolean cream;
    private Float price;

    public Helado() {
    }

    public Helado(Long id, String name, String flavour, Boolean cream, Float price) {
        this.id = id;
        this.name = name;
        this.flavour = flavour;
        this.cream = cream;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public Boolean getCream() {
        return cream;
    }

    public void setCream(Boolean cream) {
        this.cream = cream;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HeladeriaEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flavour='" + flavour + '\'' +
                ", cream=" + cream +
                ", price=" + price +
                '}';
    }
}
