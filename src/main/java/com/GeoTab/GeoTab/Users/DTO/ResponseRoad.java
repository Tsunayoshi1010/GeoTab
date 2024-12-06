package com.GeoTab.GeoTab.Users.DTO;

import com.GeoTab.GeoTab.Users.entities.City;
import com.GeoTab.GeoTab.Users.entities.FuelType;
import com.GeoTab.GeoTab.Users.entities.VehicleType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseRoad {
    private Long idRoad;
    private String roadCondition;
    private City city;
    private LocalDateTime startTime;
    private Double kilometers;
    private Double latitude;
    private Double length;
    private FuelType fuelType;
    private VehicleType vehicleType;
}
