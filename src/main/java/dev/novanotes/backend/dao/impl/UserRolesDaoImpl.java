package dev.novanotes.backend.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import dev.novanotes.backend.dao.UserRolesDao;
import dev.novanotes.backend.entity.UserRoles;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRolesDaoImpl implements UserRolesDao{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public UserRoles save(UserRoles userRoles) {
		entityManager.persist(userRoles);
		return userRoles;
	}
}
