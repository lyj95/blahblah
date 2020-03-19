package com.blah.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.blah.controller.HomeController;
import com.blah.dao.LessonDao;
import com.blah.vo.LessonVo;
import com.blah.vo.PagingVo;
import com.blah.vo.ReviewVo;

@Service
public class LessonServiceImpl implements LessonService {
	
	@Autowired
	private LessonDao dao;
	
	@Override
	public int insert(Model model, LessonVo vo, HttpServletRequest request, MultipartFile file) {
		// TODO insert 기능
		System.out.println("서비스 ");
		Logger logger = LoggerFactory.getLogger(HomeController.class);
		
		logger.info("파일이름 :"+file.getOriginalFilename());
        logger.info("파일크기 : "+file.getSize());
        logger.info("컨텐트 타입 : "+file.getContentType());
        logger.info(vo.toString());
		String filename =  file.getOriginalFilename(); //업로드할 파일의 실제이름
		
		String lessonTime = vo.getLessonDay() + " " + vo.getLessonTime();
		vo.setLessonTime(lessonTime);
		
		int res = dao.insert(vo);
		
		vo.setLessonSample(filename);
		System.out.println("변경된 lessonSample"+vo.getLessonSample());
		vo.setLessonNo(dao.getLastLessonSeq());
		
		if (res > 0) {
			InputStream inputStream = null;
			OutputStream outputStream = null;

			try {
				inputStream = file.getInputStream();
				String path = request.getSession().getServletContext().getRealPath( "/resources/lessonSample/"+vo.getLessonNo());//해당 강의명으로 된 파일 생성

				System.out.println("업로드될 실제 경로 :" + path);

				File folder = new File(path);
				if (!folder.exists()) {// 폴더 존재하지 않을 때
					folder.mkdirs();// 디렉토리 만들기
				}
				File insertFile = new File(path + "/" + filename);
				if (!insertFile.exists()) {
					insertFile.createNewFile();
				}
				file.transferTo(insertFile);
				
				File videoFile = new File(path + "/videoFile.mp4");
				insertFile.renameTo(videoFile);
				
				insertFile.delete();

				outputStream = new FileOutputStream(insertFile);
				int read = 0;
				byte[] b = new byte[(int) file.getSize()];
				while ((read = inputStream.read(b)) != -1) {
					outputStream.write(b, 0, read);
				}

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
 
		return res;
	}
	
	@Override
	public List<LessonVo> selectList(PagingVo page) {
		// TODO 전체목록 조회
		return dao.selectList(page);
	}
	
	@Override
	public LessonVo selectOne(int lessonNo) {
		// TODO 상세페이지
		return dao.selectOne(lessonNo);
	}

	@Override
	public int update(LessonVo vo) {
		// TODO 글 수정
		return dao.update(vo);
	}

	@Override
	public int delete(int lessonNo) {
		// TODO 글 삭제
		return dao.delete(lessonNo);
	}

	@Override
	public List<LessonVo> searchKeyword(String keyword) {
		// TODO 키워드로 검색한 목록 
 		return dao.searchKeyword(keyword);
	}

	@Override
	public List<LessonVo> searchLICENSE() {
		// TODO 강의타입이 라이센스인 글 목록
		return dao.searchLICENSE();
	}

	@Override
	public List<LessonVo> searchSPEAKING() {
		// TODO 강의 타입이 스피킹인 목록
		return dao.searchSPEAKING();
	}

	@Override
	public List<LessonVo> searchHighLevel() {
		// TODO 강의레발 상 목록 조회
		return dao.searchHighLevel();
	}

	@Override
	public List<LessonVo> searchMidLevel() {
		// TODO 강의레발 중 목록 조회
		return dao.searchMidLevel();
	}

	@Override
	public List<LessonVo> searchLowLevel() {
		// TODO 강의레발 하 목록 조회
		return dao.searchLowLevel();
	}

	@Override
	public int addReview(ReviewVo vo) {
		// TODO 리뷰작성
		return dao.addReview(vo);
	}

	@Override
	public List<ReviewVo> selectReviewList(String tutorId) {
		// TODO 리뷰조회
		return dao.selectReviewList(tutorId);
	}

	@Override
	public int listCount() {
		// TODO 글 갯수 조회
		return dao.listCount();
	}
	@Override
	public int listReviewCount() {
		// TODO 리뷰글 갯수 조회
		return dao.listReviewCount();
	}

	@Override
	public Double getReviewAvg(String tutorId) {
		// TODO 리뷰 평점 가져오기
		return dao.getReviewAvg(tutorId);
	}

	@Override
	public List<LessonVo> orderByRiview(PagingVo page) {
		// TODO 리뷰 평점순 조회
		return dao.orderByRiview(page);
	}

	@Override
	public int deleteReview(int reviewNo) {
		// TODO 리뷰 삭제
		return dao.deleteReview(reviewNo);
	}

	@Override
	public List<ReviewVo> selectLatestReview() {
		// TODO 최신 리뷰 조회
		return dao.selectLatestReview();
	}

	@Override
	public List<LessonVo> selectPopularLesson() {
		// TODO 인기 강의 조회
		return dao.selectPopularLesson();
	}
	
	//찜 목록
	@Override
	public String chkFav(Map<String, String> fav) {
		// TODO 찜 여부
		return dao.chkFav(fav);
	}

	@Override
	public int deleteFav(Map<String, String> fav) {
		// TODO 찜 삭제
		return dao.deleteFav(fav);
	}

	@Override
	public int insertFav(Map<String, String> fav) {
		// TODO 찜 추가
		return dao.insertFav(fav);
	}

	@Override
	public List<Map<String, String>> selectFavCount() {
		return dao.selectFavCount();
	}

	@Override
	public int memoDownload(HttpServletRequest request, HttpServletResponse response, String memoTxt) throws IOException {
		
		try {
			File storage = new File("C:/blahblahMemo");
			if(!storage.exists()) {	//존재하는지 여부. exists가 true이면 파일이 있다.
				storage.mkdirs(); //디렉토리 만들기	
			}
			
			OutputStream output = new FileOutputStream("C:/blahblahMemo/classMemo.txt");
			output.write(memoTxt.getBytes()); //Byte형으로만 넣을 수 있음
				
		} catch (Exception e) {
	        e.getStackTrace();
		}
		
		return 0;
	}
	
	public int chkReview(int lessonNo) {
		// TODO Auto-generated method stub
		return dao.chkReview(lessonNo);
	}

}
