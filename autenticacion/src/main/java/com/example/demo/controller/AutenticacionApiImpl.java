package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.commons.constans.api.user.*;
import com.example.demo.model.Response;
import com.example.demo.services.AutenticacionService;


@RestController
@RequestMapping(value = EndpointApi.API)
public class AutenticacionApiImpl implements IAutenticacionApi{

	@Autowired
    private AutenticacionService service;	
	

	@Override
	@PostMapping(EndpointApi.GET_TOKEN)
	public Response capturarJWT(@RequestHeader("username") String user,@RequestHeader("password") String password,@RequestHeader("Content-Type") String contentType) {		
		return service.capturarJWT(user, password, contentType);
	}

}
