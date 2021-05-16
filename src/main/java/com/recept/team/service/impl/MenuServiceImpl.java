package com.recept.team.service.impl;

import com.recept.team.model.Menu;
import com.recept.team.repository.MenuRepo;
import com.recept.team.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepo repository;

    @Override
    public List<Menu> getAll() {
        return repository.findAll();
    }

    @Override
    public Menu getById(int id) {
        Optional<Menu> menu = repository.findById(id);

        return menu.orElse(null);
    }

    @Override
    public Menu add(Menu menu) {
        return repository.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        return repository.save(menu);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
