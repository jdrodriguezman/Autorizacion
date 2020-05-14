package com.example.demo.controller;

import com.example.demo.model.Response;

public interface IAutenticacionApi {
	
	Response capturarJWT(String user, String password, String contentType);
}
