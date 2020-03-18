package com.blah.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.blah.vo.LessonVo;
import com.blah.vo.PagingVo;
import com.blah.vo.ReviewVo;

public interface LessonService {
	List<LessonVo> selectList(PagingVo page);
	LessonVo selectOne(int lessonNo);
	int insert(Model model, LessonVo vo, HttpServletRequest request, MultipartFile file);
	int update(LessonVo vo);
	int delete(int lessonNo);
	List<LessonVo> searchKeyword(String keyword);
	List<LessonVo> searchLICENSE();
	List<LessonVo> searchSPEAKING();
	List<LessonVo> searchHighLevel();
	List<LessonVo> searchMidLevel();
	List<LessonVo> searchLowLevel();
	int addReview(ReviewVo vo);
	List<ReviewVo> selectReviewList(String tutorId);
	int listCount();
	Double getReviewAvg(String tutorId);
	List<LessonVo> orderByRiview(PagingVo page);
	int listReviewCount();
	int deleteReview(int reviewNo);
	List<ReviewVo> selectLatestReview();
	List<LessonVo> selectPopularLesson();

	String chkFav(Map<String, String> fav);
	int deleteFav(Map<String, String> fav);
	int insertFav(Map<String, String> fav);
	List<Map<String, String>> selectFavCount();
	int chkReview(int lessonNo);

	

}

