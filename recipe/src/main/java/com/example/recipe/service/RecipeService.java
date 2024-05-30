package com.example.recipe.service;

import com.example.recipe.entity.RecipeInfo;
import com.example.recipe.repository.RecipeInfoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RecipeService {

    @Autowired
    private RecipeInfoRepository recipeInfoRepository;
    String url = "";

    private RecipeInfo saveRecipe(RecipeInfo recipeInfo){
        ObjectMapper objectMapper = new ObjectMapper();
            return recipeInfoRepository.save(recipeInfo);
    }

    public String transformPartsDetails(String rcpPartsDtls) {
        /* 재료 데이터 변환 로직
           예시 데이터: "연두부 75g(3/4모), 칵테일새우 20g(5마리), 달걀 30g(1/2개), 생크림 13g(1큰술), 설탕 5g(1작은술), 무염버터 5g(1작은술) 고명 시금치 10g(3줄기)"
           변환 후: "연두부, 칵테일새우, 달걀, 생크림, 설탕, 무염버터, 고명 시금치" */
        return rcpPartsDtls.replaceAll("\\s?\\d+\\w*\\([^)]*\\)", "").replaceAll(",\\s+", ",").replaceAll("\\s+", " ");
    }

}
