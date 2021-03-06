package com.blah.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.blah.service.LessonService;
import com.blah.service.PaymentService;
import com.blah.service.UserService;
import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;
import com.blah.vo.PageMakerVo;
import com.blah.vo.PagingVo;
import com.blah.vo.ReviewVo;

@Controller
public class LessonController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private LessonService service;
	@Autowired
	private PaymentService pservice;

	@RequestMapping(value = "/courseList")
	public ModelAndView list(PagingVo page, HttpServletRequest request) {
		logger.info("[course]Select List");
		ModelAndView mav = new ModelAndView("lesson/course");

		page.setPerPageNum(6);

		PageMakerVo pageMaker = new PageMakerVo();
		pageMaker.setPageVo(page);
		pageMaker.setDisplayPageNum(6);
		pageMaker.setTotalCount(service.listCount());
		
		mav.addObject("favCountList", service.selectFavCount());
		mav.addObject("list", service.selectList(page));
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("orderby", 1);

		String memberType = (String) request.getSession().getAttribute("memberType");
		mav.addObject("memberType", memberType);

		return mav; // 강의 전체목록 조회
	}

	@RequestMapping(value = "/courseDetail")
	public ModelAndView detail(Model model, int lessonNo, HttpServletRequest request) {
		logger.info("[course]Select One");
		ModelAndView mav = new ModelAndView("lesson/courseDetail");

		// 찜 추가
		MemberVo vo = (MemberVo) request.getSession().getAttribute("login");
		Map<String, String> fav = new HashMap<String, String>();
		fav.put("memberId", vo.getMemberId());
		fav.put("lessonNo", lessonNo + "");

		//수강신청된 강의인지 확인
		int endLesson = pservice.chkLessonEnd(lessonNo);
		System.out.println("controller endLesson: "+endLesson);
		//해당 강의와 세션아이디가 myclass테이블에 동시에 등록돼있는지
		String memberId = (String)request.getSession().getAttribute("userID");
		int myLesson = pservice.chkMyLesson(lessonNo, memberId);
		System.out.println("controller endLesson: "+endLesson);
		//해당 강의에 리뷰등록 여부 확인
		int existReview = service.chkReview(lessonNo);
		System.out.println("controller existReview: "+existReview);
		
		mav.addObject("fav", service.chkFav(fav));
		mav.addObject("vo", service.selectOne(lessonNo));
		mav.addObject("reviewAvg", service.getReviewAvg(service.selectOne(lessonNo).getTutorId()));
		mav.addObject("endLesson", endLesson);
		mav.addObject("myLesson", myLesson);
		mav.addObject("existReview", existReview);
		
		String memberPhoto = (String) request.getSession().getAttribute("memberPhoto");
		model.addAttribute("memberPhoto", memberPhoto);

		return mav;
	}

	@RequestMapping(value = "/insertCourseForm")
	public ModelAndView insertForm(HttpServletRequest request) {
		logger.info("[course]insertFrom"); 
		ModelAndView mav = new ModelAndView("lesson/courseWriting");
		
		String memberPhoto = (String) request.getSession().getAttribute("memberPhoto");
		mav.addObject("memberPhoto", memberPhoto);
		return mav; 
	}

	@RequestMapping(value = "/insertCourseRes", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, Model model, LessonVo lessonVo, MultipartFile lessonFile) {
		logger.info("[course]insert RES");

		int res = service.insert(model, lessonVo, request, lessonFile);

		if (res > 0) {
			logger.info("[course]insert success");
			return "redirect:courseList?page=1&perPageNum=6";
		} else {
			logger.info("[course]insert fail....");
			return "redirect:insertCourseForm";
		}
	}

	@RequestMapping(value = "/updateCourseForm")
	public String updateForm(Model model, int lessonNo) {
		logger.info("[course]updateForm");
		model.addAttribute("vo", service.selectOne(lessonNo));

		return "lesson/courseUpdate";
	}

	@RequestMapping(value = "/updateCourseRes")
	public String updateRes(Model model, LessonVo vo) {

		logger.info("[course]update Result");
		int res = service.update(vo);
		if (res > 0) {
			model.addAttribute("vo", service.selectOne(vo.getLessonNo()));
			logger.info("update success");
			return "redirect:courseDetail?lessonNo=" + vo.getLessonNo();
		} else {
			logger.info("update fail....");
			return "redirect:courseUpdateForm?lessonNo=" + vo.getLessonNo();
		}
	}

	@RequestMapping(value = "deleteCourse")
	public String delete(int lessonNo) {
		logger.info("[course]delete");
		int res = service.delete(lessonNo);
		if (res > 0) {
			logger.info("delete success");
			return "redirect:courseList?page=1&perPageNum=6";
		} else {
			logger.info("delete fail....");
			return "redirect:courseDetail?lessonNo=" + lessonNo;
		}
	}

	@RequestMapping(value = "/courseOrderByReview")
	public ModelAndView orderByRiview(PagingVo page, HttpServletRequest request) {
		logger.info("[course] orderByRiview");
		ModelAndView mav = new ModelAndView("lesson/course");

		page.setPerPageNum(6);

		PageMakerVo pageMaker = new PageMakerVo();
		pageMaker.setPageVo(page);
		pageMaker.setDisplayPageNum(6);
		pageMaker.setTotalCount(service.listCount());

		mav.addObject("list", service.orderByRiview(page));
		mav.addObject("pageMaker", pageMaker);
		mav.addObject("orderby", 2);

		String memberType = (String) request.getSession().getAttribute("memberType");
		mav.addObject("memberType", memberType);

		return mav;
	}

	@RequestMapping(value = "/SearchKeywordCourse")
	public ModelAndView searchKeyword(@RequestParam(defaultValue = "") String keyword, HttpServletRequest request) {
		logger.info("[course]Search List");
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchKeyword(keyword));

		String memberType = (String) request.getSession().getAttribute("memberType");
		mav.addObject("memberType", memberType);

		return mav;
	}

	@RequestMapping(value = "/courseTypeLICENSE")
	public ModelAndView searchLICENSE(HttpServletRequest request) {
		logger.info("[course]Search courseType LICENSE");
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchLICENSE());

		String memberType = (String) request.getSession().getAttribute("memberType");
		mav.addObject("memberType", memberType);

		return mav;
	}

	@RequestMapping(value = "/courseTypeSPEAKING")
	public ModelAndView searchSPEAKING(HttpServletRequest request) {
		logger.info("[course]Search courseType SPEAKING");
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchSPEAKING());
		String memberType = (String) request.getSession().getAttribute("memberType");
		mav.addObject("memberType", memberType);

		return mav;
	}

	@RequestMapping(value = "/searchHighLevel")
	public ModelAndView searchHighLevel(HttpServletRequest request) {
		logger.info("[course]Search courseType SPEAKING");
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchHighLevel());
		String memberType = (String) request.getSession().getAttribute("memberType");
		mav.addObject("memberType", memberType);

		return mav;
	}

	@RequestMapping(value = "/searchMidLevel")
	public ModelAndView searchMidLevel(HttpServletRequest request) {
		logger.info("[course]Search courseType SPEAKING");
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchMidLevel());
		String memberType = (String) request.getSession().getAttribute("memberType");
		mav.addObject("memberType", memberType);

		return mav;
	}

	@RequestMapping(value = "/searchLowLevel")
	public ModelAndView searchLowLevel(HttpServletRequest request) {
		logger.info("[course]Search courseType SPEAKING");
		ModelAndView mav = new ModelAndView("lesson/course");
		mav.addObject("list", service.searchLowLevel());
		String memberType = (String) request.getSession().getAttribute("memberType");
		mav.addObject("memberType", memberType);

		return mav;
	}

	@RequestMapping(value = "addReview")
	@ResponseBody
	public Map<String, Boolean> addReview(ReviewVo vo) throws Exception {
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

	@RequestMapping(value = "/reviewList")
	@ResponseBody
	public Map<String, List<ReviewVo>> reviewList(@RequestParam String tutorId) {
		logger.info("[course]Select reviewList"); // log에 info 찍어주는 것

		Map<String, List<ReviewVo>> map = new HashMap<String, List<ReviewVo>>();
		map.put("reviewlist", service.selectReviewList(tutorId));

		return map;

	}

	@RequestMapping(value = "/reviewAvg")
	@ResponseBody
	public Map<String, Double> reviewAvg(@RequestParam String tutorId) {
		logger.info("[course]Select reviewList"); // log에 info 찍어주는 것

		Map<String, Double> map = new HashMap<String, Double>();
		map.put("avg", service.getReviewAvg(tutorId));

		return map;

	}

	@RequestMapping(value = "deleteReview")
	public String deleteReview(int reviewNo, int lessonNo) {
		logger.info("[course]deleteReview");
		int res = service.deleteReview(reviewNo);
		if (res > 0) {
			logger.info("delete success");
			return "redirect:courseDetail?lessonNo=" + lessonNo;
		} else {
			logger.info("delete fail....");
			return "redirect:courseDetail?lessonNo=" + lessonNo;
		}
	}

	// 찜
	@RequestMapping(value = "/addFav")
	@ResponseBody
	public int addFav(@RequestParam int lessonNo, @RequestParam String memberId) {
		logger.info("[course] addFav");

		Map<String, String> fav = new HashMap<String, String>();
		fav.put("memberId", memberId);
		fav.put("lessonNo", lessonNo + "");

		String chk = service.chkFav(fav);
		if (chk.equals("fav")) {
			logger.info("delete fav");
			service.deleteFav(fav);
			return 0;
		} else {
			logger.info("insert fav");
			service.insertFav(fav);
			return 1;
		}
	}
	
	@RequestMapping(value = "/memoDownload", produces = "application/text; charset=utf8")
	@ResponseBody
	public int memoDownload (Model model, @RequestParam String memoTxt, HttpServletRequest reques, HttpServletResponse response) throws IOException {
		logger.info("[memo] memoDownload");
		
		int res = service.memoDownload(reques,response,memoTxt);
		
		return res;
	}

}
