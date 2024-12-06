package com.GeoTab.GeoTab.Users.services;

import com.GeoTab.GeoTab.Users.entities.Driver;

import java.util.*;

public interface IDriverService {
    Driver createDriver(Driver driver);

    List<Driver> findAllDrivers();

    Driver findDriverById(Long id);

    Driver updateDriver(Driver driver);

    String deleteDriver(Long id);
}
