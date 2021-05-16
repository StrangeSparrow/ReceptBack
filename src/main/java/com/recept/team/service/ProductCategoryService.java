package com.recept.team.service;

import com.recept.team.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getAll();

    ProductCategory getById(int id);

    ProductCategory add(ProductCategory productCategory);

    ProductCategory update(ProductCategory productCategory);

    void delete(int id);
}
