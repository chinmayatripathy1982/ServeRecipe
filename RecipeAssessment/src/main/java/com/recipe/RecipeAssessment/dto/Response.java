package com.recipe.RecipeAssessment.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    String message;
}
