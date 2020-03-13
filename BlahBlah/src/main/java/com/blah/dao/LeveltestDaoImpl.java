package com.blah.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		}catch(Exception e) {
			System.out.println("[error] : insert ");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public LeveltestVo selectLevel(String memberId) {
		LeveltestVo res = new LeveltestVo();
		
		System.out.println("into dao : " + res);
		
		try {
			res= sqlSession.selectOne(NAMESPACE + "selectLevel", memberId);
		}catch(Exception e) {
			System.out.println("[error] : selectLevel ");
			e.printStackTrace();
		}
		
		return res;
	}
	


}
