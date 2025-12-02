package dev.novanotes.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.novanotes.backend.bean.LoginResponse;
import dev.novanotes.backend.dao.UserRolesDao;
import dev.novanotes.backend.dao.UsersDao;
import dev.novanotes.backend.entity.UserRoleKey;
import dev.novanotes.backend.entity.UserRoles;
import dev.novanotes.backend.entity.Users;
import dev.novanotes.backend.security.CustomUserDetails;
import dev.novanotes.backend.security.CustomUserDetailsService;
import dev.novanotes.backend.security.JwtUtil;
import dev.novanotes.backend.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	UserRolesDao userRolesDao;
	
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private final CustomUserDetailsService customUserDetailsService;
	
	public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, CustomUserDetailsService customUserDetailsService) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
		this.passwordEncoder = passwordEncoder;
		this.customUserDetailsService = customUserDetailsService;
	}

	@Override
	public LoginResponse login(String username, String password) {
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		System.out.println("auth ------>" + auth);
		CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
		LoginResponse response = new LoginResponse();
		response.setToken(jwtUtil.generateToken(userDetails));
		response.setUserId(userDetails.getUser().getUserId());
		return response;
	}

	@Override
	public LoginResponse register(Users user) {
		Users existingUser = usersDao.findByLoginId(user.getLoginId());
		if(existingUser != null) {
			throw new RuntimeException("Username already taken");
		}
		user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));
		Users savedUser = usersDao.save(user);
		
		UserRoleKey key = new UserRoleKey();
		key.setUserId(savedUser.getUserId());
		key.setRoleId(2L);
		
		UserRoles userRoles = new UserRoles();
		userRoles.setActiveFlag(true);
		userRoles.setCreatedBy(1L);
		userRoles.setId(key);
		userRolesDao.save(userRoles);
		
		CustomUserDetails userDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername(savedUser.getLoginId());
		LoginResponse response = new LoginResponse();
		response.setToken(jwtUtil.generateToken(userDetails));
		response.setUserId(savedUser.getUserId());
		return response;
	}
	
}
