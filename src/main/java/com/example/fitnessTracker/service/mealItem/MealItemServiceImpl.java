package com.example.fitnessTracker.service.mealItem;

import com.example.fitnessTracker.dao.MealItemRepository;
import com.example.fitnessTracker.model.MealItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MealItemServiceImpl implements MealItemService {

    @Autowired
    private MealItemRepository mealItemRepository;

    @Override
    public List<MealItem> listAllMealItem() {
        return mealItemRepository.findAll();
    }
}
