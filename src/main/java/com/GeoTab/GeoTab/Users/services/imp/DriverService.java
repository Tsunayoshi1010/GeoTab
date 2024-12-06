package com.GeoTab.GeoTab.Users.services.imp;

import com.GeoTab.GeoTab.Users.entities.Driver;
import com.GeoTab.GeoTab.Users.entities.User;
import com.GeoTab.GeoTab.Users.repositories.IDriverRepository;
import com.GeoTab.GeoTab.Users.services.IDriverService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DriverService implements IDriverService {
    private final IDriverRepository driverRepository;

    public DriverService(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver createDriver(Driver driver) {
        return this.driverRepository.save(driver);
    }

    @Override
    public List<Driver> findAllDrivers() {
        return this.driverRepository.findAll();
    }

    @Override
    public Driver findDriverById(Long id) {
        return this.driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return null;
    }

    @Override
    public String deleteDriver(Long id) {
        findDriverById(id);
        this.driverRepository.deleteById(id);
        return "Driver was successfully deleted";
    }
}
