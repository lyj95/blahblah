package com.blah.service;

import java.util.List;

import com.blah.vo.NoticeVo;

public interface NoticeService {
	
	public List<NoticeVo> selectList();
	
	public NoticeVo selectOne(int noticeNo);
	
	public int insert(NoticeVo vo);
	
	public int update(NoticeVo vo);
	
	public int delete(int noticeNo);

}
