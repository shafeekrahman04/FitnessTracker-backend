package com.example.fitnessTracker.controller;

import com.example.fitnessTracker.payload.ApiError;
import com.example.fitnessTracker.payload.ApiResponse;
import com.example.fitnessTracker.payload.request.UserActivityRequest;
import com.example.fitnessTracker.payload.response.UserActivityResponse;
import com.example.fitnessTracker.service.userActivity.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user-activity")
public class UserActivityController {
    @Autowired
    private UserActivityService userActivityService;

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<List<UserActivityResponse>>> getUserActivities(@PathVariable Long userId) {
        try {
            List<UserActivityResponse> userActivities = userActivityService.getUserActivitiesByUserId(userId);
            return ResponseEntity.ok(new ApiResponse<>(true, userActivities, null));
        } catch (Exception e) {
            ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return ResponseEntity.internalServerError().body(new ApiResponse<>(false, null, error));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> createUserActivity(@RequestBody UserActivityRequest userActivityRequest) {
        try {
            List<UserActivityResponse> userActivities = userActivityService.createUserActivities(userActivityRequest);
            return ResponseEntity.ok(new ApiResponse<>(true, "Saved Successfully", null));
        } catch (Exception e) {
            ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return ResponseEntity.internalServerError().body(new ApiResponse<>(false, null, error));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateUserActivity(@PathVariable Long id) {
        try {
            boolean userActivities = userActivityService.updateUserActivities(id);
            if (userActivities) {
                return ResponseEntity.ok(new ApiResponse<>(true, "Updated Successfully", null));
            } else {
                ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
                return ResponseEntity.internalServerError().body(new ApiResponse<>(false, null, error));
            }
        } catch (Exception e) {
            ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return ResponseEntity.internalServerError().body(new ApiResponse<>(false, null, error));
        }
    }

}
