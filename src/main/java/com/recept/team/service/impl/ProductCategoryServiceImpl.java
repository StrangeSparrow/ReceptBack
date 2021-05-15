package com.recept.team.service.impl;

import com.recept.team.model.ProductCategory;
import com.recept.team.repository.ProductCategoryRepo;
import com.recept.team.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepo repository;

    @Override
    public List<ProductCategory> getAll() {
        List<ProductCategory> productCategories = repository.findAll();

        return productCategories;
    }

    @Override
    public ProductCategory getById(int id) {
        Optional<ProductCategory> productCategory = repository.findById(id);

        return productCategory.orElse(null);
    }

    @Override
    public ProductCategory add(ProductCategory productCategory) {
        ProductCategory saveProductCategory = repository.save(productCategory);

        return saveProductCategory;
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        ProductCategory updateProductCategory = repository.save(productCategory);

        return updateProductCategory;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
