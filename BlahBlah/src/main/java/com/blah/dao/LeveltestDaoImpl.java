package com.blah.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.LessonVo;
import com.blah.vo.LeveltestVo;

@Repository
public class LeveltestDaoImpl implements LeveltestDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insert(LeveltestVo vo) {
		int res=0;
		try {
			res= sqlSession.insert(NAMESPACE + "insert", vo);
			System.out.println("into dao ..." + vo);
		}catch(Exception e) {
			System.out.println("[error] : insert ");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public LeveltestVo selectLevel(String memberId) {
		LeveltestVo res = new LeveltestVo();
		
		try {
			res= sqlSession.selectOne(NAMESPACE + "selectLevel", memberId);
			System.out.println(res);
		}catch(Exception e) {
			System.out.println("[error] : selectLevel ");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<LessonVo> selectList(String memberLevel) {
		
		List<LessonVo> list = new ArrayList<LessonVo>();
		try {			
			list = sqlSession.selectList(NAMESPACE+"selectList", memberLevel);		
		}catch(Exception e) {
			System.out.println("[error] : Leveltest selectList ");
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public int selectCount(String memberId) {
			
		int res = 0;
		System.out.println("아이디 : " + memberId);
		
		try{
			res = sqlSession.selectOne(NAMESPACE + "selectCount", memberId);
			System.out.println("res !!!!!!!!!!!!!! : "+res);
		}catch(Exception e) {
			System.out.println("[error] : Leveltest selectCount ");
			e.printStackTrace();
		}
		return res;
	}


}
