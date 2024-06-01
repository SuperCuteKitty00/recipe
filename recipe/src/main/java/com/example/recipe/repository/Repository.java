package com.example.recipe.repository;

import com.example.recipe.entity.RecipeInfoEntity;
import com.example.recipe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
//JpaRepository를 확장함으로, 기본적인 CRUD를 사용할 수 있도록 함.
public interface Repository extends JpaRepository<RecipeInfoEntity, Integer> {
}
