package com.GeoTab.GeoTab.Users.controller;

import com.GeoTab.GeoTab.Users.entities.Coordinator;
import com.GeoTab.GeoTab.Users.services.imp.CoordinatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/coordinators")
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @PostMapping
    public ResponseEntity<Coordinator> createCoordinator(@RequestBody Coordinator coordinator) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.coordinatorService.createCoordinator(coordinator));
    }

    @GetMapping
    public ResponseEntity<List<Coordinator>> getAllCoordinators() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.coordinatorService.findAllCoordinators());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordinator> getCoordinatorById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.coordinatorService.findCoordinatorById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoordinator(@PathVariable Long id) {
        try {
            this.coordinatorService.deleteCoordinator(id);

            return ResponseEntity.status(HttpStatus.OK)
                    .body("Coordinator with ID " + id + " has been successfully deleted.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Coordinator with ID " + id + " not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while trying to delete the coordinator: " + e.getMessage());
        }
    }

}
