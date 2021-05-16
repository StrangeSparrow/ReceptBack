package com.recept.team.repository;

import com.recept.team.model.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishCategoryRepo extends JpaRepository<DishCategory, Integer> {
}
