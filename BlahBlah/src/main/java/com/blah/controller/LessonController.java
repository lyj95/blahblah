package com.blah.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.LessonService;
import com.blah.vo.LessonVo;
import com.blah.vo.ReviewVo;



@Controller
public class LessonController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LessonService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/courseList")
	public ModelAndView list() { 
		logger.info("[course]Select List"); //log에 info 찍어주는 것
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.selectList());
		return mav; //강의 전체목록 조회
	}
	
	@RequestMapping(value = "/SearchKeywordCourse")
	public ModelAndView searchKeyword(@RequestParam(defaultValue="") String keyword) {  
		logger.info("[course]Search List"); 
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchKeyword(keyword));
		
		return mav; //강의 검색된 목록 조회
	}
	
	@RequestMapping(value = "/courseTypeLICENSE")
	public ModelAndView searchLICENSE() {  
		logger.info("[course]Search courseType LICENSE"); 
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchLICENSE());
		
		return mav; //강의 검색된 목록 조회
	}
	
	@RequestMapping(value = "/courseTypeSPEAKING")
	public ModelAndView searchSPEAKING() {  
		logger.info("[course]Search courseType SPEAKING"); 
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchSPEAKING());
		
		return mav; //강의 검색된 목록 조회
	}
	
	@RequestMapping(value = "/searchHighLevel")
	public ModelAndView searchHighLevel() {  
		logger.info("[course]Search courseType SPEAKING"); 
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchHighLevel());
		mav.addObject("btn", "LICENSEbtn");
		
		return mav; //강의 검색된 목록 조회
	}
	
	@RequestMapping(value = "/searchMidLevel")
	public ModelAndView searchMidLevel() { 
		logger.info("[course]Search courseType SPEAKING"); 
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchMidLevel());
		
		return mav; //강의 검색된 목록 조회
	}
	
	@RequestMapping(value = "/searchLowLevel")
	public ModelAndView searchLowLevel() { 
		logger.info("[course]Search courseType SPEAKING"); 
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchLowLevel());
		
		return mav; //강의 검색된 목록 조회
	}
	
	@RequestMapping(value = "/courseDetail")
	public ModelAndView detail(Model model, int lessonNo) {
		logger.info("[course]Select One"); //log에 info 찍어주는 것
		ModelAndView mav = new ModelAndView("lesson/courseDetail");
		mav.addObject("vo", service.selectOne(lessonNo));
		
		return mav; //강의 디테일로
	}
	
	@RequestMapping(value = "/insertCourseForm")
	public String insertForm() {
		logger.info("[course]insertFrom"); //log에 info 찍어주는 것
		return "lesson/courseWriting"; //강의글 작성화면으로 
	}
	
	@RequestMapping(value="/insertCourseRes")
	public String insert(LessonVo vo) {
		logger.info("[course]insert RES"); //log에 info 찍어주는 것
		int res = service.insert(vo); 
		if(res>0) {
			logger.info("[course]insert success");
			return "redirect:courseList";
		}else {
			logger.info("[course]insert fail....");
			return "redirect:insertCourseForm";
		}
	}
	@RequestMapping(value="/updateCourseForm")
	public String updateForm(Model model, int lessonNo) {
		logger.info("[course]updateForm");	
		model.addAttribute("vo", service.selectOne(lessonNo));
			
		return "lesson/courseUpdate";
	}
	
	@RequestMapping(value="/updateCourseRes")
    public String updateRes(Model model, LessonVo vo) {
        
		logger.info("[course]update Result");	
		int res = service.update(vo); 
        if (res > 0) {
            model.addAttribute("vo", service.selectOne(vo.getLessonNo()));
            logger.info("update success");
			return "redirect:courseDetail?lessonNo="+vo.getLessonNo();
        } else {
        	logger.info("update fail....");
			return "redirect:courseUpdateForm?lessonNo="+vo.getLessonNo();
        }
    }
	
	
	@RequestMapping(value="deleteCourse")
	public String delete(int lessonNo) {
		logger.info("[course]delete");	
		int res = service.delete(lessonNo);
		if(res>0) {
			logger.info("delete success");
			return "redirect:courseList";
		}else {
			logger.info("delete fail....");
			return "redirect:courseDetail?lessonNo="+lessonNo;
		}
	}

	@RequestMapping(value="addReview")  
	@ResponseBody
	public Map<String,Boolean> addReview(ReviewVo vo) throws Exception {
		// 댓글 등록 ajax
		logger.info("[course]addReview");

		int res = service.addReview(vo);
		boolean check = false;
		
		if (res > 0) {
			logger.info("addReview success");
			check = true;
			
		} else {
			logger.info("addReview fail....");
			
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		return map;	

	}	
	
	 @RequestMapping(value="/reviewList")
	 @ResponseBody
	 public Map<String,List<ReviewVo>> reviewList(@RequestParam int lessonNo) {
		logger.info("[course]Select List"); // log에 info 찍어주는 것
		
		Map<String,List<ReviewVo>> map = new HashMap<String,List<ReviewVo>>();
		map.put("reviewlist", service.selectReviewList(lessonNo));

		return map;	

	}
}
