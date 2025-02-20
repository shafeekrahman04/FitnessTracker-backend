package com.example.fitnessTracker.payload.response;

import com.example.fitnessTracker.model.AppUser;
import com.example.fitnessTracker.utils.enumConstant.Gender;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserResponse {

    private Long id;
    private String name;
    private String username;
    private String dob;
    private String gender;
    private String currentWeight;
    private String targetWeight;
    private String height;
    private String fitnessLevel;
    private String focusPart;
    private String goal;

    public static AppUserResponse createResponse(AppUser appUser) {
        return AppUserResponse.builder()
                .id(appUser.getId())
                .name(appUser.getName())
                .username(appUser.getUsername())
                .dob(String.valueOf(appUser.getDob()))
                .gender(Gender.valueMatch(appUser.getGender()).getDisplay())
                .currentWeight(appUser.getCurrentWeight())
                .targetWeight(appUser.getTargetWeight())
                .height(appUser.getHeight())
                .fitnessLevel(appUser.getFitnessLevel())
                .focusPart(appUser.getFocusPart())
                .goal(appUser.getGoal())
                .build();
    }

}
