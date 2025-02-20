package com.example.fitnessTracker.model;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "meal_item")
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "CALORIES")
    private int calories;

    @Column(name = "PROTEIN")
    private double protein;

    @Column(name = "CARBS")
    private double carbs;

    @Column(name = "FATS")
    private double fats;
}
