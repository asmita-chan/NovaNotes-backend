package dev.novanotes.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.novanotes.backend.bean.LoginRequest;
import dev.novanotes.backend.bean.StatusBean;
import dev.novanotes.backend.entity.Users;
import dev.novanotes.backend.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/login")
	public @ResponseBody StatusBean login(@RequestBody LoginRequest req) {
		System.out.println("entered ------>");
        String token = authService.login(req.getUsername(), req.getPassword());
        return new StatusBean(String.valueOf(HttpServletResponse.SC_OK), "SUCCESS", token);
    }
	
	@PostMapping("/register")
	public @ResponseBody StatusBean register(@RequestBody Users user) {
		String token = authService.register(user);
		return new StatusBean(String.valueOf(HttpServletResponse.SC_OK), "REGISTERED", token);
	}
}
