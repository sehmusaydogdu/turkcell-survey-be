package com.turkcell.survey.authentication;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import com.turkcell.survey.authentication.model.response.UserOutput;
import com.turkcell.survey.util.PropertyKeys;

public class AuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private PropertyKeys propertyKeys;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserOutput userOutput = (UserOutput) session.getAttribute(propertyKeys.getUserSession());

		boolean isAuthentication = Optional.ofNullable(userOutput).isEmpty();
		boolean isRequestApiLogin = "/api/login".equals(request.getRequestURI());

		if (isAuthentication) {
			if (isRequestApiLogin)
				filterChain.doFilter(request, response);
			else
				response.sendError(HttpStatus.UNAUTHORIZED.value());
		} else {
			filterChain.doFilter(request, response);
		}
	}
}
