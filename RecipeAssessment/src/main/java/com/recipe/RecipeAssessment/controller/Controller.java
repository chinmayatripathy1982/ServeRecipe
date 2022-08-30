package com.recipe.RecipeAssessment.controller;

import com.recipe.RecipeAssessment.dto.GetTypeResponse;
import com.recipe.RecipeAssessment.dto.RecipeRequest;
import com.recipe.RecipeAssessment.dto.Response;
import com.recipe.RecipeAssessment.service.RecipeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")

public class Controller {

   @Autowired
   RecipeManager recipeManager;

    @PostMapping("/createRecipe")
    public ResponseEntity<Response> createRecipe(@RequestBody RecipeRequest recipeRequest){
        System.out.println("Request received in controller");
        return ResponseEntity.ok(recipeManager.createrecipe(recipeRequest));
     }

         @PostMapping("/update")
    public ResponseEntity<Response> updaterecipe(@RequestBody RecipeRequest updateRequest){
         System.out.println("Request received in update controller");
         return ResponseEntity.ok(recipeManager.updateRecipe(updateRequest));
     }

     @GetMapping("/type")
    public ResponseEntity<GetTypeResponse> getAllTypeRecipe(@RequestParam String type){
        return ResponseEntity.ok(recipeManager.getAllRecipeFromType(type));
     }

     @GetMapping("/serving")
    public ResponseEntity<GetTypeResponse> getAllServingByIngredient(@RequestParam String serving,@RequestParam String ingredient){
         return ResponseEntity.ok(recipeManager.fetchRceipeByServings(serving,ingredient));
     }

     @GetMapping("/ingredient")
    public ResponseEntity<GetTypeResponse> getAllRecipeByIngredient(@RequestParam String ingredient){
         return ResponseEntity.ok(recipeManager.fetchRceipeByIngredient(ingredient));
     }
}
