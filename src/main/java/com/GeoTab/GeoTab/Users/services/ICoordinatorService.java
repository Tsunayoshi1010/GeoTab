package com.GeoTab.GeoTab.Users.services;

import com.GeoTab.GeoTab.Users.entities.Coordinator;

import java.util.*;

public interface ICoordinatorService {
    Coordinator createCoordinator(Coordinator coordinator);

    List<Coordinator> findAllCoordinators();

    Coordinator findCoordinatorById(Long id);

    Coordinator updateCoordinator(Coordinator coordinator);

    String deleteCoordinator(Long id);
}
