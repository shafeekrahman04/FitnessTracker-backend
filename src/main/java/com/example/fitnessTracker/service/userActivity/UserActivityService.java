package com.example.fitnessTracker.service.userActivity;

import com.example.fitnessTracker.payload.request.UserActivityRequest;
import com.example.fitnessTracker.payload.response.UserActivityResponse;

import java.util.List;

public interface UserActivityService {

    public List<UserActivityResponse> getUserActivitiesByUserId(Long userId);

    public List<UserActivityResponse> createUserActivities(UserActivityRequest request);

    public boolean updateUserActivities(Long id);
}
