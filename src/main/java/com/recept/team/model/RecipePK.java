package com.recept.team.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class RecipePK implements Serializable {
    private Integer dish;
    private Integer product;
}
