package com.GeoTab.GeoTab.Users.services.imp;

import com.GeoTab.GeoTab.Users.entities.User;
import com.GeoTab.GeoTab.Users.repositories.IUserRepository;
import com.GeoTab.GeoTab.Users.services.IUserService;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User findIdUser(Long id) {
        return this.userRepository.findById(id).orElseThrow(()->new RuntimeException("Not Data User"));

    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        findIdUser(id);
        this.userRepository.deleteById(id);
        return "Fue eliminado exitosamente";
    }
}
