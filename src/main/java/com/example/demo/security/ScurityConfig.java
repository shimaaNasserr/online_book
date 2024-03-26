package com.example.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ScurityConfig {
	@Bean
public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
	http.csrf(
			httpSecurityConfigruer -> httpSecurityConfigruer.disable()
			).authorizeHttpRequests(
					authRequest -> {authRequest.requestMatchers("/**").authenticated();
//					authRequest.requestMatchers("/**").permitAll();
					}
					).httpBasic(org.springframework.security.config.Customizer.withDefaults());
	return http.build();
}
	@Bean
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //return new crypted pass
	}
}
