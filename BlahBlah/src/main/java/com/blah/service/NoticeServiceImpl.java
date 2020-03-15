package com.blah.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.NoticeDao;
import com.blah.vo.NoticeVo;
import com.blah.vo.PagingVo;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao dao;
	
	/**
	 * 공지 목록 최신순 불러오기
	 * @param PagingVo page
	 * @return List<NoticeVo> res 
	 * @author 강현주
	 */
	@Override
	public List<NoticeVo> selectList(PagingVo page) {
		
		List<NoticeVo> res =  dao.selectList(page);
		
		//공지 목록 작성일 YY-MM-DD 형식으로 변경
		for (int i = 0; i < res.size(); i++) {
			String noticeDate = res.get(i).getNoticeDate().substring(0, 10);
			res.get(i).setNoticeDate(noticeDate);
		}
        
		return res;
	}

	/**
	 * 공지 목록 조회순 불러오기
	 * @param PagingVo page
	 * @return List<NoticeVo> res 
	 * @author 강현주
	 */
	@Override
	public List<NoticeVo> selectListOrderByNoticeView(PagingVo page) {
		
		List<NoticeVo> res =  dao.selectListOrderByNoticeView(page);
		
		//공지 목록 작성일 YY-MM-DD 형식으로 변경
		for (int i = 0; i < res.size(); i++) {
			String noticeDate = res.get(i).getNoticeDate().substring(0, 10);
			res.get(i).setNoticeDate(noticeDate);
		}
        
		return res;
	}
	
	/**
	 * 공지 목록 페이징 처리
	 * @return int (dao에서 넘어온 list의 개수)
	 * @author 강현주
	 */
	@Override
	public int listCount( ) {
		return dao.listCount();
	}

	/**
	 * 공지 작성일이 오늘이면 목록에 new를 표시
	 * @return String (dao에서 조회한 오늘 날짜값)
	 * @author 강현주
	 */
	@Override
	public String findSysdate() {
		return dao.findSysdate();
	}
	
	/**
	 * 공지 상세 보기
	 * @param int noticeNo
	 * @return NoticeVo (dao에서 select해온 noticeVo)
	 * @author 강현주
	 */
	@Override
	public NoticeVo selectOne(int noticeNo) {
		
		//공지 상세 보기하면 조회수 1 올리기
		System.out.println("pre");
		int res = updateNoticeView(noticeNo);
		System.out.println("post");
		return dao.selectOne(noticeNo);
	}

	/**
	 * 공지 작성
	 * @param NoticeVo vo
	 * @return int (insert 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int insert(NoticeVo vo) {
		return dao.insert(vo);
	}

	/**
	 * 공지 수정
	 * @param NoticeVo vo
	 * @return int (update 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int update(NoticeVo vo) {
		return dao.update(vo);
	}

	/**
	 * 공지 삭제
	 * @param int noticeNo
	 * @return int (delete 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int delete(int noticeNo) {
		return dao.delete(noticeNo);
	}

	/**
	 * 공지 조회수 +1
	 * @param int noticeNo
	 * @return int (update 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int updateNoticeView(int noticeNo) {
		//현재 조회수
		int currentNoticeView = selectCurrentNoticeView(noticeNo);
		currentNoticeView++;
		System.out.println("조회수 업데이트 메서드 입장");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("noticeNo", noticeNo);
		map.put("currentNoticeView", currentNoticeView);
		System.out.println(map.get("currentNoticeView")+" 조회수를 가진 "+map.get("noticeNo"));
		return dao.updateNoticeView(map);
	}
	
	/**
	 * 공지 현재 조회수
	 * @param int noticeNo
	 * @return int (dao에서 조회해온 현재 조회수)
	 * @author 강현주
	 */
	@Override
	public int selectCurrentNoticeView(int noticeNo) {
		
		int currentNoticeView = dao.selectCurrentNoticeView(noticeNo);
		
		return currentNoticeView;
	}

	/**
	 * 공지 조회수 -1 (글 수정 시에는 조회수가 올라가지 않음)
	 * @param int noticeNo
	 * @return int (update 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int decreaseNoticeView(int noticeNo) {
		
		int currentNoticeView = dao.selectCurrentNoticeView(noticeNo);
		currentNoticeView--;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("noticeNo", noticeNo);
		map.put("currentNoticeView", currentNoticeView);
		
		return dao.updateNoticeView(map);
	}

	/**
	 * 공지 제목으로 검색
	 * @param String searchContent
	 * @param PagingVo page
	 * @return List<NoticeVo> res 
	 * @author 강현주
	 */
	@Override
	public List<NoticeVo> searchByTitle(String searchContent, PagingVo page) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchContent", searchContent);
		map.put("rowStart", Integer.toString(page.getRowStart()));
		map.put("rowEnd", Integer.toString(page.getRowEnd()));
		
		return dao.searchByTitle(map);
	}
	
	/**
	 * 공지 내용으로 검색
	 * @param String searchContent
	 * @param PagingVo page
	 * @return List<NoticeVo> res 
	 * @author 강현주
	 */
	@Override
	public List<NoticeVo> searchByContent(String searchContent, PagingVo page) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchContent", searchContent);
		map.put("rowStart", Integer.toString(page.getRowStart()));
		map.put("rowEnd", Integer.toString(page.getRowEnd()));
		
		return dao.searchByContent(map);
	}

	/**
	 * 공지 이전글 조회
	 * @param int noticeNo
	 * @return NoticeVo res 
	 * @author 강현주
	 */
	@Override
	public NoticeVo selectPrePost(int noticeNo) {
		return dao.selectPrePost(noticeNo);
	}

	/**
	 * 공지 다음글 조회
	 * @param int noticeNo
	 * @return NoticeVo res 
	 * @author 강현주
	 */
	@Override
	public NoticeVo selectNextPost(int noticeNo) {
		return dao.selectNextPost(noticeNo);
	}

}
