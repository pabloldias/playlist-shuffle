package br.com.pabloldias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wrapper.spotify.Api;

import br.com.pabloldias.AppProperties;

@Configuration
public class ApiConfiguration {

	@Autowired
	private AppProperties properties;
	
	@Bean
	public Api buildApi() {
		return Api.builder()
				.clientId(properties.getClientId())
				.clientSecret(properties.getClientSecret())
				.redirectURI(properties.getRedirectURI())
				.build();
	}
	
}
