package cn.tedu.cloud_note.service;

import java.util.List;

import cn.tedu.cloud_note.entity.Share;
import cn.tedu.cloud_note.util.NoteResult;

public interface ShareService {
	public NoteResult<Object> shareNote(String noteId);
	public NoteResult<List<Share>> searchNote(String keyword,int page);
}
