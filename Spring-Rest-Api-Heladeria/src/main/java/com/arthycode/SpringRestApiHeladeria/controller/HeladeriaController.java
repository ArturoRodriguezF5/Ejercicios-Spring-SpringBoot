package com.arthycode.SpringRestApiHeladeria.controller;

import com.arthycode.SpringRestApiHeladeria.entity.Helado;
import com.arthycode.SpringRestApiHeladeria.service.HeladeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeladeriaController {
    @Autowired
    HeladeriaService heladeriaService;

    public HeladeriaController(HeladeriaService heladeriaService) {
        this.heladeriaService = heladeriaService;
    }
    @GetMapping("/api/healados")
    public ResponseEntity<List<Helado>> findAllHel() {
        return heladeriaService.findAll();
    }
}
