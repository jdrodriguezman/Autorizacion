package com.example.demo.services;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.adapter.IEndpointManager;
import com.example.demo.model.Response;

@Service
public class AutenticacionServicesImpl implements AutenticacionService{
	
	@Autowired
	IEndpointManager endpointManager;

	@Override
	public Response capturarJWT(String user, String password, String contentType) {
            String url = "https://api.dialogo-bayportmx.com/Identity/Autenticacion/Ingreso";
            HashMap<String, String> authHeader = new HashMap<>();
            authHeader.put("username", user);
            authHeader.put("password", password);
            authHeader.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            ResponseEntity responseEntity = endpointManager.endpointConsumerClient(url, String.class, HttpMethod.POST, authHeader);
            List<String> token = responseEntity.getHeaders().get("Authorization");
            Response response = new Response();
            response.setToken(token.get(0));
            return response;
     
	}
	



}
