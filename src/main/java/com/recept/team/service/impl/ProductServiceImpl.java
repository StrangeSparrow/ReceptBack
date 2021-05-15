package com.recept.team.service.impl;

import com.recept.team.model.Product;
import com.recept.team.repository.ProductRepo;
import com.recept.team.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(int id) {
        Optional<Product> product = repository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product add(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
