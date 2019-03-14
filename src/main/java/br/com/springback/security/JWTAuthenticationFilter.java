package br.com.springback.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.springback.exception.CustomError;

public class JWTAuthenticationFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
		try {	  
	    
		HttpServletResponse res=(HttpServletResponse) response;
		Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request);
		if(authentication == null) {
            // custom error response class used across my project
			ObjectMapper mapper = new ObjectMapper();
			CustomError customError = new CustomError();
            customError.setErrors(new HashMap<String,String[]>());
			customError.getErrors().put("Email ou Password:",new String[] {" Dados incorretos"});
			res.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
			res.setContentType("aplication/json");
			PrintWriter out;
			out = res.getWriter();
	        out.print(mapper.writeValueAsString(customError));
	        out.flush();
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
		}catch (Exception e) {
				//e.printStackTrace();
		} 
	        
    }
		
		
	}
