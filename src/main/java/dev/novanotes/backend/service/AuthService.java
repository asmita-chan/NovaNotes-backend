package dev.novanotes.backend.service;

import dev.novanotes.backend.entity.Users;

public interface AuthService {
	String login(String username, String password);
	String register(Users user);
} 
