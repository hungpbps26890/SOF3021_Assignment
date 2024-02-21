package com.poly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.*;

@Configuration
@EnableWebSecurity
public class SercurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChan(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests( auth -> {
					auth.requestMatchers("/**").permitAll();
					auth.anyRequest().authenticated();
				})
				.oauth2Login(ou -> ou
			            .authorizationEndpoint(e -> e.baseUri("/oauth2/authorization/**"))
			            .redirectionEndpoint(e -> e.baseUri("/login/oauth2/code/*")))
			        .exceptionHandling(e -> e.accessDeniedPage("/account/accessDenied"))
				.formLogin(form -> form
			            .loginPage("/account/login")
			            .usernameParameter("email")
			            .passwordParameter("password")
			            .loginProcessingUrl("/account/login-check")
			            .defaultSuccessUrl("/account/login/success")
			            .failureUrl("/account/login/failure"))
				.build();
	}
}
