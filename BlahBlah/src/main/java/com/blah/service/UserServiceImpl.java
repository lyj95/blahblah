package com.blah.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.blah.dao.UserDao;
import com.blah.vo.FeedbackVo;
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
	public String deleteMember(MemberVo vo, String nowpw) {
		
		String check = "false";
		if(passwordEncoder.matches(nowpw, vo.getMemberPw())) {
			if(dao.deleteMember(vo) > 0) {
				check = "true";
			}else {
				System.out.println("탈퇴실패");
			}
		}
		return check;
	}

	@Override
	public List<String> selectTutorPhoto(MemberVo vo) {
		return dao.selectTutorPhoto(vo);
	}
	
	/**
	 * 클래스 정보를 들고오는 기능
	 * DB에 저장된 날짜와 오늘 날짜를 비교해 수강 날짜가 맞는지
	 * 입장한 유저 정보가 학생인지 강사인지를 파악한 후 
	 * 알맞은 정보를 가져온다
	 * 
	 * @author yaans
	 * @param lessonNo 수강 강의번호
	 * @param userId 유저아이디
	 * @return 유저와 날짜에 맞춘 정보
	 */
	@Override
	public List<LessonVo> selectFav(String memberId) {
		return dao.selectFav(memberId);
	}
	
	@Override
	public HashMap<String, Object> getLessonInfo(int lessonNo, String userId) {
		// lesson & myClass join 한 정보 출력
		HashMap<String, Object> map = dao.getLessonInfo(lessonNo);	
		for(Object key : map.keySet()) { System.out.println(key+" : "+map.get(key)); }  // 확인용 sysout
		
		map.put("flag", false);		// 참가 자격 : 기본값 false로 세팅
		
		if(userId.equals(map.get("MEMBER_ID")) || userId.equals(map.get("TUTOR_ID"))) {
			map.put("flag", true);		// session 정보와 비교
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");		// 날짜 형식 
		String today = format.format(new Date());							// 오늘 날짜 String Type
		
		int classCnt = ((BigDecimal)map.get("MYCLASS_TOTALCNT")).intValue();
		for(int i=1; i<=classCnt; i++) {
			Date compareDay = (Date) map.get("MYCLASS_DATE"+i);
			if(today.compareTo(format.format(compareDay)) == 0) {
				map.put("classDay",today);		// DB 날짜와 오늘 날짜가 같으면 수업날짜 map에 저장
				break;
			}
		}
		return map;
	}
	
	/**
	 * 강의 피드백 입력
	 * @author yaans
	 * @param vo 강사 피드백 내용
	 * @return 피드백 입력 성공여부
	 */
	@Override
	public int insertFeedback(FeedbackVo vo, String userId) {
		boolean authorization = isClassTutor(vo.getLessonNo(), userId);
		int res = 0;
		if(authorization) {		// 피드백을 작성한 권한이 있다면
			res = dao.insertFeedback(vo);
		}
		return res;
	}
	@Override
	public int updateFeedback(FeedbackVo vo, String userId) {
		boolean authorization = isClassTutor(vo.getLessonNo(), userId);
		int res = 0;
		if(authorization) {		// 피드백을 작성한 권한이 있다면
			res = dao.updateFeedback(vo);
		}
		return res;
	}
	
	/**
	 * DB에 저장된 튜터아이디와 사용자의 아이디를 비교하는 과정. 사용자가 튜터로서 강의실에 입장했는지 여부
	 * @param lessonNo 강의 번호
	 * @param userId 사용자 아이디
	 * @return 사용자가 튜터가 맞는지
	 */
	@Override
	public boolean isClassTutor(int lessonNo, String userId) {
		boolean authorization = false;
		String tutorId = dao.getTutorName(lessonNo);
		if(userId.equals(tutorId)) {
			authorization = true;
		}
		return authorization;
	}
	@Override
	public List<FeedbackVo> selectFeedback(int lessonNo, String studentId) {
		Map<String, Object> pk = new HashMap<String, Object>();
		pk.put("lessonNo", lessonNo);
		pk.put("studentId", studentId);
		List<FeedbackVo> feedback = dao.selectFeedback(pk);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");		// 날짜 형식
		for(FeedbackVo i : feedback) {
			Date dateType;
			try {
				dateType = format.parse(i.getClassDate());
				i.setClassDate(format.format(dateType));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println(i.toString());
		}
		return feedback;
	}
}
