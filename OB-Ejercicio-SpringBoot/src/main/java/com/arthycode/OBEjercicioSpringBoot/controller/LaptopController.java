package com.arthycode.OBEjercicioSpringBoot.controller;

import com.arthycode.OBEjercicioSpringBoot.entity.Laptop;
import com.arthycode.OBEjercicioSpringBoot.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    // Atributos
    private LaptopRepository laptopRepository;

    // Constructor
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    // Métodos para CRUD de LaptopRepository

    // Método para Obetener las Laptops que existen en el repo
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }
    // Método para agregar una laptop nueva en la BD
    @PostMapping("/api/laptops")
    public Laptop crearLaptop(@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }
    // Método para buscar una Laptop por id en la BD

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id) {
        Optional<Laptop> otpLap = laptopRepository.findById(id);
        if (otpLap.isPresent()) {
            return ResponseEntity.ok(otpLap.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
