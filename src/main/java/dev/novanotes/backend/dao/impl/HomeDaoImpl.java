package dev.novanotes.backend.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.novanotes.backend.dao.HomeDao;
import dev.novanotes.backend.entity.Notes;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HomeDaoImpl implements HomeDao {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public String deleteById(Long id) {
		Notes note = entityManager.find(Notes.class, id);
		if(note == null) return "Not Found";
		entityManager.remove(note);
		return "DELETED";
	}

	@Override
	public Notes findById(Long id) {
		return entityManager.find(Notes.class, id);
	}

	@Override
	public Notes save(Notes note) {
		entityManager.persist(note);
		return note;
	}

	@Override
	public List<Notes> getAllNotes(Long userId) {
		String jpql = "SELECT u FROM Notes u WHERE u.createdBy = :createdBy";
		List<Notes> notes = entityManager.createQuery(jpql, Notes.class).setParameter("createdBy", userId).getResultList();
		return notes;
	}
}
