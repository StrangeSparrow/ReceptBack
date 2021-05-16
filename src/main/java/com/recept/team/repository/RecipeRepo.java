package com.recept.team.repository;

import com.recept.team.model.Recipe;
import com.recept.team.model.RecipePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, RecipePK> {
}
