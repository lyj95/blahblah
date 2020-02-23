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
	
	@Override
	public List<NoticeVo> selectList(PagingVo page) {
		
		List<NoticeVo> res =  dao.selectList(page);
		
		for (int i = 0; i < res.size(); i++) {
			String noticeDate = res.get(i).getNoticeDate().substring(0, 10);
			res.get(i).setNoticeDate(noticeDate);
		}
        
		return res;
	}

	@Override
	public List<NoticeVo> selectListOrderByNoticeView(PagingVo page) {
		
		List<NoticeVo> res =  dao.selectListOrderByNoticeView(page);
		
		for (int i = 0; i < res.size(); i++) {
			String noticeDate = res.get(i).getNoticeDate().substring(0, 10);
			res.get(i).setNoticeDate(noticeDate);
		}
        
		return res;
	}
	
	@Override
	public int listCount( ) {
		return dao.listCount();
	}

	@Override
	public String findSysdate() {
		return dao.findSysdate();
	}
	
	@Override
	public NoticeVo selectOne(int noticeNo) {
		
		int res = updateNoticeView(noticeNo);
		if (res > 0) {
			return dao.selectOne(noticeNo);
		} else {
			return dao.selectOne(noticeNo);
		}
	}

	@Override
	public int insert(NoticeVo vo) {
		return dao.insert(vo);
	}

	@Override
	public int update(NoticeVo vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(int noticeNo) {
		return dao.delete(noticeNo);
	}

	@Override
	public int updateNoticeView(int noticeNo) {
		
		int currentNoticeView = selectCurrentNoticeView(noticeNo);
		currentNoticeView++;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("noticeNo", noticeNo);
		map.put("currentNoticeView", currentNoticeView);
		
		return dao.updateNoticeView(map);
	}
	
	@Override
	public int selectCurrentNoticeView(int noticeNo) {
		
		int currentNoticeView = dao.selectCurrentNoticeView(noticeNo);
		
		return currentNoticeView;
	}

	@Override
	public int decreaseNoticeView(int noticeNo) {
		
		int currentNoticeView = dao.selectCurrentNoticeView(noticeNo);
		currentNoticeView = currentNoticeView-2;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("noticeNo", noticeNo);
		map.put("currentNoticeView", currentNoticeView);
		
		return dao.updateNoticeView(map);
	}

	@Override
	public List<NoticeVo> searchByTitle(String searchContent, PagingVo page) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchContent", searchContent);
		map.put("rowStart", Integer.toString(page.getRowStart()));
		map.put("rowEnd", Integer.toString(page.getRowEnd()));
		
		return dao.searchByTitle(map);
	}
	
	@Override
	public List<NoticeVo> searchByContent(String searchContent, PagingVo page) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchContent", searchContent);
		map.put("rowStart", Integer.toString(page.getRowStart()));
		map.put("rowEnd", Integer.toString(page.getRowEnd()));
		
		return dao.searchByContent(map);
	}

	@Override
	public NoticeVo selectPrePost(int noticeNo) {
		
		int res = updateNoticeView(noticeNo);
		if (res > 0) {
			return dao.selectPrePost(noticeNo);
		} else {
			return dao.selectPrePost(noticeNo);
		}
	}

	@Override
	public NoticeVo selectNextPost(int noticeNo) {
		
		int res = updateNoticeView(noticeNo);
		if (res > 0) {
			return dao.selectNextPost(noticeNo);
		} else {
			return dao.selectNextPost(noticeNo);
		}
	}

}
