package com.recipe.RecipeAssessment.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Table(name="RECIPE_MANAGER")
public class Recipe extends BaseEntity{

    @Column(name = "recipeName")
    String recipeName;

    @Column(name= "type")
    String type;

    @Column(name = "description")
    String description;

    @Column(name = "ingredients")
    String ingredients;

    @Column(name="servings")
    String serving;

    @Column(name="Instructions")
    String instructions;


}
