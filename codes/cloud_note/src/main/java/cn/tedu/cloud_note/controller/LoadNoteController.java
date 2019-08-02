package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadNoteController {
	@Resource NoteService noteService;
	
	@RequestMapping("/loadNote.do")
	@ResponseBody
	public NoteResult<Note> execute(String noteId){
		NoteResult<Note> result = noteService.loadNote(noteId);
		return result;
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	public NoteResult<Object> execute(String noteId,String noteTitle,String noteBody){
		NoteResult<Object> result = noteService.updateNote(noteId, noteTitle, noteBody);
		return result;
	}
}
