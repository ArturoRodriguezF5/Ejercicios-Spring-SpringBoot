package com.arthycode.SpringRestApiHeladeria.service;

import com.arthycode.SpringRestApiHeladeria.entity.Helado;
import com.arthycode.SpringRestApiHeladeria.repository.HeladeriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HeladeriaService {
    Logger log = LoggerFactory.getLogger(HeladeriaService.class);
    @Autowired
    HeladeriaRepository heladeriaRepository;

    public HeladeriaService(HeladeriaRepository heladeriaRepository) {
        this.heladeriaRepository = heladeriaRepository;
    }

    public ResponseEntity<List<Helado>> findAll() {

        if (heladeriaRepository.count() == 0) {
            log.warn("List is Empty.");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(heladeriaRepository.findAll());
    }

    public ResponseEntity<Optional<Helado>> findById(Long id) {
        if (id == null) {
            log.warn("Id is null.");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(heladeriaRepository.findById(id));
    }

    public ResponseEntity<Helado> addNew(Helado helado) {
        if (helado.getId() == null) {
            return ResponseEntity.ok(heladeriaRepository.save(helado));
        }
        return ResponseEntity.badRequest().build();
    }
}
