package com.GeoTab.GeoTab.Vehiculos.controller;

import com.GeoTab.GeoTab.Users.entities.User;
import com.GeoTab.GeoTab.Vehiculos.services.vehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class vehiculoController {
    @Autowired
    private vehiculoService vehiculoService;

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return vehiculoService.getAllUsers();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = vehiculoService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // Crear un nuevo usuario
    @PostMapping
    public User createUser(@RequestBody User user) {
        return vehiculoService.saveUser(user);
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = vehiculoService.updateUser(id, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        boolean isDeleted = vehiculoService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok().body("{\"message\": \"Usuario eliminado con éxito\"}");
        } else {
            return ResponseEntity.status(404).body("{\"message\": \"Usuario no encontrado\"}");
        }
    }
}
