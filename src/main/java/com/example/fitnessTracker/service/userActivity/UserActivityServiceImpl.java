package com.example.fitnessTracker.service.userActivity;

import com.example.fitnessTracker.dao.ExerciseRepository;
import com.example.fitnessTracker.dao.MealItemRepository;
import com.example.fitnessTracker.dao.UserActivityRepository;
import com.example.fitnessTracker.model.Exercise;
import com.example.fitnessTracker.model.MealItem;
import com.example.fitnessTracker.model.UserActivity;
import com.example.fitnessTracker.payload.request.UserActivityRequest;
import com.example.fitnessTracker.payload.response.UserActivityResponse;
import com.example.fitnessTracker.utils.enumConstant.ActivityStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    private UserActivityRepository userActivityRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private MealItemRepository mealItemRepository;

    @Override
    public List<UserActivityResponse> getUserActivitiesByUserId(Long userId) {
        List<UserActivity> userActivities = userActivityRepository.findByAppUserId(userId);
        return userActivities.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserActivityResponse> createUserActivities(UserActivityRequest request) {
        List<UserActivity> userActivities = new ArrayList<>();
        LocalDate currentDate = LocalDate.parse(request.getStartDate());
        List<Exercise> allExercises = exerciseRepository.findAll();
        List<MealItem> allMealItems = mealItemRepository.findAll();

        if (allExercises.isEmpty() || allMealItems.isEmpty()) {
            throw new RuntimeException("Exercises or Meal Items are not available in the database");
        }

        for (int day = 1; day <= 30; day++) {  // Use a counter from 1 to 30
            // Randomly select 10 exercises and 5 meals
            List<Exercise> randomExercises = getRandomItems(allExercises, 10);
            List<MealItem> randomMeals = getRandomItems(allMealItems, 5);

            // Create UserActivity
            UserActivity userActivity = UserActivity.builder()
                    .appUserId(request.getAppUserId())
                    .date(currentDate)
                    .day(String.valueOf(day))  // Store numeric day as String
                    .status(ActivityStatus.statusMatch(request.getStatus()).getStatus())
                    .exercises(randomExercises)
                    .foodItems(randomMeals)
                    .build();

            userActivities.add(userActivity);
            currentDate = currentDate.plusDays(1); // Move to the next day
        }

        // Save all records at once
        userActivityRepository.saveAll(userActivities);

        // Convert to response DTOs
        return userActivities.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateUserActivities(Long id) {
        UserActivity userActivity = userActivityRepository.findById(id).get();
        userActivity.setStatus(ActivityStatus.COMPLETED.getStatus());
        UserActivity savedUserActivity = userActivityRepository.save(userActivity);
        return savedUserActivity != null;
    }

    private <T> List<T> getRandomItems(List<T> items, int count) {
        Collections.shuffle(items);
        return items.stream().limit(count).collect(Collectors.toList());
    }

    private UserActivityResponse convertToResponse(UserActivity userActivity) {
        UserActivityResponse response = new UserActivityResponse();
        response.setId(userActivity.getId());
        response.setAppUserId(userActivity.getAppUserId());
        response.setDay(userActivity.getDay());
        response.setDate(userActivity.getDate());
        response.setStatus(ActivityStatus.statusMatch(userActivity.getStatus()).getDisplay());
        response.setStatusCode(ActivityStatus.statusMatch(userActivity.getStatus()).getStatus());
        response.setExercises(userActivity.getExercises());
        response.setFoodItems(userActivity.getFoodItems());
        return response;
    }

}
