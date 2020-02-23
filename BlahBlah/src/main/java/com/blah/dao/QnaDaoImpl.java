package com.blah.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.PagingVo;
import com.blah.vo.QnaVo;
import com.blah.vo.ReplyVo;

@Repository
public class QnaDaoImpl implements QnaDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<QnaVo> selectList(PagingVo page) {
		
		List<QnaVo> res = new ArrayList<QnaVo>();
		
		try {
			res = sqlSession.selectList(NAMESPACE+"selectList", page);
		} catch (Exception e) {
			System.out.println("[error] : qna selectList");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int listCount() {
		
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"listCount");
		} catch (Exception e) {
			System.out.println("[error] : qna list count");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public String findSysdate() {
		
		String res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"findSysdate");
		} catch (Exception e) {
			System.out.println("[error] : find sysdate");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public QnaVo selectOne(int qnaNo) {
		
		QnaVo res = new QnaVo();
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectOne", qnaNo);		
		} catch (Exception e) {
			System.out.println("[error] : qna detail");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insert(QnaVo vo) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert", vo);			
		} catch (Exception e) {
			System.out.println("[error] : insert qna");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(QnaVo vo) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"update", vo);
		} catch (Exception e) {
			System.out.println("[error] : update qna");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int qnaNo) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"delete", qnaNo);
		} catch (Exception e) {
			System.out.println("[error] : delete qna");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<QnaVo> searchByTitle(HashMap<String, String> map) {
		
		List<QnaVo> res = new ArrayList<QnaVo>();
		
		try {
			res = sqlSession.selectList(NAMESPACE+"searchByTitle", map);
		} catch (Exception e) {
			System.out.println("[error] : qna searchByTitle");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<QnaVo> searchByContent(HashMap<String, String> map) {
				
		List<QnaVo> res = new ArrayList<QnaVo>();
		
		try {
			res = sqlSession.selectList(NAMESPACE+"searchByContent", map);
		} catch (Exception e) {
			System.out.println("[error] : qna searchByContent");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public ReplyVo selectReply(int qnaNo) {
		
		ReplyVo res = new ReplyVo();
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectReply", qnaNo);
		} catch (Exception e) {
			System.out.println("[error] : reply detail");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insertReply(ReplyVo reply) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insertReply", reply);			
		} catch (Exception e) {
			System.out.println("[error] : insert qna reply");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int updateReply(ReplyVo reply) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"updateReply", reply);
		} catch (Exception e) {
			System.out.println("[error] : update qna reply");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int updateQnaRep(int qnaNo) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"updateQnaRep", qnaNo);
		} catch (Exception e) {
			System.out.println("[error] : update qna_rep");
			e.printStackTrace();
		}
		
		return res;
	}
}
