package cn.tedu.cloud_note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.BookDao;
import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Service("bookService")  //让spring把它管理起来
public class BookServiceImpl implements BookService{
	@Resource BookDao bookDao;
	
	public NoteResult<List<Book>> loadUserBooks(String userId){
		List<Book> list = bookDao.findByUserId(userId);
		NoteResult<List<Book>> result = new NoteResult<List<Book>>();
		result.setStatus(0);
		result.setMsg("查询笔记本成功");
		result.setData(list);
		return result;
	}
	
	public NoteResult<Object> addNoteBook(String userId,String name){
		NoteResult<Object> result = new NoteResult<Object>();
		Book book = new Book();
		book.setCn_user_id(userId);
		book.setCn_notebook_name(name);
		book.setCn_notebook_id(NoteUtil.createId());
		Timestamp time = new Timestamp(System.currentTimeMillis());
		book.setCn_notebook_createtime(time.toString());
		bookDao.addNoteBook(book);
		result.setStatus(0);
		result.setMsg("新建笔记成功");
		result.setData(book);
		return result;
	}
}
