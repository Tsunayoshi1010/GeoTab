package com.GeoTab.GeoTab.Users.DTO;

import com.GeoTab.GeoTab.Users.entities.City;
import com.GeoTab.GeoTab.Users.entities.FuelType;
import com.GeoTab.GeoTab.Users.entities.VehicleType;

import java.time.LocalDateTime;

public class RequestRoad {
    private String roadCondition;
    private City city;
    private LocalDateTime startTime;
    private Double kilometers;
    private Double latitude;
    private Double length;
    private FuelType fuelType;
    private VehicleType vehicleType;
    private Long userId;

    public String getRoadCondition() {
        return roadCondition;
    }

    public void setRoadCondition(String roadCondition) {
        this.roadCondition = roadCondition;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
