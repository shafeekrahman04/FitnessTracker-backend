package com.example.fitnessTracker.service.exercise;

import com.example.fitnessTracker.dao.ExerciseRepository;
import com.example.fitnessTracker.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> listAllExercise() {
        return exerciseRepository.findAll();
    }
}
