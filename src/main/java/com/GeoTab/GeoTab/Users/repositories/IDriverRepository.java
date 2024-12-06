package com.GeoTab.GeoTab.Users.repositories;

import com.GeoTab.GeoTab.Users.entities.Driver;
import com.GeoTab.GeoTab.Users.services.imp.DriverService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDriverRepository extends JpaRepository<Driver, Long> {
}
