package com.recept.team.controller;

import com.recept.team.model.Dish;
import com.recept.team.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/dish")
public class DishController implements ControllerService<Dish> {
    private final DishService service;

    @GetMapping
    public ResponseEntity<List<Dish>> getAll() {
        List<Dish> dishes = service.getAll();

        return ResponseEntity.ok(dishes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getById(@PathVariable("id") int id) {
        Dish dish = service.getById(id);

        if (dish == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(dish);
    }

    @PostMapping
    public ResponseEntity<Dish> add(@RequestBody Dish dish) {
        dish = service.add(dish);

        return ResponseEntity.ok(dish);
    }

    @PutMapping
    public ResponseEntity<Dish> update(@RequestBody Dish dish) {
        dish = service.update(dish);

        return ResponseEntity.ok(dish);
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
