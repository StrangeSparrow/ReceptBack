package com.recept.team.service.impl;

import com.recept.team.model.DishCategory;
import com.recept.team.repository.DishCategoryRepo;
import com.recept.team.service.DishCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DishCategoryServiceImpl implements DishCategoryService {
    private final DishCategoryRepo repository;

    @Override
    public List<DishCategory> getAll() {
        return repository.findAll();
    }

    @Override
    public DishCategory getById(int id) {
        Optional<DishCategory> dishCategory = repository.findById(id);

        return dishCategory.orElse(null);
    }

    @Override
    public DishCategory add(DishCategory dishCategory) {
        return repository.save(dishCategory);
    }

    @Override
    public DishCategory update(DishCategory dishCategory) {
        return repository.save(dishCategory);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
