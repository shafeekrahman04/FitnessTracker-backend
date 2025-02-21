package com.example.fitnessTracker.controller;


import com.example.fitnessTracker.model.Exercise;
import com.example.fitnessTracker.payload.ApiError;
import com.example.fitnessTracker.payload.ApiResponse;
import com.example.fitnessTracker.payload.response.ExerciseResponse;
import com.example.fitnessTracker.service.exercise.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ExerciseResponse>>> listAllTask() {
        try {
            List<Exercise> exercises = exerciseService.listAllExercise();
            List<ExerciseResponse> exerciseResponses = ExerciseResponse.buildResponseList(exercises);
            return ResponseEntity.ok(new ApiResponse<>(true, exerciseResponses, null));
        } catch (Exception e) {
            ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false, null, error));
        }
    }
}
