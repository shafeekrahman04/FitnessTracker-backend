package com.example.fitnessTracker.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_activity")
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "app_user_id", nullable = false)
    private Long appUserId;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToMany
    @JoinTable(
            name = "user_activity_meal",
            joinColumns = @JoinColumn(name = "user_activity_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<MealItem> foodItems;

    @ManyToMany
    @JoinTable(
            name = "user_activity_exercise",
            joinColumns = @JoinColumn(name = "user_activity_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;

    @Column(name = "status", nullable = false)
    private String status;
}
