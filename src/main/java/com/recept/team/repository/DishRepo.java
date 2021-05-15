package com.recept.team.repository;

import com.recept.team.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepo extends JpaRepository<Dish, Integer> {
}
