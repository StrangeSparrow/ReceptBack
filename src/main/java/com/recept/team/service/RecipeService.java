package com.recept.team.service;

import com.recept.team.model.Recipe;
import com.recept.team.model.RecipePK;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();

    Recipe getById(RecipePK id);

    Recipe add(Recipe recipe);

    Recipe update(Recipe recipe);

    void delete(RecipePK id);
}
