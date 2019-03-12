package br.com.springback.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.filter.CorsFilter;

import br.com.springback.security.JWTAuthenticationFilter;
import br.com.springback.security.JWTLoginFilter;

@Configuration
@EnableWebSecurity(debug=true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().and().csrf().disable().authorizeRequests()
			.antMatchers("/home").permitAll()
			.antMatchers("/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/webjars/**",
                    "/api/v1/test/**"
					).permitAll()
			.antMatchers("/api/v1/login").permitAll()
			.anyRequest().authenticated()
			.and()
			// filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/api/v1/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
			// filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN").and().
	      withUser("comum").password("{noop}123456").roles("COMUM");

	
	}
	
//	@Bean
//	CorsFilter corsWebFilter() {
//		UrlBasedCorsConfigurationSource source = new     UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:3000");
//        config.setAllowedMethods(Arrays.asList("POST", "OPTIONS", "GET", "DELETE", "PUT"));
//        config.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization","Access-Control-Allow-Origin"));
//        source.registerCorsConfiguration("/**", config);
//
//        return new CorsFilter(source);	}
	
}
	
