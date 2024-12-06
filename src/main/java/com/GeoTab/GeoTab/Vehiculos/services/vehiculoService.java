package com.GeoTab.GeoTab.Vehiculos.services;

import com.GeoTab.GeoTab.Users.entities.User;
import com.GeoTab.GeoTab.Vehiculos.repositories.vehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class vehiculoService {
    @Autowired
    private vehiculoRepository vehiculoRepository;

    public List<User> getAllUsers() {
        return vehiculoRepository.findAll();
    }

    public User getUserById(Long id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return vehiculoRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setNames(userDetails.getNames());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setIdVehiculo(userDetails.getIdVehiculo());
            return vehiculoRepository.save(existingUser);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        if (vehiculoRepository.existsById(id)) {
            vehiculoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
