package test.service;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;
import test.TestBase;

public class TestNoteService extends TestBase{
	private NoteService noteService;
	@Before
	public void init() {
		noteService = super.getContext().getBean("noteService",NoteService.class);
	}
	@Test
	public void testNoteService() {
		NoteResult<List<Map>> result = noteService.loadBookNotes("fa8d3d9d-2de5-4cfe-845f-951041bcc461");
		System.out.println(result.getStatus()+" "+result.getMsg());
	}
	
	
	@Test
	public void testDeleteNotes() {
		//调用动态参数的时候，可以不创建数组，直接写参数
		//String[] ids= {"id1","id2","id3"};
		//noteService.deleteNotes(ids);
		noteService.deleteNotes("3febebb3-a1b7-45ac-83ba-50cdb41e5fc1","id2","id3");
	}

}
