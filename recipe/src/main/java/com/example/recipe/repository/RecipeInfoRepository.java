package com.example.recipe.repository;

import com.example.recipe.entity.RecipeInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
//JpaRepository를 확장함으로, 기본적인 CRUD를 사용할 수 있도록 함.
public interface RecipeInfoRepository extends JpaRepository<RecipeInfoEntity, Long> {
//    List<RecipeInfoEntity> findByRCP_SEQ(int rcpSeq);
//    List<RecipeInfoEntity> deleteByRCP_SEQ(int rcpSeq);
}

