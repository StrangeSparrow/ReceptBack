package com.recept.team.controller;

import com.recept.team.model.ProductQuantityOnMenu;
import com.recept.team.service.ProductListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product_list")
public class ProductListController {
    private final ProductListService service;

    @GetMapping
    public ResponseEntity<List<ProductQuantityOnMenu>> getProductListByMenuAndPerson
            (@PathParam("id") int id, @PathParam("person") int person) {
        List<ProductQuantityOnMenu> productListForMenu = service.getProductListForMenu(id, person);

        return ResponseEntity.ok(productListForMenu);
    }
}
