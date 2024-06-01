// 스프링 시큐리티: 회원 가입과 로그인을 도와줌
//스프링 기반 웹 애플리케이션의 인증과 권한을 담당하는 스프링의 하위 프레임워크
//		인증(authenticate): 로그인과 같은 사용자의 신원을 확인하는 프로세스
//		권한(authorize): 인증된 사용자가 어떤 일을 할 수 있는지(어떤 접근 권한이 있는지) 관리하는 것

package com.example.recipe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // 이 파일이 스프링의 환경 설정 파일임을 의미하는 애너테이션, 스프링 시큐리티를 설정하기 위해 사용
@EnableWebSecurity // 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션, 스프링 시큐리티를 활성화하는 역할
public class SecurityConfig {
	@Bean // 스프링 시큐리티의 세부 설정
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 인증되지 않은 모든 페이지의 요청을 허락-> 로그인하지 않더라도 모든 페이지에 접근 가능
		http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
				.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())

				// 스프링 시큐리티가 CSRF 처리 시 H2 콘솔은 예외로 처리할 수 있게 함
				.csrf((csrf) -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))

				.headers((headers) -> headers.addHeaderWriter(
						new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
				// 스프링 시큐리티에 로그인을 하기 위한 URL
				.formLogin((formLogin) -> formLogin.loginPage("//login").defaultSuccessUrl("/"))

				// 로그아웃 설정을 추가
				// 로그아웃 URL을 //logout으로 설정하고 로그아웃이 성공하면 루트(/) 페이지로 이동
				// .invalidateHttpSession(true): 로그아웃 시 생성된 사용자 세션 삭제
				.logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("//logout"))
						.logoutSuccessUrl("/").invalidateHttpSession(true));
		return http.build();
	}

	@Bean // BCryptPasswordEncoder 클래스를 사용하여 암호화하여 비밀번호를 저장
	// PasswordEncoder는 BCryptPasswordEncoder의 인터페이스
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean // AuthenticationManager: 스프링 시큐리티의 인증을 처리
	// 사용자 인증 시 앞에서 작성한 SecurityService와 PasswordEncoder를 내부적으로 사용하여 인증과 권한 부여 프로세스를 처리
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
