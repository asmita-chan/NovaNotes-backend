package dev.novanotes.backend.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dev.novanotes.backend.dao.UsersDao;
import dev.novanotes.backend.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Users save(Users user) {
		entityManager.persist(user);
		return user;
	}
	
	@Override
	public Users update(Users user) {
		return entityManager.merge(user);
	}

	@Override
	public void delete(Long userId) {
		Users user = entityManager.find(Users.class, userId);
		if (user != null) {
			entityManager.remove(user);
		}
	}

	@Override
	public Users findById(Long id) {
		return entityManager.find(Users.class, id);
	}

	@Override
	public List<Users> findAll() {
		String jpql = "SELECT u from Users u";
		return entityManager.createQuery(jpql, Users.class).getResultList();
	}

	@Override
	public Users findByEmail(String email) {
		String jpql = "SELECT u FROM Users u WHERE u.email = :email";
		List<Users> users = entityManager.createQuery(jpql, Users.class).setParameter("email", email).getResultList();
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Users findByMobile(String mobile) {
		String jpql = "SELECT u FROM Users u WHERE u.mobile = :mobile";
		List<Users> users = entityManager.createQuery(jpql, Users.class).setParameter("mobile", mobile).getResultList();
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Users findByLoginId(String loginId) {
		String jpql = "SELECT u FROM Users u WHERE u.loginId = :loginId";
		List<Users> users = entityManager.createQuery(jpql, Users.class).setParameter("loginId", loginId).getResultList();
		return users.isEmpty() ? null : users.get(0);
	}

}
