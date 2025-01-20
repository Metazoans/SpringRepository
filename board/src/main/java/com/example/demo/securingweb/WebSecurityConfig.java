package com.example.demo.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig {
	
	// 비밀번호 암호화
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/main").permitAll()
				.requestMatchers("/board/list").permitAll()
				.requestMatchers("/board/*").authenticated()
				.requestMatchers("/emp/*").hasRole("ADMIN")
				.requestMatchers("/dept/*").hasRole("ADMIN")
	            .requestMatchers("/css/**", "/js/**", "/images/**", "/layouts/**").permitAll()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.usernameParameter("userid")
				.successHandler(authenticationSuccessHandler())
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
			;

		http.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()));
		return http.build();
	}
	
	// 로그인 핸들러
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	// 권한 핸들러
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
}