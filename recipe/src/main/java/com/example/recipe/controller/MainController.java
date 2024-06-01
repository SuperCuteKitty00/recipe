package com.example.recipe.controller;

import jakarta.persistence.Table;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Table(name = "USER")
@Controller
public class MainController {

	@GetMapping("/") // 메인 페이지 링크(루트 URL)
	public String root(){
		return "login_form"; // TODO: 나중에 추천 레시핑로 바꿔야 함
	}

//	@GetMapping("/")
//	public String root() {
//		return "redirect:/recipe/list";
//	}
	// redirect:/ 는 라이언트가 요청하면 새로운 URL로 전송
	// localhost:8080로 접속하면 localhost:8080/recipe/list로 주소가 바뀌면서 추천레시피 목록이 있는 웹 페이지로 연결
}
