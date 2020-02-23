package com.blah.service;

import java.util.List;

import com.blah.vo.PagingVo;
import com.blah.vo.QnaVo;
import com.blah.vo.ReplyVo;

public interface QnaService {

	public List<QnaVo> selectList(PagingVo page);
	
	public int listCount();

	public String findSysdate();

	public QnaVo selectOne(int qnaNo);
	
	public int insert(QnaVo vo, String memberId);
	
	public int update(QnaVo vo);
	
	public int delete(int qnaNo);
	
	public List<QnaVo> searchByTitle(String searchContent, PagingVo page);
	
	public List<QnaVo> searchByContent(String searchContent, PagingVo page);

	public ReplyVo selectReply(int qnaNo);

	public int insertReply(ReplyVo reply);

	public int updateReply(ReplyVo reply);

	public int updateQnaRep(int qnaNo);

}
