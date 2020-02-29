package com.blah.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.blah.dao.UserDao;
import com.blah.vo.FilesVo;
import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;
import com.blah.vo.MyclassVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	/**
	 * 
	 * @author User
	 */
	@Override
	public List<LessonVo> selectMyClass(MemberVo vo) {
		return dao.selectMyClass(vo);
	}

	@Override
	public List<LessonVo> selectClosedMyClass(MemberVo vo) {
		return dao.selectClosedMyClass(vo);
	}

	@Override
	public MemberVo selectMember(MemberVo vo) {
		return dao.selectMember(vo);
	}

	@Override
	public List<MyclassVo> selectProgress(MemberVo vo) {
		return dao.selectProgress(vo);
	}

	@Override
	public void uploadProfile(HttpServletRequest request, HttpSession session, FilesVo uploadFile, MemberVo vo) {
		MultipartFile file = uploadFile.getFilesDir();
		String filename = file.getOriginalFilename(); // 업로드한 파일의 실제 이름

		MemberVo fileobj = new MemberVo();
		fileobj.setMemberPhoto(filename);
		fileobj.setMemberId(vo.getMemberId());

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			inputStream = file.getInputStream();
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/profile");

			System.out.println("업로드 될 실제 경로 : " + path);
			// C:\workspace\workspace_framework\Spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVC04_fileUpload\storage

			File storage = new File(path);
			if (!storage.exists()) { // 존재하는지 여부. exists가 true이면 파일이 있다.
				storage.mkdirs(); // 디렉토리 만들기
			}

			File newfile = new File(path + "/" + filename);

			String ext = newfile.getName().substring(newfile.getName().lastIndexOf(".") + 1);
			if (ext.equals("jpg") || ext.equals("png") || ext.equals("gif") || ext.equals("JPG") || ext.equals("PNG")) {

				String prev = vo.getMemberPhoto();
				File prevFile = new File(path + "/" + prev);
				if (prevFile.exists()) {
					System.out.println("---중복파일 존재---");
					prevFile.delete();// 기존파일 있다면 삭제
				}

				if (!newfile.exists()) {
					newfile.createNewFile();
				}
				outputStream = new FileOutputStream(newfile);

				int read = 0;
				byte[] b = new byte[(int) file.getSize()]; // outputStream은 byte단위이기 때문에

				while ((read = inputStream.read(b)) != -1) {
					outputStream.write(b, 0, read);
				}
			} else {
				if (newfile.exists()) {
					newfile.delete();
				}
			}
			dao.updateProfile(fileobj);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Map<String, Boolean> changePw(MemberVo vo, HashMap<String, String> hmap) {
		
		boolean check = false;
		
		if(passwordEncoder.matches(hmap.get("nowPw"), vo.getMemberPw())) {	
			vo.setMemberPw(passwordEncoder.encode(hmap.get("newPw")));
			if(dao.updatePassword(vo) > 0) {
				check = true;
			}
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}

	@Override
	public Map<String, Boolean> deleteMember(MemberVo vo, String nowpw) {
		
		boolean check = false;
		System.out.println(nowpw+","+ vo.getMemberPw());
		if(passwordEncoder.matches(nowpw, vo.getMemberPw())) {
			if(dao.deleteMember(vo) > 0) {
				check = true;
			}else {
				System.out.println("탈퇴실패");
			}
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	@Override
	public HashMap<String, Object> getLessonInfo(int lessonNo, String userId) {
		HashMap<String, Object> map = dao.getLessonInfo(lessonNo);	// lesson & myClass join 한 정보 출력
//		for(Object key : map.keySet()) {
//			System.out.println(key+" : "+map.get(key));
//		}
		// 기본값 false로 세팅
		map.put("flag", false);
		map.put("classDay",false);
		
		if(userId.equals(map.get("MEMBER_ID")) || userId.equals(map.get("TUTOR_ID"))) {
			map.put("flag", true);		// session 정보와 비교
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");		// 날짜 형식 
		String today = format.format(new Date());							// 오늘 날짜 String Type
		
		int classCnt = 4;						// 수업 횟수  FIXME 리터럴로 적는게 아닌 DB에서 받아올 수 있는 값 생각해보기
		for(int i=1; i<=classCnt; i++) {
			Date compareDay = (Date) map.get("MYCLASS_DATE"+i);
			if(today.compareTo(format.format(compareDay)) == 0) {
				map.put("classDay",true);		// DB 날짜와 오늘 날짜가 같으면 수업날짜를 true로 출력
				break;
			}
		}
		return map;
	}
}
