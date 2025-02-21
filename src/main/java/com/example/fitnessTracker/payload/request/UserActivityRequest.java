package com.example.fitnessTracker.payload.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserActivityRequest {

    private Long appUserId;
    private String startDate;
    private String status;

}
