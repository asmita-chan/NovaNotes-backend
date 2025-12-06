package dev.novanotes.backend.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.novanotes.backend.bean.StatusBean;
import dev.novanotes.backend.entity.Notes;
import dev.novanotes.backend.service.HomeService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
	@GetMapping("/")
	public StatusBean home() {
		return new StatusBean(String.valueOf(HttpServletResponse.SC_OK), "Welcome to Novanotes", null);
	}
	
	@PostMapping("/addNote")
	public @ResponseBody Notes addNote(@RequestBody Notes note) {
		Notes addedNote = homeService.addNote(note);
		return addedNote;
	}
	
	@PostMapping("/deleteNote")
	public @ResponseBody StatusBean deleteNote(@RequestBody Notes note) {
		String status = homeService.deleteNote(note.getNotesId());
		if("DELETED".equals(status)) return new StatusBean(String.valueOf(HttpServletResponse.SC_OK), "DELETED", null);
		return new StatusBean(String.valueOf(HttpServletResponse.SC_NOT_MODIFIED), "Not Found", null);
	}
	
	@PostMapping("/updateNote")
	public @ResponseBody Notes updateNote(@RequestBody Notes note) {
		Notes foundNote = homeService.updateNote(note);
		if(foundNote == null) throw new RuntimeException("Note not Found");
		return foundNote;
	}
	
	@PostMapping("/getAllNotes")
	public @ResponseBody List<Notes> getAllNotes(@RequestBody Notes note){
		List<Notes> notesList = homeService.getAllNotes(note.getCreatedBy());
		return notesList == null ? Collections.emptyList() : notesList;
	}

}
