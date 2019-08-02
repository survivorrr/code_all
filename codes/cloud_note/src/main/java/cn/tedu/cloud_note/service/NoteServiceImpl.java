package cn.tedu.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;
@Service("noteService")
public class NoteServiceImpl implements NoteService{
	@Resource NoteDao noteDao;
	
	public NoteResult<List<Map>> loadBookNotes(String bookId){
		List<Map> list = noteDao.findByBookId(bookId);
		NoteResult<List<Map>> result = new NoteResult<List<Map>>();   //�����Map����д��Map<String,Object>
		result.setStatus(0);
		result.setMsg("���رʼǳɹ�");
		result.setData(list);
		return result;
	}
	
	public NoteResult<Note> loadNote(String noteId){
		Note note = noteDao.findByNoteId(noteId);
		NoteResult<Note> result = new NoteResult<Note>();
		if(note==null) {
			result.setStatus(1);
			result.setMsg("δ�ҵ�����");
			return result;
		}else {
			result.setStatus(0);
			result.setMsg("��ѯ�ɹ�");
			result.setData(note);
		}
		return result;
	}
	
	public NoteResult<Object> updateNote(String noteId,String noteTitle,String noteBody){
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		Long time = System.currentTimeMillis();
		note.setCn_note_last_modify_time(time);
		int rows = noteDao.updateNote(note);
		NoteResult<Object> result = new NoteResult<Object>();
		if(rows==1) {
			result.setStatus(0);
			result.setMsg("����ʼǳɹ�");
		}else {
			result.setStatus(1);
			result.setMsg("����ʼ�ʧ��");
		}
		return result;
	}
	
	public NoteResult<Note> addNote(String userId,String title,String bookId){
		NoteResult<Note> result = new NoteResult<Note>();
		Note note = new Note();
		note.setCn_user_id(userId);
		note.setCn_notebook_id(bookId);
		note.setCn_note_title(title);
		note.setCn_note_id(NoteUtil.createId());
		note.setCn_note_body("");
		Long time = System.currentTimeMillis();
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		note.setCn_note_status_id("1"); //״̬ ��1--normal  2--delete
		note.setCn_note_type_id("1"); //���ͣ�1--normal 2--favor   3--share
		noteDao.addNote(note);
		result.setStatus(0);
		result.setMsg("�ʼǴ����ɹ�");
		result.setData(note);
		return result;
	}
	
	public NoteResult<Object> deleteNote(String noteId){
		NoteResult<Object> result = new NoteResult<Object>();
		noteDao.deleteNote(noteId);
		result.setStatus(0);
		result.setMsg("�ʼ�ɾ���ɹ�");
		return result;
	}
	
	@Transactional
	public void deleteNotes(String... ids) {
		//String... ����String[]
		for(String id:ids) {
			int n=noteDao.deleteNoteTestTrans(id);
			if(n!=1) {
				//�׳��쳣����������Ļع�
				throw new RuntimeException("ɾ����");
			}
		}
	}
}
