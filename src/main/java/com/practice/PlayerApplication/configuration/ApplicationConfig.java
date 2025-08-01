package com.practice.PlayerApplication.configuration;

import java.beans.Customizer;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationConfig {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		//httpSecurity.csrf(token -> token.disable());
		//httpSecurity.csrf(reqs -> reqs.ignoringRequestMatchers("/h2-console/**"));
		//httpSecurity.headers(frames -> frames.frameOptions(options -> options.disable()));
		
		httpSecurity.authorizeHttpRequests(requests -> requests.requestMatchers("/player/registering","/player/csrftoken").permitAll().anyRequest().authenticated());
		httpSecurity.formLogin(org.springframework.security.config.Customizer.withDefaults());
		httpSecurity.httpBasic(org.springframework.security.config.Customizer.withDefaults());
		
		return httpSecurity.build();
		
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		//UserDetails user1=org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder().username("user1").password("pass1").roles("user").build();
//		UserDetails user1=org.springframework.security.core.userdetails.User.withUsername("user1").password(passwordEncoder().encode("pass1")).roles("user").build();
//		//UserDetails user2=org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder().username("user2").password("pass2").roles("user").build();
//		UserDetails user2= org.springframework.security.core.userdetails.User.withUsername("user2").password(passwordEncoder().encode("pass2")).roles("admin").build();
//
//		return new InMemoryUserDetailsManager(user1, user2);
//	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		//daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		
		return daoAuthenticationProvider;
		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}
