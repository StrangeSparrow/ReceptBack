package com.recept.team.controller;

import com.recept.team.model.Dish;
import com.recept.team.repository.RecipeRepo;
import com.recept.team.service.DishService;
import com.recept.team.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class Test {
    private final RecipeRepo repo;
    private final DishService dishRepo;
    private final ProductService productRepo;

    @GetMapping
    public void test(){
//        repo.deleteByDishId(1);
        Dish dish = new Dish();
        dish.setId(1);

//        repo.save(1);
    }
}
