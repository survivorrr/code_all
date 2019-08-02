package test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloud_note.dao.NoteDao;
import test.TestBase;

public class TestNoteDao extends TestBase{
	private NoteDao noteDao;
	@Before
	public void init() {
		noteDao = super.getContext().getBean("noteDao",NoteDao.class);
	}
	@Test
	public void testNoteDao() {
		List<Map> list = noteDao.findByBookId("fa8d3d9d-2de5-4cfe-845f-951041bcc461");
		for(Map note:list) {
			System.out.println(note.get("cn_note_id")+" "+note.get("cn_note_title"));
		}
	}
	
	
	@Test
	public void testUpdateNoteByMap() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("title", "java");
		map.put("noteId","8d3763b2-8e01-48d4-a338-730b02ded9c9");
		map.put("body", "helloWorld");
		//故意省略参数body和time
		noteDao.updateNoteByMap(map);
	}
	
	@Test
	public void testDeleteNotes() {
		Map<String,Object> map=new HashMap<String,Object>();
		String[] ids= {"id1","id2","id3"};
		map.put("ids", ids);
		map.put("status", 2);
		int n = noteDao.deleteNotes(map);
		System.out.println(n);
		//这个是做一个测试，把sql语句打印出来看看是否是意想的样子
	}
}
