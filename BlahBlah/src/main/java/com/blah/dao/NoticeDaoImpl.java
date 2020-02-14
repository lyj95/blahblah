package com.blah.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.NoticeVo;

@Repository
public class NoticeDaoImpl implements NoticeDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<NoticeVo> selectList() {
		
		List<NoticeVo> res = new ArrayList<NoticeVo>();
		
		try {
			res = sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			System.out.println("[error] : notice selectList");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public NoticeVo selectOne(int noticeNo) {
		
		NoticeVo res = new NoticeVo();
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectOne", noticeNo);		
		} catch (Exception e) {
			System.out.println("[error] : notice detail");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insert(NoticeVo vo) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert", vo);			
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(NoticeVo vo) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"update", vo);
		} catch (Exception e) {
			System.out.println("[error] : update");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int noticeNo) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"delete", noticeNo);
		} catch (Exception e) {
			System.out.println("[error] : delete");
			e.printStackTrace();
		}
		
		return res;
	}

}
