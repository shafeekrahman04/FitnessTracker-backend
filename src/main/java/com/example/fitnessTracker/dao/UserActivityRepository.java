package com.example.fitnessTracker.dao;

import com.example.fitnessTracker.model.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
    List<UserActivity> findByAppUserId(Long appUserId);

}
