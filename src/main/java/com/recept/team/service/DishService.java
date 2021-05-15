package com.recept.team.service;

import com.recept.team.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getAll();

    Dish getById(int id);

    Dish add(Dish dish);

    Dish update(Dish dish);

    void delete(int id);
}
