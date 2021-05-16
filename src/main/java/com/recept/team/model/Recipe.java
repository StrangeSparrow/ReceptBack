package com.recept.team.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "recipe")
@IdClass(RecipePK.class)
public class Recipe {
    @Id
    private Dish dish;
    @Id
    private Product product;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private Unit unit;
}
