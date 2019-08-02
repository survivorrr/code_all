package cn.tedu.cloud_note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.dao.ShareDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.entity.Share;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;
@Service("ShareService")
public class ShareServiceImpl implements ShareService{
	@Resource NoteDao noteDao;
	@Resource ShareDao shareDao;
	
	@Transactional
	public NoteResult<Object> shareNote(String noteId) {
		//向cn_share表中插记录
		Share share = new Share();
		String shareId = NoteUtil.createId();
		share.setCn_share_id(shareId);
		share.setCn_note_id(noteId);
		Note note = noteDao.findByNoteId(noteId);
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		//保存分享记录
		shareDao.save(share);
		//模拟异常..................模拟异常.....................模拟异常..................
		String str = null;
		str.length();
		//返回result
		NoteResult<Object> result = new NoteResult<Object>();
		result.setStatus(0);
		result.setMsg("分享笔记成功");
		result.setData(share);
		return result;
	}
	
	public NoteResult<List<Share>> searchNote(String keyword,int page){
		String title="%"+keyword+"%";
		int begin = (page-1)*3;//每页3条，计算抓取记录的起点
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("title", title);
		params.put("begin", begin);
		List<Share> list = shareDao.findLikeTitle(params);
		NoteResult<List<Share>> result = new NoteResult<List<Share>>();
		result.setStatus(0);
		result.setMsg("获取成功");
		result.setData(list);
		return result;
	}
}
