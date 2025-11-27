package dev.novanotes.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.novanotes.backend.dao.HomeDao;
import dev.novanotes.backend.entity.Notes;
import dev.novanotes.backend.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	HomeDao homeDao;
	
	@Override
	public Notes addNote(Notes notes) {
		homeDao.save(notes);
		return notes;
	}

	@Override
	public String deleteNote(Long id) {
		String status = homeDao.deleteById(id);
		return status;
	}

	@Override
	public Notes updateNote(Notes note) {
		Notes foundNote = homeDao.findById(note.getNotesId());
		if(foundNote != null) {
			if(note.getTitle() != null && !note.getTitle().isEmpty()) foundNote.setTitle(note.getTitle());
			if(note.getContent() != null && !note.getContent().isEmpty()) foundNote.setContent(note.getContent());
			if(note.getIsDone() != null) foundNote.setIsDone(note.getIsDone());
			homeDao.save(foundNote);
			return foundNote;
		}
		return null;
	}

	@Override
	public List<Notes> getAllNotes(Long userId) {
		return homeDao.getAllNotes(userId);
	}

}
