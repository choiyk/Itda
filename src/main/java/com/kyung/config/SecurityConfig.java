package com.kyung.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kyung.service.UserAuthenticationProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired UserAuthenticationProvider userAuthenticationProvider;
	
	@Override
	public void configure(WebSecurity web) throws Exception 
	{
		//web.ignoring().antMatchers("/index.jsp");
		web.ignoring().antMatchers("/res/**");
		web.ignoring().antMatchers("/lib/**");
		web.ignoring().antMatchers("/js/**");
		web.ignoring().antMatchers("/img/**");
		web.ignoring().antMatchers("/css/**");
		web.ignoring().antMatchers("/contactform/**");
		web.ignoring().antMatchers("/WEB-INF/include/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests()
			.antMatchers("/admin/**").access("ROLE_ADMIN")
			.antMatchers("/users/**").access("ROLE_USER")
			.antMatchers("/guest/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/**").authenticated();
		
		http.csrf().disable();
		
		http.formLogin()
			.loginPage("/guest/login")
			.loginProcessingUrl("/guest/login_processing")
			.failureUrl("/guest/login?error")
			.defaultSuccessUrl("/user/index", true)
			.usernameParameter("loginId")
			.passwordParameter("passwd");
		
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout_processing"))
			.logoutSuccessUrl("/guest/login")
			.invalidateHttpSession(true);
		
		http.authenticationProvider(userAuthenticationProvider);
	}
}
