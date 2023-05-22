package com.arthycode.SpringRestApiHeladeria.controller;

import com.arthycode.SpringRestApiHeladeria.entity.Helado;
import com.arthycode.SpringRestApiHeladeria.service.HeladeriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/helado/api/v1")
@CrossOrigin("*")
public class HeladeriaController {
    @Autowired
    HeladeriaService heladeriaService;

    public HeladeriaController(HeladeriaService heladeriaService) {
        this.heladeriaService = heladeriaService;
    }
    @GetMapping(value = "/all")
    @Operation(summary = "Returns information about iceCream List.")
    public ResponseEntity<List<Helado>> findAllHel() {
        return heladeriaService.findAll();
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "Returns information about iceCream of Id.")
    public ResponseEntity<Optional<Helado>> findOneById(@Parameter(description = "Type Long") @PathVariable Long id) {
        return heladeriaService.findById(id);
    }

    @PostMapping(value = "/save")
    @Operation(summary = "Add a new Helado in the BD.")
    public ResponseEntity<Helado> addNew(@Parameter(description = "Helado Parameter") @RequestBody Helado helado) {
        return heladeriaService.addNew(helado);
    }

}
