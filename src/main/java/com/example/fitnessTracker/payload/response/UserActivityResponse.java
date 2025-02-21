package com.example.fitnessTracker.payload.response;

import com.example.fitnessTracker.model.Exercise;
import com.example.fitnessTracker.model.MealItem;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserActivityResponse {
    private Long id;
    private Long appUserId;
    private String day;
    private LocalDate date;
    private String status;
    private String statusCode;
    private List<Exercise> exercises;
    private List<MealItem> foodItems;

}
