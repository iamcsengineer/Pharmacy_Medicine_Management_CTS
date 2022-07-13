package com.cts.pharmacyMedicineSupply.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.cts.pharmacyMedicineSupply.service.AdminDetailsService;

import lombok.extern.slf4j.Slf4j;


/*
 * It allows configuring things that impact all of web security. 
 * WebSecurityConfigurerAdapter is a convenience class that allows customization to both 
 * WebSecurity and HttpSecurity. We can extend WebSecurityConfigurerAdapter multiple 
 * times (in distinct objects) to replicate the behavior of having multiple http elements.
 */

@Slf4j
@EnableWebSecurity
public class ApplicationConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AdminDetailsService pmsuserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("START");
		super.configure(auth);
		auth.userDetailsService(pmsuserDetailsService);
		log.info("END");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("START");
		/*
		 * CSRF:Cross-Site Request Forgery
		 * Spring recommend using it when serving browser clients, 
		 * if not it may be disabled.
		 * You are using another token mechanism.
			You want to simplify interactions between a client and the server.
		 */
		http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and()
				.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		log.info("END");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		log.info("START");

		web.ignoring().antMatchers("/authapp/login", "/h2-console/**", "/v2/api-docs", "/configuration/ui",
				"/configuration/security", "/webjars/**");
		log.info("END");

	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		log.info("START");
		log.info("END");
		return super.authenticationManagerBean();
	}

}
