package dev.novanotes.backend.service;

import java.util.List;

import dev.novanotes.backend.entity.Notes;

public interface HomeService {
	Notes addNote(Notes notes);
	String deleteNote(Long id);
	Notes updateNote(Notes notes);
	List<Notes> getAllNotes(Long userId);
}
