package com.recept.team.controller;

import com.recept.team.model.Menu;
import com.recept.team.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController implements ControllerService<Menu> {
    private final MenuService service;

    @GetMapping
    public ResponseEntity<List<Menu>> getAll() {
        List<Menu> menus = service.getAll();

        return ResponseEntity.ok(menus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getById(@PathVariable("id") int id) {
        Menu menu = service.getById(id);

        if (menu == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(menu);
    }

    @PostMapping
    public ResponseEntity<Menu> add(@RequestBody Menu menu) {
        menu = service.add(menu);

        return ResponseEntity.ok(menu);
    }

    @PutMapping
    public ResponseEntity<Menu> update(@RequestBody Menu menu) {
        menu = service.add(menu);

        return ResponseEntity.ok(menu);
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
