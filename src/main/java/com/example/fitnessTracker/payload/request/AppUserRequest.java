package com.example.fitnessTracker.payload.request;

import com.example.fitnessTracker.model.AppUser;
import com.example.fitnessTracker.utils.enumConstant.Gender;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserRequest {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String gender;
    private String fitnessLevel;
    private String focusPart;
    private String goal;
    private String dob;
    private String currentWeight;
    private String targetWeight;
    private String height;

    public AppUser createEntity() {
        return AppUser
                .builder()
                .name(this.name)
                .username(this.username)
                .password(this.password)
                .dob(LocalDate.parse(this.dob))
                .gender(Gender.valueMatch(this.gender).getValue())
                .currentWeight(this.currentWeight)
                .targetWeight(this.targetWeight)
                .goal(this.goal)
                .height(this.height)
                .fitnessLevel(this.fitnessLevel)
                .focusPart(this.focusPart)
                .build();
    }

}
