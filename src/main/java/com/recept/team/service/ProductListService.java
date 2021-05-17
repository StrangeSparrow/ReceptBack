package com.recept.team.service;

import com.recept.team.model.ProductQuantityOnMenu;

import java.util.List;

public interface ProductListService {
    List<ProductQuantityOnMenu> getProductListForMenu(int menuId, int persons);
}
