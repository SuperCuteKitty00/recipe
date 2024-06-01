// 서비스
// 타임리프에서 엔티티 객체를 직접 사용하면 민감한 데이터가 노출될 위험이 있음
// 리포지터리를 직접 사용하지 않고 컨트롤러 → 서비스 → 리포지터리 순서로 접근

package com.example.recipe.service;

import com.example.recipe.entity.User;
import com.example.recipe.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	// BcryptPasswordEncoder 객체를 직접 생성하여 사용하지 않고 빈으로 등록한 Password Encoder 객체를 주입받아 사용할 수 있도록 함
	private final PasswordEncoder passwordEncoder;

	// User 리포지터리(UserRepository)를 사용하여 회원(User) 데이터를 생성
	public User create(String username, String usernickname, String email, String password) {
		User user = new User();
		user.setUsername(username);
		user.setUsernickname(usernickname);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		this.userRepository.save(user);
		return user;
	}
}
