package com.recept.team.repository;

import com.recept.team.model.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishCategoryRepo extends JpaRepository<DishCategory, Integer> {
}
