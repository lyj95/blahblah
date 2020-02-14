package com.blah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.NoticeDao;
import com.blah.vo.NoticeVo;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao dao;
	
	@Override
	public List<NoticeVo> selectList() {
		
		List<NoticeVo> res =  dao.selectList();
		
		for (int i = 0; i < res.size(); i++) {
			String noticeDate = res.get(i).getNoticeDate().substring(0, 10);
			res.get(i).setNoticeDate(noticeDate);
		}
        
		return res;
	}

	@Override
	public NoticeVo selectOne(int noticeNo) {
		return dao.selectOne(noticeNo);
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

}
