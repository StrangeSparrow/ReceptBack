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

    @PostMapping
    public ResponseEntity<Recipe> add(@RequestBody Recipe recipe) {
        recipe = service.add(recipe);

        return ResponseEntity.ok(recipe);
    }
}
