package com.example.recipe.service;

import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    public String transformPartsDetails(String rcpPartsDtls) {
        /* 재료 데이터 변환 로직 */
        return rcpPartsDtls.replaceAll("\\s?\\d+\\w*\\([^)]*\\)", "").replaceAll(",\\s+", ",").replaceAll("\\s+", " ");
    }

}
