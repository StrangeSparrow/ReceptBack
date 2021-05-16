package com.recept.team.service.impl;

import com.recept.team.model.Recipe;
import com.recept.team.model.RecipePK;
import com.recept.team.repository.RecipeRepo;
import com.recept.team.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepo repository;

    @Override
    public List<Recipe> getAll() {
        return repository.findAll();
    }

    @Override
    public Recipe getById(RecipePK id) {
        Optional<Recipe> recipe = repository.findById(id);

        return recipe.orElse(null);
    }

    @Override
    public Recipe add(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public Recipe update(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public void delete(RecipePK id) {
        repository.deleteById(id);
    }
}
