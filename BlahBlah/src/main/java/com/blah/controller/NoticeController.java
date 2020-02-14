package com.blah.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blah.service.NoticeService;
import com.blah.service.NoticeServiceImpl;
import com.blah.vo.NoticeVo;

@Controller
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NoticeService service = new NoticeServiceImpl();
	
	@RequestMapping(value = "/notice")
	public String openNotice(Locale locale, Model model) {
		
		logger.info("공지 페이지");
		
		model.addAttribute("noticeList", service.selectList());
		
		return "board/notice";
	}
	
	@RequestMapping(value = "/noticeDetail")
	public String noticeDetail(Model model, int noticeNo) {
		
		logger.info("공지 상세 보기");
		
		model.addAttribute("vo", service.selectOne(noticeNo));
		
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
			model.addAttribute("vo", service.selectOne(vo.getNoticeNo()));
			return "board/noticeDetail";
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
}
