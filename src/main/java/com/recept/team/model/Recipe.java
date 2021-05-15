package com.recept.team.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "recipe")
@IdClass(Recipe.RecipePK.class)
public class Recipe {
    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private Unit unit;

    public class RecipePK implements Serializable {
        private Integer dish;
        private Integer product;
    }
}
