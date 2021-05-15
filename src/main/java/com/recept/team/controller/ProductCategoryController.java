package com.recept.team.controller;

import com.recept.team.model.ProductCategory;
import com.recept.team.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product_category")
public class ProductCategoryController implements ControllerService<ProductCategory> {
    private final ProductCategoryService service;

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAll() {
        List<ProductCategory> productCategories = service.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(productCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getById(@PathVariable("id") int id) {
        ProductCategory productCategory = service.getById(id);

        if (productCategory == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.status(HttpStatus.OK).body(productCategory);
    }

    @PostMapping
    public ResponseEntity<ProductCategory> add(@RequestBody ProductCategory productCategory) {
        productCategory = service.add(productCategory);

        return ResponseEntity.status(HttpStatus.OK).body(productCategory);
    }

    @PutMapping
    public ResponseEntity<ProductCategory> update(@RequestBody ProductCategory productCategory) {
        productCategory = service.update(productCategory);

        return ResponseEntity.status(HttpStatus.OK).body(productCategory);
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
