package com.blah.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.blah.vo.LessonVo;
import com.blah.vo.PagingVo;
import com.blah.vo.ReviewVo;

public interface LessonDao {
	String namespace ="lesson.";
	List<LessonVo> selectList(PagingVo page);
	LessonVo selectOne(int lessonNo);
	int insert(LessonVo vo);
	int getLastLessonSeq();
	public int update(LessonVo vo);
	public int delete(int lessonNo);
	List<LessonVo> searchKeyword(String keyword);
	List<LessonVo> searchLICENSE();
	List<LessonVo> searchSPEAKING();
	List<LessonVo> searchHighLevel();
	List<LessonVo> searchMidLevel();
	List<LessonVo> searchLowLevel();
	int addReview(ReviewVo vo);
	List<ReviewVo> selectReviewList(int lessonNo);
	int listCount();
	Double getReviewAvg(int lessonNo);
	List<LessonVo> orderByRiview(PagingVo page);
	int listReviewCount();
	int deleteReview(int reviewNo);

	

}

