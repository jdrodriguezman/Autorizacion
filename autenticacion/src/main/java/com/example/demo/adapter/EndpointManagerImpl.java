package com.example.demo.adapter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EndpointManagerImpl implements IEndpointManager {
	
	@Autowired
	private EndpointConfig endpointConfig;    

    public ResponseEntity endpointConsumerClient(final String pathEndpoint,
            final Class<?> typeResponse,
            final HttpMethod method,
            final HashMap<String, String> headers) {
		
		RestTemplate clientConsumer = new RestTemplate();
		HttpHeaders httpHeadersConsumer = endpointConfig.createAuthenticationHeaders();
		httpHeadersConsumer.setAll(headers);
		return clientConsumer.exchange(pathEndpoint, method, new HttpEntity<>(httpHeadersConsumer), String.class);
    }


}
