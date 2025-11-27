package dev.novanotes.backend.dao;

import java.util.List;

import dev.novanotes.backend.entity.Notes;

public interface HomeDao {
	String deleteById(Long id);
	Notes findById(Long id);
	Notes save(Notes note);
	List<Notes> getAllNotes(Long userId);
}
