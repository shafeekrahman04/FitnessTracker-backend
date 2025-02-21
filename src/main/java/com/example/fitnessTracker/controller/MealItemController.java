package com.example.fitnessTracker.controller;

import com.example.fitnessTracker.model.MealItem;
import com.example.fitnessTracker.payload.ApiError;
import com.example.fitnessTracker.payload.ApiResponse;
import com.example.fitnessTracker.payload.response.MealItemResponse;
import com.example.fitnessTracker.service.mealItem.MealItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/meal-item")
public class MealItemController {

    @Autowired
    private MealItemService mealItemService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<MealItemResponse>>> listAllTask() {
        try {
            List<MealItem> mealItems = mealItemService.listAllMealItem();
            List<MealItemResponse> mealItemResponses = MealItemResponse.buildResponseList(mealItems);
            return ResponseEntity.ok(new ApiResponse<>(true, mealItemResponses, null));
        } catch (Exception e) {
            ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false, null, error));
        }
    }
}
