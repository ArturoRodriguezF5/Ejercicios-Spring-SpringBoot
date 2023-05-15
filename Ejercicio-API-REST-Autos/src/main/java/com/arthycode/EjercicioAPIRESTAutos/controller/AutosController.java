package com.arthycode.EjercicioAPIRESTAutos.controller;

import com.arthycode.EjercicioAPIRESTAutos.entities.Auto;
import com.arthycode.EjercicioAPIRESTAutos.repository.AutosRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutosController {

    // Parameters encapsulated
    private final AutosRepository auRepo;
    private Logger log = LoggerFactory.getLogger(AutosController.class);

    // Construct
    public AutosController(AutosRepository auRepo) {
        this.auRepo = auRepo;
    }
    /*
     * Public methods for REST API operations
     */

    /**
     * Method for retrieving the autos repository
     * @return List of autos repository
     */
    @GetMapping("/api/autos")
    @Operation(summary = "Get autos repository")
    public ResponseEntity<List<Auto>> findAll() {
        return ResponseEntity.ok(auRepo.findAll());
    }

    /**
     * Method for find one auto in repository
     * @return Auto Object
     */
    @GetMapping("/api/autos/{id}")
    @Operation(summary = "Find an autos by ID")
    public ResponseEntity<Auto> findOneByID(@Parameter(description = "Long type Param.") @PathVariable Long id) {

        if (auRepo.count() == 0) {
            log.warn("Error no autos found");
            return ResponseEntity.notFound().build();
        }

        Optional<Auto> optAuto = auRepo.findById(id);
        return optAuto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Method for create an auto
     * @return Response Entity of Auto
     */
    @PostMapping("/api/autos")
    @Operation(summary = "Create and add an auto")
    public ResponseEntity<Auto> addAuto(@RequestBody Auto auto) {
        if (auto.getId() == null) {
            return ResponseEntity.ok(auRepo.save(auto));
        }
        log.warn("That Auto is already exists");
        return ResponseEntity.badRequest().build();
    }

    /**
     * Method for update an auto
     * @return Response Entity of Auto
     */
    @PutMapping("/api/autos")
    @Operation(summary = "Update a car")
    public ResponseEntity<Auto> updAuto(@RequestBody Auto auto) {
        if (auto.getId() == null) {
            log.warn("Error, please insert an ID");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(auRepo.save(auto));
    }

    /**
     * Method for delete an auto
     * @return Response Entity of Auto
     */
    @DeleteMapping("/api/autos/{id}")
    @Operation(summary = "Delete an auto by id")
    public ResponseEntity<Auto> deleteAuto(@Parameter(description = "id Long type") @PathVariable Long id) {
        if(id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        if(auRepo.existsById(id)) {
            auRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Method for delete all autos
     * @return Response Entity of String param
     */
    @DeleteMapping("/api/autos")
    @Operation(summary = "Delete all autos")
    public ResponseEntity<String> deleteAll() {
        if (auRepo.count() == 0) {
            return ResponseEntity.noContent().build();
        }
        auRepo.deleteAll();
        return ResponseEntity.ok("Ok, the bd has been deleted");
    }

}
