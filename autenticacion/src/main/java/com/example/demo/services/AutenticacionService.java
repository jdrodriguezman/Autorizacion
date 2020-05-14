package com.example.demo.services;

import com.example.demo.model.Response;

public interface AutenticacionService {

	Response capturarJWT(String user, String password, String contentType);

}
