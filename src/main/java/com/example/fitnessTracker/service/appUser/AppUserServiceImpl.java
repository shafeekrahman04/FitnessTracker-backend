package com.example.fitnessTracker.service.appUser;


import com.example.fitnessTracker.dao.AppUserRepository;
import com.example.fitnessTracker.model.AppUser;
import com.example.fitnessTracker.utils.enumConstant.YNStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static com.example.fitnessTracker.utils.Constant.CURRENT_USER_NAME;


@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setCreatedBy(CURRENT_USER_NAME);
        appUser.setCreatedOn(LocalDateTime.now());
        appUser.setDeleted(YNStatus.NO.getStatus());
        return appUserRepository.save(appUser);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return appUserRepository.existsByUsername(username);
    }

    @Override
    public AppUser findAppUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
