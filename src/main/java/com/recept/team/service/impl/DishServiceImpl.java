package com.recept.team.service.impl;

import com.recept.team.model.Dish;
import com.recept.team.repository.DishRepo;
import com.recept.team.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DishServiceImpl implements DishService {
    private final DishRepo repository;

    @Override
    public List<Dish> getAll() {
        return repository.findAll();
    }

    @Override
    public Dish getById(int id) {
        Optional<Dish> dish = repository.findById(id);

        return dish.orElse(null);
    }

    @Override
    public Dish add(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public Dish update(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
