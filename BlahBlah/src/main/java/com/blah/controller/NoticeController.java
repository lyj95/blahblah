package com.blah.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blah.service.NoticeService;
import com.blah.service.NoticeServiceImpl;
import com.blah.vo.NoticeVo;
import com.blah.vo.PageMakerVo;
import com.blah.vo.PagingVo;

@Controller
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NoticeService service = new NoticeServiceImpl();
	
	@RequestMapping(value = "/notice")
	public String openNotice(Locale locale, Model model, PagingVo page) {
		
		logger.info("공지 페이지 (최신순 정렬)");
		
		model.addAttribute("noticeList", service.selectList(page));
		
		PageMakerVo pageMaker = new PageMakerVo();
		pageMaker.setPageVo(page);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("sysdate", service.findSysdate());
		
		return "board/notice";
	}
	
	@RequestMapping(value = "/noticeOrderByNoticeView")
	public String openNoticeOrderByNoticeView(Locale locale, Model model, PagingVo page) {
		
		logger.info("공지 페이지 (조회순 정렬)");
		
		model.addAttribute("noticeList", service.selectListOrderByNoticeView(page));
		
		PageMakerVo pageMaker = new PageMakerVo();
		pageMaker.setPageVo(page);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("sysdate", service.findSysdate());
		
		return "board/notice";
	}
	
	@RequestMapping(value = "/noticeDetail")
	public String noticeDetail(Model model, int noticeNo) {
		
		logger.info("공지 상세 보기");
		
		model.addAttribute("vo", service.selectOne(noticeNo));
		model.addAttribute("pre", service.selectPrePost(noticeNo));
		model.addAttribute("next", service.selectNextPost(noticeNo));
		
		return "board/noticeDetail";
	}
	
	@RequestMapping(value = "/noticeWriteForm")
	public String openNoticeWriteForm(Model model) {
		
		logger.info("공지 작성 페이지 열기");
		
		return "board/noticeInsert";
	}
	
	@RequestMapping(value = "/insertNotice")
	public String insertNotice(NoticeVo vo) {
		
		logger.info("공지 작성");
		
		int res = service.insert(vo);
		if (res > 0) {
			return "redirect:notice";
		} else {
			return "redirect:noticeWriteForm";
		}
	}
	
	@RequestMapping(value = "/noticeUpdateForm")
	public String openNoticeUpdateForm(Model model, NoticeVo vo) {
		
		logger.info("공지 수정 페이지 열기");
		
		model.addAttribute("vo", service.selectOne(vo.getNoticeNo()));
		
		return "board/noticeUpdate";
	}
	
	@RequestMapping(value = "/updateNotice")
	public String updateNotice(Model model, NoticeVo vo) {
		
		logger.info("공지 수정");
		
		int res = service.update(vo);
		if (res > 0) {
			service.decreaseNoticeView(vo.getNoticeNo());
			
			model.addAttribute("vo", service.selectOne(vo.getNoticeNo()));
			return "redirect:noticeDetail?noticeNo="+vo.getNoticeNo();
		} else {
			return "redirect:noticeUpdateForm";
		}
	}
	
	@RequestMapping(value = "deleteNotice")
	public String deleteNotice(Model model, int noticeNo) {
		
		logger.info("공지 삭제");
		
		int res = service.delete(noticeNo);
		if (res > 0) {
			return "redirect:notice";
		} else {
			model.addAttribute("vo", service.selectOne(noticeNo));
			return "board/noticeDetail";
		}
	}
	
	@RequestMapping(value = "searchByTitle", method=RequestMethod.POST)
	public String searchByTitle(Model model, PagingVo page, HttpServletRequest request) {
		
		logger.info("공지 제목으로 검색");
		
		String searchContent = (String)request.getParameter("searchContent");
		model.addAttribute("noticeList", service.searchByTitle(searchContent, page));
		
		PageMakerVo pageMaker = new PageMakerVo();
		pageMaker.setPageVo(page);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("sysdate", service.findSysdate());
		
		return "board/notice";
	}
	
	@RequestMapping(value = "searchByContent", method=RequestMethod.POST)
	public String searchByContent(Model model, PagingVo page, HttpServletRequest request) {
		
		logger.info("공지 내용으로 검색");
		
		String searchContent = (String)request.getParameter("searchContent");
		model.addAttribute("noticeList", service.searchByContent(searchContent, page));
		
		PageMakerVo pageMaker = new PageMakerVo();
		pageMaker.setPageVo(page);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("sysdate", service.findSysdate());
		
		return "board/notice";
	}
	
}
