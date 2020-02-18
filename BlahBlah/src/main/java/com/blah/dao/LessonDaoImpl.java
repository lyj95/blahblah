package com.blah.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.LessonVo;
import com.blah.vo.ReviewVo;

@Repository
public class LessonDaoImpl implements LessonDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insert(LessonVo vo) {
		int res=0;
		try {
			res= sqlSession.insert(namespace+"insert", vo);
		}catch(Exception e) {
			System.out.println("[error] : insert ");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<LessonVo> selectlist() {
		List<LessonVo> list = new ArrayList<LessonVo>();
		try {
			list = sqlSession.selectList(namespace+"selectList");		
		}catch(Exception e) {
			System.out.println("[error] : selectList ");
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public LessonVo selectOne(int lessonNo) {
		LessonVo vo = null;
		try {
			vo = sqlSession.selectOne(namespace+"selectOne", lessonNo);
			
		}catch(Exception e) {
			System.out.println("[error] : selectOne ");
			e.printStackTrace();
		}	
		return vo;
	}
	
	@Override //글 수정
	public int update(LessonVo vo) {
		int res=0;
		try {
			res=sqlSession.update(namespace+"update", vo);
		}catch(Exception e) {
			System.out.println("[error] : update ");
			e.printStackTrace();
		}
		return res;
	}

	@Override //글삭제
	public int delete(int lessonNo) {
		int res=0;
		try {
			res=sqlSession.update(namespace+"delete", lessonNo);
		}catch(Exception e) {
			System.out.println("[error] : delete ");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<LessonVo> searchKeyword(String keyword) {
		List<LessonVo> list = new ArrayList<LessonVo>();
		try {
			list = sqlSession.selectList(namespace+"searchKeyword", keyword);
		}catch(Exception e) {
			System.out.println("[error] : searchKeyword ");
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public List<LessonVo> searchLICENSE() {
		List<LessonVo> list = new ArrayList<LessonVo>();
		try {
			list = sqlSession.selectList(namespace+"searchLICENSE");
		}catch(Exception e) {
			System.out.println("[error] : searchLICENSE");
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public List<LessonVo> searchSPEAKING() {
		List<LessonVo> list = new ArrayList<LessonVo>();
		try {
			list = sqlSession.selectList(namespace+"searchSPEAKING");
		}catch(Exception e) {
			System.out.println("[error] : searchSPEAKING()");
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public List<LessonVo> searchHighLevel() {
		List<LessonVo> list = new ArrayList<LessonVo>();
		try {
			list = sqlSession.selectList(namespace+"searchHighLevel");
		}catch(Exception e) {
			System.out.println("[error] : searchHighLevel");
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public List<LessonVo> searchMidLevel() {
		List<LessonVo> list = new ArrayList<LessonVo>();
		try {
			list = sqlSession.selectList(namespace+"searchMidLevel");
		}catch(Exception e) {
			System.out.println("[error] : searchMidLevel");
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public List<LessonVo> searchLowLevel() {
		List<LessonVo> list = new ArrayList<LessonVo>();
		try {
			list = sqlSession.selectList(namespace+"searchLowLevel");
		}catch(Exception e) {
			System.out.println("[error] : searchLowLevel");
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public int addReview(ReviewVo vo) {
		int res=0;
		System.out.println(vo);
		try {
			res= sqlSession.insert(namespace+"addReview", vo);
		}catch(Exception e) {
			System.out.println("[error] : addReview ");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<ReviewVo> selectReviewList(int lessonNo) {

		List<ReviewVo> list = new ArrayList<ReviewVo>();
		try {
			list = sqlSession.selectList(namespace+"selectReviewList",lessonNo);	
			
		}catch(Exception e) {
			System.out.println("[error] : selectReviewList ");
			e.printStackTrace();
		}	
		return list;
	}
}
