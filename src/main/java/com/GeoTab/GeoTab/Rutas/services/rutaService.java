package com.GeoTab.GeoTab.Rutas.services;

import com.GeoTab.GeoTab.Rutas.repositories.rutaRepository;
import com.GeoTab.GeoTab.Users.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rutaService {
    @Autowired
    private rutaRepository rutaRepository;

    public List<User> getAllUsers() {
        return rutaRepository.findAll();
    }

    public User getUserById(Long id) {
        return rutaRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return rutaRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setNames(userDetails.getNames());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setIdVehiculo(userDetails.getIdVehiculo());
            return rutaRepository.save(existingUser);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        if (rutaRepository.existsById(id)) {
            rutaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
