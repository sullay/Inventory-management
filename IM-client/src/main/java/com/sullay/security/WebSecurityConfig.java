package com.sullay.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	UserDetailsService customUserService() {
		return new CustomUserService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 .exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint())
		 	 .and()
         .authorizeRequests()
             .antMatchers("/static/**","/login","/login.html").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
         	 .loginPage("/login_page")
             .loginProcessingUrl("/login")
             .usernameParameter("username")
             .passwordParameter("password")
             .successHandler(new AjaxAuthSuccessHandler())
             .failureHandler(new AjaxAuthFailHandler())
             .permitAll()
             .and()
         .logout()
             .permitAll()
             .and()
         .csrf().disable();
		
	}
	
}
