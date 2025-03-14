package com.example.fitnessTracker.payload;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse <T> {
    private boolean success;
    private T data;
    private ApiError error;

}
