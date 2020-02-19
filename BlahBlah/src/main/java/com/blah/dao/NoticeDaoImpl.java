package com.blah.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.NoticeVo;
import com.blah.vo.PagingVo;

@Repository
public class NoticeDaoImpl implements NoticeDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<NoticeVo> selectList(PagingVo page) {
		
		List<NoticeVo> res = new ArrayList<NoticeVo>();
		
		try {
			res = sqlSession.selectList(NAMESPACE+"selectList", page);
		} catch (Exception e) {
			System.out.println("[error] : notice selectList");
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public List<NoticeVo> selectListOrderByNoticeView(PagingVo page) {
		
		List<NoticeVo> res = new ArrayList<NoticeVo>();
		
		try {
			res = sqlSession.selectList(NAMESPACE+"selectListOrderByNoticeView", page);
		} catch (Exception e) {
			System.out.println("[error] : notice select list orderBy noticeView");
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public int listCount() {
		
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"listCount");
		} catch (Exception e) {
			System.out.println("[error] : notice list count");
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public String findSysdate() {
		
		String res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"findSysdate");
		} catch (Exception e) {
			System.out.println("[error] : find sysdate");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public NoticeVo selectOne(int noticeNo) {
		
		NoticeVo res = new NoticeVo();
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectOne", noticeNo);		
		} catch (Exception e) {
			System.out.println("[error] : notice detail");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insert(NoticeVo vo) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert", vo);			
		} catch (Exception e) {
			System.out.println("[error] : insert notice");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(NoticeVo vo) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"update", vo);
		} catch (Exception e) {
			System.out.println("[error] : update notice");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int noticeNo) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"delete", noticeNo);
		} catch (Exception e) {
			System.out.println("[error] : delete notice");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int updateNoticeView(HashMap<String, Integer> map) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"updateNotcieView", map);
		} catch (Exception e) {
			System.out.println("[error] : update noticeView");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int selectCurrentNoticeView(int noticeNo) {
		
		int currentNoticeView = 0;
		
		try {
			currentNoticeView = sqlSession.selectOne(NAMESPACE+"selectCurrentNoticeView", noticeNo);
		} catch (Exception e) {
			System.out.println("[error] : select current noticeView");
			e.printStackTrace();
		}

		return currentNoticeView;
	}

	@Override
	public List<NoticeVo> searchByTitle(String searchContent) {
		
		List<NoticeVo> res = new ArrayList<NoticeVo>();
		
		try {
			res = sqlSession.selectList(NAMESPACE+"searchByTitle", searchContent);
		} catch (Exception e) {
			System.out.println("[error] : notice searchByTitle");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public NoticeVo selectPrePost(int noticeNo) {
		
		NoticeVo res = new NoticeVo();
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectPrePost", noticeNo);		
		} catch (Exception e) {
			System.out.println("[error] : notice pre post detail");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public NoticeVo selectNextPost(int noticeNo) {
		
		NoticeVo res = new NoticeVo();
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectNextPost", noticeNo);		
		} catch (Exception e) {
			System.out.println("[error] : notice next post detail");
			e.printStackTrace();
		}
		
		return res;
	}

}
