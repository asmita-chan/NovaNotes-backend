package dev.novanotes.backend.dao;

import java.util.List;

import dev.novanotes.backend.entity.Users;

public interface UsersDao {
	Users save(Users user);
	Users update(Users user);
	void delete(Long userId);
	Users findById(Long id);
	List<Users> findAll();
	Users findByEmail(String email);
	Users findByMobile(String mobile);
	Users findByLoginId(String loginId);
}
