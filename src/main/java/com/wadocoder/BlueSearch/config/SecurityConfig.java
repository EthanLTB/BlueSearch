package com.wadocoder.BlueSearch.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.wadocoder.BlueSearch.filter.JwtFilter;
import com.wadocoder.BlueSearch.service.UserDetailsServiceImpl;
import com.wadocoder.BlueSearch.util.CustomPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private CustomPasswordEncoder passwordEncoder;
	@Autowired
	private JwtFilter jwtFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder.getPasswordEncoder());
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.csrf().disable().cors().disable();
        
        http = http.sessionManagement()
                   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                   .and();
        
        http = http.exceptionHandling()
                   .authenticationEntryPoint((request, response, ex) -> {
                       response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                   }).and();
                   
        http.authorizeRequests()
            .antMatchers("/api/auth/**").permitAll()
            .anyRequest().authenticated();
        
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        
    }
}
