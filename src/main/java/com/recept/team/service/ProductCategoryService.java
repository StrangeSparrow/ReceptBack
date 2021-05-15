package com.recept.team.service;

import com.recept.team.model.ProductCategory;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductCategoryService {
    List<ProductCategory> getAll();

    ProductCategory getById(int id);

    ProductCategory add(ProductCategory productCategory);

    ProductCategory update(ProductCategory productCategory);

    void delete(int id);
}
