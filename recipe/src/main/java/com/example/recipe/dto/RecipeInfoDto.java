package com.example.recipe.dto;

import lombok.Getter;

@Getter
public class RecipeInfoDto {
    private int rcpSeq;             //레시피 번호
    private String rcpNm;           //레시피 이름
    private String rcpWay;          //조리 방법
    private String rcpPat;          //요리 종류 ex)반찬
    private String hashTag;         //해쉬 태그
    private String attFileNoMain;   //메인 사진
    private String attFileNoMk;     //작은 사진
    private String rcpPartsDtls;    //요리 재료
}
