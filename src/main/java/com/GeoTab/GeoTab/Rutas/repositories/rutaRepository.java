package com.GeoTab.GeoTab.Rutas.repositories;

import com.GeoTab.GeoTab.Users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rutaRepository extends JpaRepository<User, Long> {
}
