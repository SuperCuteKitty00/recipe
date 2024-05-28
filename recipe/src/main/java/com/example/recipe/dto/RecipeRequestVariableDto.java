package com.example.recipe.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

//api 호출: http://openapi.foodsafetykorea.go.kr/api/67b5f7a207cf4ca9899c/COOKRCP01/
//api키: 67b5f7a207cf4ca9899c
public class RecipeRequestVariableDto {
    String query;
    Integer startIdx;
    Integer endIdx;
    String recipe_name;

}
