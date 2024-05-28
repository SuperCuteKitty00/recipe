package com.example.recipe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RecipeSubstationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int RCP_SEQ;
    private RecipeSubstationInfo() {}
    private String RCP_NM;
    private String RCP_WAY2;
    private String RCP_PAT2;
    private String INFO_WGT;
    private String INFO_ENG;
    private String INFO_CAR;
    private String INFO_PRO;
    private String INFO_FAT;
    private String INFO_NA;
    private String HASH_TAG;
    private String ATT_FILE_NO_MAIN; //이미지경로(소)
    private String ATT_FILE_NO_MK;   //이미지경로(대)
    private String RCP_PARTS_DTLS;
    private String MANUAL01; private String MANUAL02; private String MANUAL03; private String MANUAL04; private String MANUAL05;
    private String MANUAL06; private String MANUAL07; private String MANUAL08; private String MANUAL09; private String MANUAL10;
    private String MANUAL11; private String MANUAL12; private String MANUAL13; private String MANUAL14; private String MANUAL15;
    private String MANUAL16; private String MANUAL17; private String MANUAL18; private String MANUAL19; private String MANUAL20;
    private String MANUAL_IMG01; private String MANUAL_IMG02; private String MANUAL_IMG03; private String MANUAL_IMG04; private String MANUAL_IMG05;
    private String MANUAL_IMG06; private String MANUAL_IMG07; private String MANUAL_IMG08; private String MANUAL_IMG09; private String MANUAL_IMG10;
    private String MANUAL_IMG11; private String MANUAL_IMG12; private String MANUAL_IMG13; private String MANUAL_IMG14; private String MANUAL_IMG15;
    private String MANUAL_IMG16; private String MANUAL_IMG17; private String MANUAL_IMG18; private String MANUAL_IMG19; private String MANUAL_IMG20;

    public RecipeSubstationInfo(int id, int RCP_SEQ, String RCP_NM, String RCP_WAY2, String RCP_PAT2, String INFO_WGT, String INFO_ENG, String INFO_CAR, String INFO_PRO,
                                        String INFO_FAT, String INFO_NA, String HASH_TAG, String ATT_FILE_NO_MAIN, String ATT_FILE_NO_MK, String RCP_PARTS_DTLS,
                                        String MANUAL01, String MANUAL02, String MANUAL03, String MANUAL04, String MANUAL05,
                                        String MANUAL06, String MANUAL07, String MANUAL08, String MANUAL09, String MANUAL10,
                                        String MANUAL11, String MANUAL12, String MANUAL13, String MANUAL14, String MANUAL15,
                                        String MANUAL16, String MANUAL17, String MANUAL18, String MANUAL19, String MANUAL20,
                                        String MANUAL_IMG01, String MANUAL_IMG02, String MANUAL_IMG03, String MANUAL_IMG04, String MANUAL_IMG05,
                                        String MANUAL_IMG06, String MANUAL_IMG07, String MANUAL_IMG08, String MANUAL_IMG09, String MANUAL_IMG10,
                                        String MANUAL_IMG11, String MANUAL_IMG12, String MANUAL_IMG13, String MANUAL_IMG14, String MANUAL_IMG15,
                                        String MANUAL_IMG16, String MANUAL_IMG17, String MANUAL_IMG18, String MANUAL_IMG19, String MANUAL_IMG20) {

        this.RCP_SEQ = id;
        this.RCP_SEQ = RCP_SEQ;
        this.RCP_NM = RCP_NM;
        this.RCP_WAY2 = RCP_WAY2;
        this.RCP_PAT2 = RCP_PAT2;
        this.INFO_WGT = INFO_WGT;
        this.INFO_ENG = INFO_ENG;
        this.INFO_CAR = INFO_CAR;
        this.INFO_PRO = INFO_PRO;
        this.INFO_FAT = INFO_FAT;
        this.INFO_NA = INFO_NA;
        this.HASH_TAG = HASH_TAG;
        this.ATT_FILE_NO_MAIN = ATT_FILE_NO_MAIN;
        this.ATT_FILE_NO_MK = ATT_FILE_NO_MK;
        this.RCP_PARTS_DTLS = RCP_PARTS_DTLS;
        this.MANUAL01 = MANUAL01; this.MANUAL02 = MANUAL02; this.MANUAL03 = MANUAL03; this.MANUAL04 = MANUAL04; this.MANUAL05 = MANUAL05;
        this.MANUAL06 = MANUAL06; this.MANUAL07 = MANUAL07; this.MANUAL08 = MANUAL08; this.MANUAL09 = MANUAL09; this.MANUAL10 = MANUAL10;
        this.MANUAL11 = MANUAL11; this.MANUAL12 = MANUAL12; this.MANUAL13 = MANUAL13; this.MANUAL14 = MANUAL14; this.MANUAL15 = MANUAL15;
        this.MANUAL16 = MANUAL16; this.MANUAL17 = MANUAL17; this.MANUAL18 = MANUAL18; this.MANUAL19 = MANUAL19; this.MANUAL20 = MANUAL20;
        this.MANUAL_IMG01 = MANUAL_IMG01; this.MANUAL_IMG02 = MANUAL_IMG02; this.MANUAL_IMG03 = MANUAL_IMG03; this.MANUAL_IMG04 = MANUAL_IMG04; this.MANUAL_IMG05 = MANUAL_IMG05;
        this.MANUAL_IMG06 = MANUAL_IMG06; this.MANUAL_IMG07 = MANUAL_IMG07; this.MANUAL_IMG08 = MANUAL_IMG08; this.MANUAL_IMG09 = MANUAL_IMG09; this.MANUAL_IMG10 = MANUAL_IMG10;
        this.MANUAL_IMG11 = MANUAL_IMG11; this.MANUAL_IMG12 = MANUAL_IMG12; this.MANUAL_IMG13 = MANUAL_IMG13; this.MANUAL_IMG14 = MANUAL_IMG14; this.MANUAL_IMG15 = MANUAL_IMG15;
        this.MANUAL_IMG16 = MANUAL_IMG16; this.MANUAL_IMG17 = MANUAL_IMG17; this.MANUAL_IMG18 = MANUAL_IMG18; this.MANUAL_IMG19 = MANUAL_IMG19; this.MANUAL_IMG20 = MANUAL_IMG20;
    }

}
