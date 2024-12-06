package com.GeoTab.GeoTab.Users.repositories;

import com.GeoTab.GeoTab.Users.entities.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoordinatorRepository extends JpaRepository<Coordinator, Long> {
}
