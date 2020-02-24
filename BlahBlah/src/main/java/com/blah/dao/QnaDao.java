package com.blah.dao;

import java.util.HashMap;
import java.util.List;

import com.blah.vo.PagingVo;
import com.blah.vo.QnaVo;
import com.blah.vo.ReplyVo;

public interface QnaDao {
	
	String NAMESPACE = "qna.";

	public List<QnaVo> selectList(PagingVo page);

	public int listCount();

	public String findSysdate();

	public QnaVo selectOne(int qnaNo);

	public int insert(QnaVo vo);

	public int update(QnaVo vo);

	public int delete(int qnaNo);

	public List<QnaVo> searchByTitle(HashMap<String, String> map);

	public List<QnaVo> searchByContent(HashMap<String, String> map);

	public ReplyVo selectReply(int qnaNo);

	public int insertReply(ReplyVo reply);

	public int updateReply(ReplyVo reply);

	public int updateQnaRep(int qnaNo);

}
