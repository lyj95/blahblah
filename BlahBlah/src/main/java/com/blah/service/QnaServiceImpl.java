package com.blah.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.QnaDao;
import com.blah.vo.PagingVo;
import com.blah.vo.QnaVo;
import com.blah.vo.ReplyVo;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaDao dao;

	@Override
	public List<QnaVo> selectList(PagingVo page) {
		
		List<QnaVo> res =  dao.selectList(page);
		
		for (int i = 0; i < res.size(); i++) {
			String qnaDate = res.get(i).getQnaDate().substring(0, 10);
			res.get(i).setQnaDate(qnaDate);
		}
        
		return res;
	}

	@Override
	public int listCount() {
		return dao.listCount();
	}

	@Override
	public String findSysdate() {
		return dao.findSysdate();
	}

	@Override
	public QnaVo selectOne(int qnaNo) {
		return dao.selectOne(qnaNo);
	}

	@Override
	public int insert(QnaVo vo, String memberId) {
		
		vo.setMemberId(memberId);
		
		String qnaOpen = vo.getQnaOpen();
		if (qnaOpen==null) {
			vo.setQnaOpen("Y");
			return dao.insert(vo);
		} else {
			return dao.insert(vo);
		}
	}

	@Override
	public int update(QnaVo vo) {
		
		String qnaOpen = vo.getQnaOpen();
		if (qnaOpen==null) {
			vo.setQnaOpen("Y");
			return dao.update(vo);
		} else {
			return dao.update(vo);
		}
	}

	@Override
	public int delete(int qnaNo) {
		return dao.delete(qnaNo);
	}

	@Override
	public List<QnaVo> searchByTitle(String searchContent, PagingVo page) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchContent", searchContent);
		map.put("rowStart", Integer.toString(page.getRowStart()));
		map.put("rowEnd", Integer.toString(page.getRowEnd()));
		
		return dao.searchByTitle(map);
	}

	@Override
	public List<QnaVo> searchByContent(String searchContent, PagingVo page) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchContent", searchContent);
		map.put("rowStart", Integer.toString(page.getRowStart()));
		map.put("rowEnd", Integer.toString(page.getRowEnd()));
		
		return dao.searchByContent(map);
	}

	@Override
	public ReplyVo selectReply(int qnaNo) {
		return dao.selectReply(qnaNo);
	}

	@Override
	public int insertReply(ReplyVo reply) {
		return dao.insertReply(reply);
	}

	@Override
	public int updateReply(ReplyVo reply) {
		return dao.updateReply(reply);
	}

	@Override
	public int updateQnaRep(int qnaNo) {
		return dao.updateQnaRep(qnaNo);
	}

}
