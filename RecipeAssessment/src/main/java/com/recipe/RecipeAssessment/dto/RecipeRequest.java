package com.recipe.RecipeAssessment.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class RecipeRequest {

    public String recipeName;
    public String type;
    public String description;
    public String ingredients;
    public String serve;
    public String instructions;
}
