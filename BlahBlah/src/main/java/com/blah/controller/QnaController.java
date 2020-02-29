package com.blah.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blah.service.QnaService;
import com.blah.service.QnaServiceImpl;
import com.blah.vo.PageMakerVo;
import com.blah.vo.PagingVo;
import com.blah.vo.QnaVo;
import com.blah.vo.ReplyVo;

@Controller
public class QnaController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private QnaService service = new QnaServiceImpl();
	
	@RequestMapping(value = "/qna")
	public String openQna(Locale locale, Model model, PagingVo page) {
		
		logger.info("QnA 페이지 (최신순 정렬)");
		
		model.addAttribute("qnaList", service.selectList(page));
		
		PageMakerVo pageMaker = new PageMakerVo();
		pageMaker.setPageVo(page);
		pageMaker.setDisplayPageNum(10);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("sysdate", service.findSysdate());
		
		return "board/qna";
	}

	@RequestMapping(value = "/qnaDetail")
	public String qnaDetail(Model model, int qnaNo, HttpServletRequest request) {
		
		logger.info("QnA 상세 보기");
		
		model.addAttribute("vo", service.selectOne(qnaNo));
		model.addAttribute("reply", service.selectReply(qnaNo));
		
		String memberType = (String) request.getSession().getAttribute("memberType");
		model.addAttribute("memberType", memberType);
		
		return "board/qnaDetail";
	}
	
	@RequestMapping(value = "/openLockedQnaDetail")
	public String openLockedQnaDetail(Model model, int qnaNo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		logger.info("QnA 상세 보기 (비밀글)");
		
		String userID = (String) request.getSession().getAttribute("userID");
		String memberType = (String) request.getSession().getAttribute("memberType");
		String memberID = service.selectOne(qnaNo).getMemberId();
		
		if (request.getSession().getAttribute("login") != null) {
			if (userID.equals(memberID) || memberType.equals("ADMIN")) {
				
				model.addAttribute("vo", service.selectOne(qnaNo));
				model.addAttribute("reply", service.selectReply(qnaNo));
				model.addAttribute("memberType", memberType);
				
				return "board/qnaDetail";
			} else {
				return "redirect:qna";
			}
		} else {
			return "account/login";
		}
	}
	
	@RequestMapping(value = "/qnaWriteForm")
	public String openQnaWriteForm(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		logger.info("QnA 작성 페이지 열기");
		
		if (request.getSession().getAttribute("login") != null) {
			return "board/qnaInsert";
			
		} else {
			return "account/login";
		}
	}
	
	@RequestMapping(value = "/insertQna")
	public String insertQna(QnaVo vo, HttpServletRequest request) {
		
		logger.info("QnA 작성");
		
		String memberId = (String) request.getSession().getAttribute("userID");
		
		int res = service.insert(vo, memberId);
		if (res > 0) {
			return "redirect:qna";
		} else {
			return "redirect:qnaWriteForm";
		}
	}
	
	@RequestMapping(value = "/qnaUpdateForm")
	public String openQnAUpdateForm(Model model, QnaVo vo) {
		
		logger.info("QnA 수정 페이지 열기");
		
		model.addAttribute("vo", service.selectOne(vo.getQnaNo()));
		
		return "board/qnaUpdate";
	}
	
	@RequestMapping(value = "/updateQna")
	public String updateQnA(Model model, QnaVo vo) {
		
		logger.info("QnA 수정");
		
		int res = service.update(vo);
		if (res > 0) {
			return "redirect:qnaDetail?qnaNo="+vo.getQnaNo();
		} else {
			return "redirect:qnaUpdateForm";
		}
	}
	
	@RequestMapping(value = "deleteQna")
	public String deleteNotice(Model model, int qnaNo) {
		
		logger.info("QnA 삭제");
		
		int res = service.delete(qnaNo);
		if (res > 0) {
			return "redirect:qna";
		} else {
			model.addAttribute("vo", service.selectOne(qnaNo));
			return "board/qnaDetail";
		}
	}
	
	@RequestMapping(value = "searchByQnaTitle", method=RequestMethod.POST)
	public String searchByQnATitle(Model model, PagingVo page, HttpServletRequest request) {
		
		logger.info("QnA 제목으로 검색");
		
		String searchContent = (String)request.getParameter("searchContent");
		model.addAttribute("qnaList", service.searchByTitle(searchContent, page));
		
		PageMakerVo pageMaker = new PageMakerVo();
		pageMaker.setPageVo(page);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("sysdate", service.findSysdate());
		
		return "board/qnaSearch";
	}
	
	@RequestMapping(value = "searchByQnaContent", method=RequestMethod.POST)
	public String searchByQnAContent(Model model, PagingVo page, HttpServletRequest request) {
		
		logger.info("QnA 내용으로 검색");
		
		String searchContent = (String)request.getParameter("searchContent");
		model.addAttribute("qnaList", service.searchByContent(searchContent, page));
		
		PageMakerVo pageMaker = new PageMakerVo();
		pageMaker.setPageVo(page);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("sysdate", service.findSysdate());
		
		return "board/qnaSearch";
	}
	
	@RequestMapping(value = "insertReply", method=RequestMethod.POST)
	public String insertReply(ReplyVo reply) {
		
		logger.info("QnA 답글 작성");
		
		int res = service.insertReply(reply);
		if (res > 0) {
			int res2 = service.updateQnaRep(reply.getQnaNo());
			if (res2 > 0) {
				return "redirect:qnaDetail?qnaNo="+reply.getQnaNo();
			} else {
				return "redirect:qnaDetail?qnaNo="+reply.getQnaNo();
			}
		} else {
			return "redirect:qnaDetail?qnaNo="+reply.getQnaNo();
		}
	}
	
	@RequestMapping(value = "updateReply", method=RequestMethod.POST)
	public String updateReply(ReplyVo reply) {
		
		logger.info("QnA 답글 수정");
		
		int res = service.updateReply(reply);
		if (res > 0) {
			return "redirect:qnaDetail?qnaNo="+reply.getQnaNo();
		} else {
			return "redirect:qnaDetail?qnaNo="+reply.getQnaNo();
		}
	}
}
