package com.GeoTab.GeoTab.Users.repositories;

import com.GeoTab.GeoTab.Users.entities.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoadRepositorty extends JpaRepository<Road, Long> {
}
