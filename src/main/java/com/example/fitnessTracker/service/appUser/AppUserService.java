package com.example.fitnessTracker.service.appUser;


import com.example.fitnessTracker.model.AppUser;

public interface AppUserService {

    AppUser saveAppUser(AppUser appUser);

    Boolean existsByUsername(String username);

    AppUser findAppUserByUsername(String username);

}
