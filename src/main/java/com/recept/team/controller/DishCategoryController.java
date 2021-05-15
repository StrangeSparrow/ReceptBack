package com.recept.team.controller;

import com.recept.team.model.DishCategory;
import com.recept.team.service.DishCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("dish_category")
public class DishCategoryController {
    private final DishCategoryService service;

    @GetMapping
    public ResponseEntity<List<DishCategory>> getAll() {
        List<DishCategory> dishCategories = service.getAll();

        return ResponseEntity.ok(dishCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishCategory> getById(@PathVariable("id") int id) {
        DishCategory dishCategory = service.getById(id);

        if(dishCategory == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(dishCategory);
    }

    @PostMapping
    public ResponseEntity<DishCategory> add(@RequestBody DishCategory dishCategory) {
        dishCategory = service.add(dishCategory);

        return ResponseEntity.ok(dishCategory);
    }

    @PutMapping
    public ResponseEntity<DishCategory> update(@RequestBody DishCategory dishCategory) {
        dishCategory = service.update(dishCategory);

        return ResponseEntity.ok(dishCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        try {
            service.delete(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
