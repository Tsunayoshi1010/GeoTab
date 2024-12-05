package com.GeoTab.GeoTab.Users.repositories;

import com.GeoTab.GeoTab.Users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
}
