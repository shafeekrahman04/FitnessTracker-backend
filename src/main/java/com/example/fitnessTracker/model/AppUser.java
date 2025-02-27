package com.example.fitnessTracker.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CURRENT_WEIGHT")
    private String currentWeight;

    @Column(name = "TARGET_WEIGHT")
    private String targetWeight;

    @Column(name = "HEIGHT")
    private String height;

    @Column(name = "GOAL")
    private String goal;

    @Column(name = "FITNESS_LEVEL")
    private String fitnessLevel;

    @Column(name = "FOCUS_PART")
    private String focusPart;

    @Column(name = "DELETED")
    private String deleted;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_ON")
    private LocalDateTime createdOn;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;
}
