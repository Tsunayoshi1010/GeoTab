package com.GeoTab.GeoTab.Users.controller;

import com.GeoTab.GeoTab.Users.entities.Driver;
import com.GeoTab.GeoTab.Users.services.imp.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.driverService.createDriver(driver));
    }

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.driverService.findAllDrivers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.driverService.findDriverById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable Long id) {
        try {
            this.driverService.deleteDriver(id);

            return ResponseEntity.status(HttpStatus.OK)
                    .body("Driver with ID " + id + " has been successfully deleted.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Driver with ID " + id + " not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while trying to delete the driver: " + e.getMessage());
        }
    }

}
