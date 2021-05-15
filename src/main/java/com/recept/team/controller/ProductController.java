package com.recept.team.controller;

import com.recept.team.model.Product;
import com.recept.team.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.getAll();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") int id) {
        Product product = service.getById(id);

        if(product == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product) {
        product = service.add(product);

        return ResponseEntity.ok(product);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        product = service.update(product);

        return ResponseEntity.ok(product);
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
