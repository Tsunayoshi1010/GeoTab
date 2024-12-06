package com.GeoTab.GeoTab.Users.entities;

import jakarta.persistence.*;

import java.time.*;

@Entity
@Table(name="roads")
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoad;
    private String roadCondition;
    private City city;
    private LocalDateTime startTime;
    private Double kilometers;
    private Double latitude;
    private Double length;
    private FuelType fuelType;
    private VehicleType vehicleType;
    @ManyToOne()
    private User user;

    public Road() {

    }

    public Long getIdRoad() {
        return idRoad;
    }

    public void setIdRoad(Long idRoad) {
        this.idRoad = idRoad;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Road(Long idRoad, String roadCondition, City city, LocalDateTime startTime, Double kilometers,
                Double latitude, Double length, FuelType fuelType, VehicleType vehicleType, User user) {
        this.idRoad = idRoad;
        this.roadCondition = roadCondition;
        this.city = city;
        this.startTime = startTime;
        this.kilometers = kilometers;
        this.latitude = latitude;
        this.length = length;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.user = user;
    }
}
