package com.recept.team.service.impl;

import com.recept.team.model.Dish;
import com.recept.team.model.Menu;
import com.recept.team.model.ProductQuantityOnMenu;
import com.recept.team.model.Recipe;
import com.recept.team.service.MenuService;
import com.recept.team.service.ProductListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductListServiceImpl implements ProductListService {
    private final MenuService menuService;

    @Override
    public List<ProductQuantityOnMenu> getProductListForMenu(int id, int persons) {
        Menu menu = menuService.getById(id);

        List<ProductQuantityOnMenu> allProductFromMenu = getAllProductFromMenu(menu);

        List<ProductQuantityOnMenu> productList = getProductList(allProductFromMenu);

        return productList.stream()
                .peek(product -> {
                    product.setAllQuantity(product.getAllQuantity() * persons);
                })
                .collect(Collectors.toList());
    }

    private List<ProductQuantityOnMenu> getAllProductFromMenu(Menu menu) {
        List<ProductQuantityOnMenu> productFromMenu = new ArrayList<>();

        List<Dish> dishes = menu.getDishes();
        for (Dish dish : dishes) {
            List<Recipe> recipes = dish.getRecipes();

            productFromMenu.addAll(getAllProductFromRecipe(recipes));
        }

        return productFromMenu;
    }

    private List<ProductQuantityOnMenu> getAllProductFromRecipe(List<Recipe> recipes) {
        List<ProductQuantityOnMenu> productQuantityByMenu = new ArrayList<>();

        for (Recipe recipe : recipes) {
            ProductQuantityOnMenu product = new ProductQuantityOnMenu();
            product.setProduct(recipe.getProduct());
            product.setAllQuantity(recipe.getQuantity());
            product.setUnit(recipe.getUnit());

            productQuantityByMenu.add(product);
        }

        return productQuantityByMenu;
    }

    private List<ProductQuantityOnMenu> getProductList(List<ProductQuantityOnMenu> productQuantityOnMenus) {
        Map<Integer, ProductQuantityOnMenu> productMap = new HashMap<>();

        for (ProductQuantityOnMenu product : productQuantityOnMenus) {
            int id = product.getProduct().getId();

            if (productMap.containsKey(id)) {
                int quantity = productMap.get(id).getAllQuantity();
                quantity += product.getAllQuantity();
                productMap.get(id).setAllQuantity(quantity);
            } else {
                productMap.put(product.getProduct().getId(), product);
            }
        }

        return mapToSet(productMap);
    }

    private List<ProductQuantityOnMenu> mapToSet(Map<Integer, ProductQuantityOnMenu> productMap) {
        List<ProductQuantityOnMenu> productList = new ArrayList<>();

        for (Map.Entry<Integer, ProductQuantityOnMenu> product : productMap.entrySet()) {
            productList.add(product.getValue());
        }

        return productList;
    }
}
