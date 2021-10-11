package com.turkcell.survey.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.turkcell.survey.authentication.AuthenticationFilter;
import com.turkcell.survey.util.PropertyKeys;

@Configuration
public class AppConfiguration {

	@Bean
	public AuthenticationFilter filter() {
		return new AuthenticationFilter();
	}

	@Bean
	public PropertyKeys propertyKeys() {
		return new PropertyKeys();
	}
}
