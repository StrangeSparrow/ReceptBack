package com.recept.team.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductQuantityOnMenu {
    private Product product;
    private int allQuantity;
    private Unit unit;
}
