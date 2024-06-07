package com.example.recipe.service;

import com.example.recipe.entity.RecipeInfoEntity;
import com.example.recipe.repository.RecipeInfoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static javax.management.Query.match;
import static org.springframework.core.io.buffer.DataBufferUtils.matcher;

//api 키: 824d6fec3b194884b2aa
//api url 형식: http://openapi.foodsafetykorea.go.kr/api/keyId/serviceId/dataType/startIdx/endIdx
//api url: http://openapi.foodsafetykorea.go.kr/api/824d6fec3b194884b2aa/COOKRCP01/json/

@Service
public class RecipeService {

    @Autowired
    private RecipeInfoRepository recipeInfoRecipeInfoRepository;
    @Autowired
    private RestTemplate restTemplate;

    public String transformPartsDetails(String rcpPartsDtls) {
        /** 재료 데이터 변환 로직
           예시 데이터: "연두부 75g(3/4모), 칵테일새우 20g(5마리), 달걀 30g(1/2개), 생크림 13g(1큰술), 설탕 5g(1작은술), 무염버터 5g(1작은술) 고명 시금치 10g(3줄기)"
           변환 후: "연두부, 칵테일새우, 달걀, 생크림, 설탕, 무염버터, 고명 시금치". */
        String transformedPartsDetails = rcpPartsDtls.replaceAll("기준 •  |•필수|<br>|●|-|:|\\.|ml|g|인분|컵|송송 썬|불린 것|줄기부분|삶은것|주재료|주 재료|육수|마른것|양념|다진|부순|뿌리|으깬|데친|두 가지 색|재료|갈은것|다진것|개|적당량|소스|소스소개", "")
                .replace("로즈마리", "셰프리")
                .replace("마리", "")
                .replace("셰프리", "로즈마리")
                .replace("낙지 다리", "낙지")
                .replace("두부강된장 참기름", "강된장")
                .replaceAll("  ·장 |   |   | •   |    ", ",")
                .replace("파인애플 통조림", "파인애플")
                .replaceAll("\\(.*?\\)", "")
                .replaceAll("\\[.*?\\]", "")
                .replaceAll("\\d", "")
                .replaceAll("\\n", " ")
                .replaceFirst("^\\s+", "")
                .replaceAll("\\s*,\\s*", ", ")
                .replaceAll("[^ㄱ-ㅎ가-힣\\s]", "")
                .replaceAll("\\s+", ", ")
                .replaceFirst(", ","");

        //System.out.println(transformedPartsDetails);
        return transformedPartsDetails;
    }

    public void removeRcpNameFromRcpPartsDtls(String RcpPartsDtls,JsonNode recipes) {
        /**재료 필드에 들어있는 요리 이름을 정규식을 통해 삭제*/
        String tmp = RcpPartsDtls;
        String firstWord = tmp.split("\\s+")[0];
//        if(firstWord == )

    }

    public void RcpLoadAndSave(String apiUrl) {
        try {
            String jsonString = restTemplate.getForObject(apiUrl, String.class);
            List<RecipeInfoEntity> tmp = mapJsonToEntities(jsonString);

            recipeInfoRecipeInfoRepository.saveAll(tmp);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public List<RecipeInfoEntity> mapJsonToEntities(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        RecipeService recipeService = new RecipeService();
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
            recipeInfoEntity.setATT_FILE_NO_MAIN(recipeNode.path("ATT_FILE_NO_MAIN").asText());
            recipeInfoEntity.setATT_FILE_NO_MK(recipeNode.path("ATT_FILE_NO_MK").asText());
            recipeInfoEntity.setRCP_PARTS_DTLS(recipeNode.path("RCP_PARTS_DTLS").asText());
            //해쉬태그 생성
            recipeInfoEntity.setHASH_TAG(transformPartsDetails(recipeInfoEntity.getRCP_PARTS_DTLS()));


            recipeInfoEntity.setMANUAL01(recipeNode.path("MANUAL01").asText());
            recipeInfoEntity.setMANUAL02(recipeNode.path("MANUAL02").asText());
            recipeInfoEntity.setMANUAL03(recipeNode.path("MANUAL03").asText());
            recipeInfoEntity.setMANUAL04(recipeNode.path("MANUAL04").asText());
            recipeInfoEntity.setMANUAL05(recipeNode.path("MANUAL05").asText());
            recipeInfoEntity.setMANUAL06(recipeNode.path("MANUAL06").asText());
            recipeInfoEntity.setMANUAL_IMG01(recipeNode.path("MANUAL_IMG01").asText());
            recipeInfoEntity.setMANUAL_IMG02(recipeNode.path("MANUAL_IMG02").asText());
            recipeInfoEntity.setMANUAL_IMG03(recipeNode.path("MANUAL_IMG03").asText());
            recipeInfoEntity.setMANUAL_IMG04(recipeNode.path("MANUAL_IMG04").asText());
            recipeInfoEntity.setMANUAL_IMG05(recipeNode.path("MANUAL_IMG05").asText());
            recipeInfoEntity.setMANUAL_IMG06(recipeNode.path("MANUAL_IMG06").asText());
            recipeInfoEntity.setRCP_NA_TIP(recipeNode.path("RCP_NA_TIP").asText());

            recipeInfoEntities.add(recipeInfoEntity);
            System.out.println(recipeNode.path("RCP_SEQ").asText());
        }
        return recipeInfoEntities;
    }




}




