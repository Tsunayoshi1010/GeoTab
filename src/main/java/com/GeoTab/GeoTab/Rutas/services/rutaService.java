package com.GeoTab.GeoTab.Rutas.services;

import com.GeoTab.GeoTab.Rutas.entities.Ruta;
import com.GeoTab.GeoTab.Rutas.repositories.rutaRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class rutaService {
    @Autowired
    private rutaRepository rutaRep;

    // Crear una nueva ruta
    public Ruta createRuta(Ruta ruta) {
        return rutaRep.save(ruta);
    }

    // Obtener todas las rutas
    public List<Ruta> getAllRutas() {
        return rutaRep.findAll();
    }

    // Obtener una ruta por su ID
    public Ruta getRutaById(Long id) {
        Optional<Ruta> ruta = rutaRep.findById(id);
        return ruta.orElse(null);
    }

    // Actualizar una ruta
    public Ruta updateRuta(Long id, Ruta ruta) {
        if (rutaRep.existsById(id)) {
            ruta.setIdRuta(id);
            return rutaRep.save(ruta);
        }
        return null;
    }

    // Eliminar una ruta
    public boolean deleteRuta(Long id) {
        if (rutaRep.existsById(id)) {
            rutaRep.deleteById(id);
            return true;
        }
        return false;
    }
}
