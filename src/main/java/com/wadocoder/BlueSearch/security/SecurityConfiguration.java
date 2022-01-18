package com.wadocoder.BlueSearch.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService)
	.passwordEncoder(passwordEncoder);
//	.withUser("Ethan123")
//	.password("$2a$10$nGEj.FPIoobX706NB9nu.OfL7CI28XrazvvfaHrY0NkhenBtFxnke")
//	.roles("HOMEOWNER", "TRADESPERSON");
}

@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/dashboard").hasAnyRole("HOMEOWNER")
		.antMatchers("/profile").hasAnyRole("HOMEOWNER")
		.antMatchers("/post").hasAnyRole("HOMEOWNER")
		.antMatchers("/bid/**").hasAnyRole("TRADESPERSON")
		.antMatchers("/register").anonymous()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/dashboard")
		.permitAll();
	}
}
