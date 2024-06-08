package com.example.recipe.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "RCP_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int RCP_SEQ; //레시피 번호

    private String RCP_NM; //레시피 이름
    private String RCP_WAY2; //조리방법 ex)튀김류
    private String RCP_PAT2; //요리종류 ex)반찬
    private String INFO_WGT; //중량(1인분)
    private String INFO_ENG; //열량
    private String INFO_CAR; //탄수화물
    private String INFO_PRO; //단백질
    private String INFO_FAT; //지방
    private String INFO_NA; //나트륨
    private String HASH_TAG; //해시태그
    private String ATT_FILE_NO_MAIN; //이미지경로(소)
    private String ATT_FILE_NO_MK;   //이미지경로(대)
    private String RCP_PARTS_DTLS; //재료정보
    //이하 만드는 법 순서 1~20
    private String MANUAL01; private String MANUAL02; private String MANUAL03;
    private String MANUAL04; private String MANUAL05; private String MANUAL06;
    //이하 만드는 법 이미지 순서 1~20
    private String MANUAL_IMG01; private String MANUAL_IMG02; private String MANUAL_IMG03;
    private String MANUAL_IMG04; private String MANUAL_IMG05;private String MANUAL_IMG06;
    private String RCP_NA_TIP; //저감 조리법 TIP

}
