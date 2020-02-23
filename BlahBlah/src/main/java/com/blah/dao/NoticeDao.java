package com.blah.dao;

import java.util.HashMap;
import java.util.List;

import com.blah.vo.NoticeVo;
import com.blah.vo.PagingVo;

public interface NoticeDao {
	
	String NAMESPACE = "notice.";
	
	public List<NoticeVo> selectList(PagingVo page);

	public List<NoticeVo> selectListOrderByNoticeView(PagingVo page);
	
	public int listCount();
	
	public NoticeVo selectOne(int noticeNo);
	
	public int insert(NoticeVo vo);
	
	public int update(NoticeVo vo);
	
	public int delete(int noticeNo);

	public int updateNoticeView(HashMap<String, Integer> map);
	
	public int selectCurrentNoticeView(int noticeNo);

	public List<NoticeVo> searchByTitle(HashMap<String, String> map);

	public List<NoticeVo> searchByContent(HashMap<String, String> map);

	public String findSysdate();

	public NoticeVo selectPrePost(int noticeNo);

	public NoticeVo selectNextPost(int noticeNo);

}
