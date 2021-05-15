package com.recept.team.service;

import com.recept.team.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(int id);

    Product add(Product product);

    Product update(Product product);

    void delete(int id);
}
