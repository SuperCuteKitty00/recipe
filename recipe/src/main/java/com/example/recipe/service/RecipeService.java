package com.example.recipe.service;

import com.example.recipe.entity.RecipeInfoEntity;
import com.example.recipe.repository.Repository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//import java.io.IOException;

//api 키: 824d6fec3b194884b2aa
//api url 형식: http://openapi.foodsafetykorea.go.kr/api/keyId/serviceId/dataType/startIdx/endIdx
//api url: http://openapi.foodsafetykorea.go.kr/api/824d6fec3b194884b2aa/COOKRCP01/json/

@Service
public class RecipeService {

    @Autowired
    private Repository recipeInfoRepository;
    @Autowired
    private RestTemplate restTemplate;

    public String transformPartsDetails(String rcpPartsDtls) {
        /* 재료 데이터 변환 로직
           예시 데이터: "연두부 75g(3/4모), 칵테일새우 20g(5마리), 달걀 30g(1/2개), 생크림 13g(1큰술), 설탕 5g(1작은술), 무염버터 5g(1작은술) 고명 시금치 10g(3줄기)"
           변환 후: "연두부, 칵테일새우, 달걀, 생크림, 설탕, 무염버터, 고명 시금치" */
        return rcpPartsDtls.replaceAll("\\s?\\d+\\w*\\([^)]*\\)", "")
                .replaceAll(",\\s+", ",")
                .replaceAll("\\s+", " ");
    }

    public void RcpLoadAndSave(String apiUrl) {
        try {
            String jsonString = restTemplate.getForObject(apiUrl, String.class);
            List<RecipeInfoEntity> tmp = mapJsonToEntities(jsonString);

            recipeInfoRepository.saveAll(tmp);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public List<RecipeInfoEntity> mapJsonToEntities(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);
        JsonNode recipes = rootNode.path("COOKRCP01").path("row");

        List<RecipeInfoEntity> recipeInfoEntities = new ArrayList<>();
        for (JsonNode recipeNode : recipes) {
            RecipeInfoEntity recipeInfoEntity = new RecipeInfoEntity();

            recipeInfoEntity.setRCP_SEQ(recipeNode.path("RCP_SEQ").asInt());
            recipeInfoEntity.setRCP_NM(recipeNode.path("RCP_NM").asText());
            recipeInfoEntity.setRCP_WAY2(recipeNode.path("RCP_WAY2").asText());
            recipeInfoEntity.setRCP_PAT2(recipeNode.path("RCP_PAT2").asText());
            recipeInfoEntity.setINFO_WGT(recipeNode.path("INFO_WGT").asText());
            recipeInfoEntity.setINFO_ENG(recipeNode.path("INFO_ENG").asText());
            recipeInfoEntity.setINFO_CAR(recipeNode.path("INFO_CAR").asText());
            recipeInfoEntity.setINFO_PRO(recipeNode.path("INFO_PRO").asText());
            recipeInfoEntity.setINFO_FAT(recipeNode.path("INFO_FAT").asText());
            recipeInfoEntity.setINFO_NA(recipeNode.path("INFO_NA").asText());
            recipeInfoEntity.setHASH_TAG(recipeNode.path("HASH_TAG").asText());
            recipeInfoEntity.setATT_FILE_NO_MAIN(recipeNode.path("ATT_FILE_NO_MAIN").asText());
            recipeInfoEntity.setATT_FILE_NO_MK(recipeNode.path("ATT_FILE_NO_MK").asText());
            recipeInfoEntity.setRCP_PARTS_DTLS(recipeNode.path("RCP_PARTS_DTLS").asText());
            recipeInfoEntity.setMANUAL01(recipeNode.path("MANUAL01").asText());
            recipeInfoEntity.setMANUAL02(recipeNode.path("MANUAL02").asText());
            recipeInfoEntity.setMANUAL03(recipeNode.path("MANUAL03").asText());
            recipeInfoEntity.setMANUAL04(recipeNode.path("MANUAL04").asText());
            recipeInfoEntity.setMANUAL05(recipeNode.path("MANUAL05").asText());
            recipeInfoEntity.setMANUAL06(recipeNode.path("MANUAL06").asText());
            recipeInfoEntity.setMANUAL07(recipeNode.path("MANUAL07").asText());
            recipeInfoEntity.setMANUAL08(recipeNode.path("MANUAL08").asText());
            recipeInfoEntity.setMANUAL09(recipeNode.path("MANUAL09").asText());
            recipeInfoEntity.setMANUAL10(recipeNode.path("MANUAL10").asText());
            recipeInfoEntity.setMANUAL11(recipeNode.path("MANUAL11").asText());
            recipeInfoEntity.setMANUAL12(recipeNode.path("MANUAL12").asText());
            recipeInfoEntity.setMANUAL13(recipeNode.path("MANUAL13").asText());
            recipeInfoEntity.setMANUAL14(recipeNode.path("MANUAL14").asText());
            recipeInfoEntity.setMANUAL15(recipeNode.path("MANUAL15").asText());
            recipeInfoEntity.setMANUAL16(recipeNode.path("MANUAL16").asText());
            recipeInfoEntity.setMANUAL17(recipeNode.path("MANUAL17").asText());
            recipeInfoEntity.setMANUAL18(recipeNode.path("MANUAL18").asText());
            recipeInfoEntity.setMANUAL19(recipeNode.path("MANUAL19").asText());
            recipeInfoEntity.setMANUAL20(recipeNode.path("MANUAL20").asText());
            recipeInfoEntity.setMANUAL_IMG01(recipeNode.path("MANUAL_IMG01").asText());
            recipeInfoEntity.setMANUAL_IMG02(recipeNode.path("MANUAL_IMG02").asText());
            recipeInfoEntity.setMANUAL_IMG03(recipeNode.path("MANUAL_IMG03").asText());
            recipeInfoEntity.setMANUAL_IMG04(recipeNode.path("MANUAL_IMG04").asText());
            recipeInfoEntity.setMANUAL_IMG05(recipeNode.path("MANUAL_IMG05").asText());
            recipeInfoEntity.setMANUAL_IMG06(recipeNode.path("MANUAL_IMG06").asText());
            recipeInfoEntity.setMANUAL_IMG07(recipeNode.path("MANUAL_IMG07").asText());
            recipeInfoEntity.setMANUAL_IMG08(recipeNode.path("MANUAL_IMG08").asText());
            recipeInfoEntity.setMANUAL_IMG09(recipeNode.path("MANUAL_IMG09").asText());
            recipeInfoEntity.setMANUAL_IMG10(recipeNode.path("MANUAL_IMG10").asText());
            recipeInfoEntity.setMANUAL_IMG11(recipeNode.path("MANUAL_IMG11").asText());
            recipeInfoEntity.setMANUAL_IMG12(recipeNode.path("MANUAL_IMG12").asText());
            recipeInfoEntity.setMANUAL_IMG13(recipeNode.path("MANUAL_IMG13").asText());
            recipeInfoEntity.setMANUAL_IMG14(recipeNode.path("MANUAL_IMG14").asText());
            recipeInfoEntity.setMANUAL_IMG15(recipeNode.path("MANUAL_IMG15").asText());
            recipeInfoEntity.setMANUAL_IMG16(recipeNode.path("MANUAL_IMG16").asText());
            recipeInfoEntity.setMANUAL_IMG17(recipeNode.path("MANUAL_IMG17").asText());
            recipeInfoEntity.setMANUAL_IMG18(recipeNode.path("MANUAL_IMG18").asText());
            recipeInfoEntity.setMANUAL_IMG19(recipeNode.path("MANUAL_IMG19").asText());
            recipeInfoEntity.setMANUAL_IMG20(recipeNode.path("MANUAL_IMG20").asText());
            recipeInfoEntity.setRCP_NA_TIP(recipeNode.path("RCP_NA_TIP").asText());

            recipeInfoEntities.add(recipeInfoEntity);
        }
        return recipeInfoEntities;
    }




}




