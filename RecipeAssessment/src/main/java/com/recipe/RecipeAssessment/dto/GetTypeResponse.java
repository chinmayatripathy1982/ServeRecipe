package com.recipe.RecipeAssessment.dto;

import com.recipe.RecipeAssessment.domain.Recipe;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class GetTypeResponse {

    List<Recipe> recipeList;
}
