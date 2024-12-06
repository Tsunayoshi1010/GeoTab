package com.GeoTab.GeoTab.Rutas.controller;

import com.GeoTab.GeoTab.Rutas.entities.Ruta;
import com.GeoTab.GeoTab.Rutas.services.rutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutas")
public class rutaController {
    @Autowired
    private rutaService rutaService;

    // Crear una nueva ruta
    @PostMapping
    public ResponseEntity<Ruta> createRuta(@RequestBody Ruta ruta) {
        Ruta nuevaRuta = rutaService.createRuta(ruta);
        return ResponseEntity.status(201).body(nuevaRuta);
    }

    // Obtener todas las rutas
    @GetMapping
    public ResponseEntity<List<Ruta>> getAllRutas() {
        List<Ruta> rutas = rutaService.getAllRutas();
        return ResponseEntity.ok(rutas);
    }

    // Obtener una ruta por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Ruta> getRutaById(@PathVariable Long id) {
        Ruta ruta = rutaService.getRutaById(id);
        if (ruta != null) {
            return ResponseEntity.ok(ruta);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Actualizar una ruta
    @PutMapping("/{id}")
    public ResponseEntity<Ruta> updateRuta(@PathVariable Long id, @RequestBody Ruta ruta) {
        Ruta rutaActualizada = rutaService.updateRuta(id, ruta);
        if (rutaActualizada != null) {
            return ResponseEntity.ok(rutaActualizada);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Eliminar una ruta
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRuta(@PathVariable Long id) {
        boolean isDeleted = rutaService.deleteRuta(id);
        if (isDeleted) {
            return ResponseEntity.ok().body("{\"message\": \"Ruta eliminada con éxito\"}");
        } else {
            return ResponseEntity.status(404).body("{\"message\": \"Ruta no encontrada\"}");
        }
    }
}
