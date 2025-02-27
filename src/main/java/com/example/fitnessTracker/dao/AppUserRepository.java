package com.example.fitnessTracker.dao;


import com.example.fitnessTracker.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Boolean existsByUsername(String username);

    AppUser findByUsername(String username);

}
