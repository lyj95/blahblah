package com.blah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.LessonDao;
import com.blah.vo.LessonVo;

@Service
public class LessonServiceImpl implements LessonService {
	
	@Autowired
	private LessonDao dao;
	
	/**강의를 추가하는 메소드
	 *@param LessonVo vo
	 *@return 
	 * @author YUNA
	 */
	@Override
	public int insert(LessonVo vo) {
		// TODO insert 기능
		return dao.insert(vo);
	}
	
	@Override
	public List<LessonVo> selectList() {
		// TODO 전체목록 조회
		return dao.selectlist();
	}
	@Override
	public LessonVo selectOne(int lessonNo) {
		// TODO 상세페이지
		return dao.selectOne(lessonNo);
	}

	@Override
	public int update(LessonVo vo) {
		// TODO Auto-generated method stub
		return dao.update(vo);
	}

	@Override
	public int delete(int lessonNo) {
		// TODO Auto-generated method stub
		return dao.delete(lessonNo);
	}

}
