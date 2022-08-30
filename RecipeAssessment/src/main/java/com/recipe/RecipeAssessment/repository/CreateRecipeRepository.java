package com.recipe.RecipeAssessment.repository;

import com.recipe.RecipeAssessment.domain.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CreateRecipeRepository extends JpaRepository<Recipe, Long> {

   Optional<Recipe> findByRecipeName(String recipeName);


   @Query("from Recipe where type =:type")
   List<Recipe> findAllByType(String type);

   @Query("from Recipe where serving=:serving and ingredients=:ingredient")
   List<Recipe> findAllByServingAndIngredients(String serving,String ingredient);

   @Query("from Recipe where ingredients=:ingredient")
   List<Recipe> findAllByIngredients(String ingredient);

}
