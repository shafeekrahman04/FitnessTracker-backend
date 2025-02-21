package com.example.fitnessTracker.payload.response;

import com.example.fitnessTracker.model.MealItem;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealItemResponse {

    private Long id;
    private String name;
    private String calories;
    private String protein;
    private String carbs;
    private String fats;

    public static MealItemResponse buildResponse(MealItem entity) {
        return MealItemResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .calories(String.valueOf(entity.getCalories()))
                .protein(String.valueOf(entity.getProtein()))
                .carbs(String.valueOf(entity.getCarbs()))
                .fats(String.valueOf(entity.getFats()))
                .build();

    }
    public static List<MealItemResponse> buildResponseList(List<MealItem> list) {
        return list.stream().map(MealItemResponse::buildResponse).collect(Collectors.toList());
    }
}
