package com.recipe.RecipeAssessment.service;

import com.recipe.RecipeAssessment.domain.Recipe;
import com.recipe.RecipeAssessment.dto.GetTypeResponse;
import com.recipe.RecipeAssessment.dto.RecipeRequest;
import com.recipe.RecipeAssessment.dto.Response;
import com.recipe.RecipeAssessment.repository.CreateRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeManager {



    @Autowired
    CreateRecipeRepository createRecipeRepository;
    public Response createrecipe(RecipeRequest recipeRequest){
        System.out.println("Request received in Service class");
        Response response =new Response();
        Recipe recipe=new Recipe();

        if(recipeRequest !=null){
            recipe.setRecipeName(recipeRequest.getRecipeName());
            recipe.setType(recipeRequest.getType());
            recipe.setDescription(recipeRequest.getDescription());
            recipe.setIngredients(recipeRequest.getIngredients());
            recipe.setServing(recipeRequest.getServe());
            recipe.setInstructions(recipeRequest.getInstructions());
            createRecipeRepository.save(recipe);
            response.setMessage("Recipe successfully added");

        }


        return response;
    }



    public Response updateRecipe(RecipeRequest recipeRequest){
        Response response =new Response();
        Recipe recipe=new Recipe();
        if(recipeRequest!=null){
            try {
                recipe = createRecipeRepository.findByRecipeName(recipeRequest.getRecipeName()).
                        orElseThrow(ResourceNotFoundException::new);
                recipe.setRecipeName(recipe.getRecipeName());
                recipe.setIngredients(recipeRequest.getIngredients());
                recipe.setType(recipeRequest.getType());
                recipe.setDescription(recipeRequest.getDescription());
                recipe.setServing(recipeRequest.getServe());
                recipe.setInstructions(recipe.getInstructions());
                createRecipeRepository.save(recipe);
                response.setMessage("Recipe Updated successfully");
            }catch(Exception e){
                e.getMessage();
            }

        }

        return  response;

    }

    public GetTypeResponse getAllRecipeFromType(String type){
        GetTypeResponse response=new GetTypeResponse();
        List<Recipe> recipes=createRecipeRepository.findAllByType(type);
        response.setRecipeList(recipes);
        return response;
    }

    public GetTypeResponse fetchRceipeByServings(String serving, String ingredient){
        GetTypeResponse response=new GetTypeResponse();
        List<Recipe> recipeList=createRecipeRepository.findAllByServingAndIngredients(serving,ingredient);
        response.setRecipeList(recipeList);
        return response;
    }

    public GetTypeResponse fetchRceipeByIngredient(String ingredient){
        GetTypeResponse response=new GetTypeResponse();
        List<Recipe> recipeList=createRecipeRepository.findAllByIngredients(ingredient);
        response.setRecipeList(recipeList);
        return response;
    }
}
