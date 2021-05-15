package com.recept.team.service;

import com.recept.team.model.DishCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishCategoryService {
    List<DishCategory> getAll();

    DishCategory getById(int id);

    DishCategory add(DishCategory dishCategory);

    DishCategory update(DishCategory dishCategory);

    void delete(int id);
}
