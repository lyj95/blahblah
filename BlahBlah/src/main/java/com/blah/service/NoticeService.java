package com.blah.service;

import java.util.List;

import com.blah.vo.NoticeVo;
import com.blah.vo.PagingVo;

public interface NoticeService {
	
	public List<NoticeVo> selectList(PagingVo page);
	
	public List<NoticeVo> selectListOrderByNoticeView(PagingVo page);
	
	public int listCount();
	
	public NoticeVo selectOne(int noticeNo);
	
	public int insert(NoticeVo vo);
	
	public int update(NoticeVo vo);
	
	public int delete(int noticeNo);
	
	public int updateNoticeView(int noticeNo);
	
	public int selectCurrentNoticeView(int noticeNo);
	
	public int decreaseNoticeView(int noticeNo);

	public List<NoticeVo> searchByTitle(String searchContent, PagingVo page);
	
	public List<NoticeVo> searchByContent(String searchContent, PagingVo page);

	public String findSysdate();

	public NoticeVo selectPrePost(int noticeNo);

	public NoticeVo selectNextPost(int noticeNo);


}
