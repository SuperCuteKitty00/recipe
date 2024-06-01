package com.example.recipe.controller;

import com.example.recipe.form.UserCreateForm;
import com.example.recipe.service.UserService;
import jakarta.persistence.Table;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 롬복(Lombok)이 제공하는 애너테이션, final이 붙은 속성을 포함하는 생성자를 자동으로 만듦
@Controller
@RequestMapping("/user") //URL의 프리픽스, URL 매핑 시 value 매개변수는 생략할 수 있다. -> 메서드 단위에서는 /user을 생략하고 그 뒷부분만을 적으면 됨
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form"; // 템플릿 파일 이름인 'signup_form'를 리턴 -> signup_form.html 내용 브라우저 출력
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        // bindingResult.rejectValue(필드명, 오류 코드, 오류 메시지): 입력 받은 2개의 비밀번호가 서로 일치하지 않을 경우 오류 메시지 발생
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");

            return "signup_form";
        }

        // userService.create 메서드를 사용하여 사용자로부터 전달받은 데이터를 저장
        // 회원 가입 시 이미 동일한 사용자ID, 닉네임, 이메일 주소, 비밀번호가 있다는 것을 알리는 메시지가 나타나게 함
        try {
            userService.create(userCreateForm.getUsername(),
                    userCreateForm.getUsernickname(),
                    userCreateForm.getEmail(),
                    userCreateForm.getPassword1());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }
}
