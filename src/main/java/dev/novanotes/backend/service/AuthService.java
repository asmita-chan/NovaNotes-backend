package dev.novanotes.backend.service;

import dev.novanotes.backend.bean.LoginResponse;
import dev.novanotes.backend.entity.Users;

public interface AuthService {
	LoginResponse login(String username, String password);
	LoginResponse register(Users user);
} 
