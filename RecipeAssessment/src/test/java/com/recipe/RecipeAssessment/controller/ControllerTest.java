package com.recipe.RecipeAssessment.controller;

import com.recipe.RecipeAssessment.dto.RecipeRequest;
import com.recipe.RecipeAssessment.dto.Response;
import com.recipe.RecipeAssessment.service.RecipeManager;
import jdk.jshell.Snippet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.nio.file.Files;
import java.nio.file.Paths;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = Controller.class)
public class ControllerTest {

    @InjectMocks
    private Controller controller;

    @MockBean
    private RecipeManager recipeManager;

    @MockBean
    RestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void testCreateRecipe() throws Exception {
        RecipeRequest recipeRequest = new RecipeRequest();
        String request = readFileToString("request/createRequest.json");

        when(recipeManager.createrecipe(recipeRequest)).thenReturn(new Response());

        mockMvc.perform(post("/recipe/createRecipe").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk());


    }

    @Test
    public void testfetchrecipe() throws Exception {
        RecipeRequest recipeRequest = new RecipeRequest();


        when(recipeManager.createrecipe(recipeRequest)).thenReturn(new Response());

        mockMvc.perform(get("/recipe/type").param("type","Veg"))
                .andExpect(status().isOk());


    }

    @Test
    public void testfetchrecipeByIngredient() throws Exception {
        RecipeRequest recipeRequest = new RecipeRequest();


        when(recipeManager.createrecipe(recipeRequest)).thenReturn(new Response());

        mockMvc.perform(get("/recipe/serving").param("serving","Veg").param("ingredient","Chicken"))
                .andExpect(status().isOk());


    }


    @Test
    public void testUpdateCase() throws Exception {
        RecipeRequest recipeRequest = new RecipeRequest();
        String request = readFileToString("request/createRequest.json");

        when(recipeManager.createrecipe(recipeRequest)).thenReturn(new Response());

        mockMvc.perform(post("/recipe/update").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk());


    }

    public String readFileToString(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(path).toURI())));
    }

}
