package com.blah.dao;

import java.util.List;
import java.util.Map;

import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;
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
	List<LessonVo> selectPopularLesson();
	List<LessonVo> searchKeyword(String keyword);
	List<LessonVo> searchLICENSE();
	List<LessonVo> searchSPEAKING();
	List<LessonVo> searchHighLevel();
	List<LessonVo> searchMidLevel();
	List<LessonVo> searchLowLevel();
	int addReview(ReviewVo vo);
	List<ReviewVo> selectReviewList(String tutorId);
	List<ReviewVo> selectLatestReview();
	int listCount();
	Double getReviewAvg(String tutorId);
	List<LessonVo> orderByRiview(PagingVo page);
	int listReviewCount();
	int deleteReview(int reviewNo);
	
	String chkFav(Map<String, String> fav);
	int deleteFav(Map<String, String> fav);
	int insertFav(Map<String, String> fav);
	List<Map<String, String>> selectFavCount();
	int updateProfile(MemberVo fileobj);
	

}

