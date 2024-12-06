package com.GeoTab.GeoTab.Users.services;

import com.GeoTab.GeoTab.Users.entities.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    List<User> findAllUser();

    User findIdUser(Long id);

    User updateUser(User user);

    String deleteUser(Long id);

}
