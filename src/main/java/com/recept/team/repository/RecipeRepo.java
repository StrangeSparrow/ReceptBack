package com.recept.team.repository;

import com.recept.team.model.Recipe;
import com.recept.team.model.RecipePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, RecipePK> {
    List<Recipe> findByDishId(Integer dish);

    List<Recipe> findByProductId(Integer product);

    @Transactional
    void deleteByDishId(Integer id);

    @Transactional
    void deleteByProductId(Integer id);

    @Transactional
    void deleteByDishIdAndProductId(Integer dishId, Integer productId);
}
