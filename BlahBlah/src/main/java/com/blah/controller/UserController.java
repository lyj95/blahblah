package com.blah.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.blah.service.UserService;
import com.blah.vo.MemberVo;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/mypage")
	public ModelAndView mypage(Model model, HttpSession session) {
		logger.info("Mypage");
		
		MemberVo vo = (MemberVo)session.getAttribute("login");
		String memberId = vo.getMemberId();
		System.out.println(vo);


		ModelAndView mav = new ModelAndView("mypage/mypage");
		mav.addObject("myclassList", service.selectMyClass(memberId));
		mav.addObject("closedmyclassList", service.selectMyClass(memberId));
		mav.addObject("member", service.selectMember(memberId));
		mav.addObject("progressList", service.selectProgress(memberId));
		
		return mav;
	}
	
//	@Autowired
//	private FileValidate fileValidator;
//	
//	@RequestMapping(value="/uploadProfile")
//	public String fileupload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
//		// BindingResult : 객체를 Binding하다 에러가 발생하면 해당 에러의 정보를 받기위해 사용된다.
//		
//		fileValidator.validate(uploadFile, result);
//		if(result.hasErrors()) {
//			return "uploadForm";
//		}
//		MultipartFile file = uploadFile.getFile();
//		String filename = file.getOriginalFilename();		//업로드한 파일의 실제 이름
//		
//		UploadFile fileobj = new UploadFile();
//		fileobj.setFilename(filename);
//		fileobj.setDesc(uploadFile.getDesc());	//메모		
//		
//		InputStream inputStream = null;
//		OutputStream outputStream = null;
//		
//		try {
//			inputStream = file.getInputStream();
//			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
//			
//			System.out.println("업로드 될 실제 경로 : " + path);
//			//C:\workspace\workspace_framework\Spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVC04_fileUpload\storage
//			
//			File storage = new File(path);
//			if(!storage.exists()) {	//존재하는지 여부. exists가 true이면 파일이 있다.
//				storage.mkdirs(); //디렉토리 만들기	
//			}
//			
//			File newfile = new File(path+"/"+filename);
//			
//			if(!newfile.exists()) {
//				newfile.createNewFile();
//			}
//			outputStream = new FileOutputStream(newfile);
//			
//			int read = 0;
//			byte[] b = new byte[(int)file.getSize()];	//outputStream은 byte단위이기 때문에
//			
//			while((read=inputStream.read(b)) != -1) {
//				outputStream.write(b, 0, read);
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
//				inputStream.close();
//				outputStream.close();
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		model.addAttribute("fileobj",fileobj);
//		
//		return "uploadFile";
//	}
	
	@RequestMapping(value = "/deleteUser")
	public String deleteUser(Model model, HttpSession session) {
		logger.info("deleteUser");
		
		MemberVo vo = (MemberVo)session.getAttribute("login");
		
		return "common/main";
	}
	
	@RequestMapping(value = "/lessonRoom")
	public String lessonRoom (Model model) {
		logger.info("into the lesson");
		
		return "mypage/mypageLessonRoom";
	}


}
