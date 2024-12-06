package com.GeoTab.GeoTab.Users.services.imp;

import com.GeoTab.GeoTab.Users.entities.Coordinator;
import com.GeoTab.GeoTab.Users.repositories.ICoordinatorRepository;
import com.GeoTab.GeoTab.Users.services.ICoordinatorService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CoordinatorService implements ICoordinatorService {
    private final ICoordinatorRepository coordinatorRepository;

    public CoordinatorService(ICoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }

    @Override
    public Coordinator createCoordinator(Coordinator coordinator) {

        return this.coordinatorRepository.save(coordinator);
    }

    @Override
    public List<Coordinator> findAllCoordinators() {
        return this.coordinatorRepository.findAll();
    }

    @Override
    public Coordinator findCoordinatorById(Long id) {
        return this.coordinatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordinator not found"));
    }

    @Override
    public Coordinator updateCoordinator(Coordinator coordinator) {
        return null;
    }

    @Override
    public String deleteCoordinator(Long id) {
        findCoordinatorById(id);
        this.coordinatorRepository.deleteById(id);
        return "Coordinator was successfully deleted";
    }
}
