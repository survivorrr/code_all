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
	 * map����Ҫ�����������
	 * map={ids:[id1,id2...],status:2}
	 * ids����ɾ���ʼǵ�id�б�
	 *
	 * */
	public int deleteNotes(Map<String,Object> map);//����ɾ��
	
	int deleteNoteTestTrans(String id);//�ӿ�Ĭ��public,����ǰ�治��Ҫдpublic
}
