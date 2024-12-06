package com.GeoTab.GeoTab.Users.controller;

import com.GeoTab.GeoTab.Users.DTO.RequestRoad;
import com.GeoTab.GeoTab.Users.entities.User;
import com.GeoTab.GeoTab.Users.repositories.IUserRepository;
import com.GeoTab.GeoTab.Users.services.imp.RoadService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/road")
public class RoadController {
    private final RoadService roadService;
    private final IUserRepository userRepository;

    public RoadController(RoadService roadService, IUserRepository userRepository) {
        this.roadService = roadService;
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> calculateFuelConsumption(@RequestBody RequestRoad requestRoad) {
        double finalConsumption = roadService.calculateFuelConsumption(requestRoad);

        User user = userRepository.findById(requestRoad.getUserId()).orElseThrow(() -> new RuntimeException("Error IdUser"));
        LocalDateTime startTime = requestRoad.getStartTime();
        boolean isDaytime = startTime.getHour() >= 6 && startTime.getHour() < 18;
        String timeMessage = isDaytime ? "El viaje se realiza durante el día." : "El viaje se realiza durante la noche.";

        Map<String, Object> response = new HashMap<>();
        response.put("message", timeMessage);
        response.put("finalConsumption", finalConsumption);
        response.put("vehicleType", requestRoad.getVehicleType().toString());
        response.put("fuelType", requestRoad.getFuelType().toString());

        return ResponseEntity.ok(response);
    }
}
