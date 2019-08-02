package cn.tedu.cloud_note.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.cloud_note.entity.Note;

public interface NoteDao {
	public List<Map> findByBookId(String bookId);
	public Note findByNoteId(String noteId);
	public int updateNote(Note note);
	public int updateNoteByMap(Map<String,Object> map);
	public void addNote(Note note);
	public void deleteNote(String noteId);
	/*
	 * map中需要添加两个参数
	 * map={ids:[id1,id2...],status:2}
	 * ids代表删掉笔记的id列表
	 *
	 * */
	public int deleteNotes(Map<String,Object> map);//批量删除
	
	int deleteNoteTestTrans(String id);//接口默认public,所以前面不需要写public
}
