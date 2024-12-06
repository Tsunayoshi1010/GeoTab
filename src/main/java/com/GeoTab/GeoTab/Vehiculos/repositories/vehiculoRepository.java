package com.GeoTab.GeoTab.Vehiculos.repositories;

import com.GeoTab.GeoTab.Users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface vehiculoRepository extends JpaRepository<User, Long> {
}
