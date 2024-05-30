package com.example.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import com.example.recipe.service.RecipeService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeApplication implements CommandLineRunner {

	@Autowired
	private RecipeService recipeService;



	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}

	public void run(String... args) throws Exception {
		String url = "https://openapi.foodsafetykorea.go.kr/api/824d6fec3b194884b2aa/COOKRCP01/json/1/1000";
		recipeService.RcpLoadAndSave(url);
		url = "https://openapi.foodsafetykorea.go.kr/api/824d6fec3b194884b2aa/COOKRCP01/json/1001/1124";
		recipeService.RcpLoadAndSave(url);
	}
}
