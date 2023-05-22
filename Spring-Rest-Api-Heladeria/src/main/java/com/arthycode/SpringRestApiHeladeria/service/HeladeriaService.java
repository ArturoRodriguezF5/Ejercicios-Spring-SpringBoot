package com.arthycode.SpringRestApiHeladeria.service;

import com.arthycode.SpringRestApiHeladeria.entity.Helado;
import com.arthycode.SpringRestApiHeladeria.repository.HeladeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HeladeriaService {
    @Autowired
    HeladeriaRepository heladeriaRepository;

    public HeladeriaService(HeladeriaRepository heladeriaRepository) {
        this.heladeriaRepository = heladeriaRepository;
    }

    public ResponseEntity<List<Helado>> findAll() {
        return ResponseEntity.ok(heladeriaRepository.findAll());
    }
}
