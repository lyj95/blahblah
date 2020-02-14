package com.blah.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.LessonVo;

@Repository
public class LessonDaoImpl implements LessonDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insert(LessonVo vo) {
		System.out.println(vo);
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
			for(LessonVo vo : list) {
				System.out.println("list:"+vo);
			}
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
			System.out.println("lessonVo : "+lessonNo);
			System.out.println("dao vo : "+vo);
			
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
	

}
