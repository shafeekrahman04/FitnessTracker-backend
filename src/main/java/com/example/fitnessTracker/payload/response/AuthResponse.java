package com.example.fitnessTracker.payload.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import static com.example.fitnessTracker.utils.Constant.AUTH_FAILURE_DESC;
import static com.example.fitnessTracker.utils.Constant.AUTH_SCUCCESS_DESC;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AuthResponse {
    private String token;
    private int status;
    private String statusDesc;
    private boolean isError;
    private AppUserResponse appUser;


    public static AuthResponse createResponse(String token, boolean isError,AppUserResponse appUserResponse) {
        return AuthResponse.builder()
                .token(token)
                .isError(isError)
                .appUser(appUserResponse)
                .status(isError ? HttpStatus.UNAUTHORIZED.value() : HttpStatus.CREATED.value())
                .statusDesc(isError ? AUTH_FAILURE_DESC : AUTH_SCUCCESS_DESC)
                .build();
    }


}
