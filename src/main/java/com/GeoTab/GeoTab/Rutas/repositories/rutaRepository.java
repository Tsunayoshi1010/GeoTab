package com.GeoTab.GeoTab.Rutas.repositories;

import com.GeoTab.GeoTab.Rutas.entities.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rutaRepository extends JpaRepository<Ruta, Long> {
}
