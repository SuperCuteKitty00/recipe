package com.example.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @Autowired
    private RecipeSubstationInfoRepository infoRepository;

    public String load_save(){

    }
}


