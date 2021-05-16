package com.recept.team.service;

import com.recept.team.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getAll();

    Menu getById(int id);

    Menu add(Menu menu);

    Menu update(Menu menu);

    void delete(int id);
}
