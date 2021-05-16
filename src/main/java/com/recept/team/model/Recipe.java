package com.recept.team.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "recipe")
@IdClass(RecipePK.class)
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
}
