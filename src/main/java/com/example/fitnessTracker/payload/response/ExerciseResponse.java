package com.example.fitnessTracker.payload.response;

import com.example.fitnessTracker.model.Exercise;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseResponse {

    private Long id;
    private String name;
    private String bodyPart;

    public static ExerciseResponse buildResponse(Exercise entity) {
        return ExerciseResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .bodyPart(entity.getBodyPart())
                .build();

    }
    public static List<ExerciseResponse> buildResponseList(List<Exercise> list) {
        return list.stream().map(ExerciseResponse::buildResponse).collect(Collectors.toList());
    }
}
