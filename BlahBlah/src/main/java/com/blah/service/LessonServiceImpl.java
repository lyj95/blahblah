package com.blah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.LessonDao;
import com.blah.vo.LessonVo;
import com.blah.vo.ReviewVo;

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

	@Override
	public List<LessonVo> searchKeyword(String keyword) {
		// TODO 키워드로 검색한 목록 
 		return dao.searchKeyword(keyword);
	}

	@Override
	public List<LessonVo> searchLICENSE() {
		// TODO 강의타입이 라이센스인 글 목록
		return dao.searchLICENSE();
	}

	@Override
	public List<LessonVo> searchSPEAKING() {
		// TODO 강의 타입이 스피킹인 목록
		return dao.searchSPEAKING();
	}

	@Override
	public List<LessonVo> searchHighLevel() {
		// TODO 강의레발 상 목록 조회
		return dao.searchHighLevel();
	}

	@Override
	public List<LessonVo> searchMidLevel() {
		// TODO 강의레발 중 목록 조회
		return dao.searchMidLevel();
	}

	@Override
	public List<LessonVo> searchLowLevel() {
		// TODO 강의레발 하 목록 조회
		return dao.searchLowLevel();
	}

	@Override
	public int addReview(ReviewVo vo) {
		// TODO 리뷰작성
		return dao.addReview(vo);
	}

	@Override
	public List<ReviewVo> selectReviewList(int lessonNo) {
		// TODO 리뷰조회
		return dao.selectReviewList(lessonNo);
	}

}
