package com.recept.team.controller;

import com.recept.team.model.Recipe;
import com.recept.team.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService service;

    @GetMapping
    public ResponseEntity<List<Recipe>> getAll() {
        List<Recipe> recipes = service.getAll();

        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/dish/{id}")
    public ResponseEntity<List<Recipe>> getByDishId(@PathVariable("id") int id) {
        List<Recipe> recipes = service.getByDishId(id);

        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<Recipe>> getByProductId(@PathVariable("id") int id) {
        List<Recipe> recipes = service.getByProductId(id);

        return ResponseEntity.ok(recipes);
    }

    @PostMapping
    public ResponseEntity<Recipe> add(@RequestBody Recipe recipe) {
        recipe = service.add(recipe);

        return ResponseEntity.ok(recipe);
    }

    @PutMapping
    public ResponseEntity<Recipe> update(@RequestBody Recipe recipe) {
        recipe = service.add(recipe);

        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/dish/{id}")
    public ResponseEntity deleteByDishId(@PathVariable("id") int id) {
        service.deleteByDishId(id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteByProductId(@PathVariable("id") int id) {
        service.deleteByProductId(id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteByDishIdAndProductId(@RequestParam(required = true) int dish, @RequestParam(required = true) int product) {
        service.deleteByDishIdAndProductId(dish, product);

        return ResponseEntity.ok().build();
    }
}
