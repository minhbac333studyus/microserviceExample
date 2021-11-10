package com.example.demo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class AuthenticationFilter extends BasicAuthenticationFilter {
	Environment environment;
	public AuthenticationFilter(AuthenticationManager authManager, Environment enviroment) {
		super(authManager);
		this.environment = enviroment;
		
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res, FilterChain chain) throws IOException, ServletException{
		String authorizationHeader = req.getHeader(environment.getProperty("authorization.token.header.name"));
		if(authorizationHeader == null || !authorizationHeader.startsWith(environment.getProperty("authorization.token.header.name"))) {
			
		}
	}
}
