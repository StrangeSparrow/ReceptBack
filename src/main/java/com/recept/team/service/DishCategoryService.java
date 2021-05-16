package com.recept.team.service;

import com.recept.team.model.DishCategory;

import java.util.List;

public interface DishCategoryService {
    List<DishCategory> getAll();

    DishCategory getById(int id);

    DishCategory add(DishCategory dishCategory);

    DishCategory update(DishCategory dishCategory);

    void delete(int id);
}
