package com.blah.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blah.dao.QnaDao;
import com.blah.vo.PagingVo;
import com.blah.vo.QnaVo;
import com.blah.vo.ReplyVo;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaDao dao;

	/**
	 * QnA 목록 불러오기
	 * @param PagingVo page
	 * @return List<QnaVo> res 
	 * @author 강현주
	 */
	@Override
	public List<QnaVo> selectList(PagingVo page) {
		
		List<QnaVo> res =  dao.selectList(page);
		
		//QnA 목록 작성일 YY-MM-DD 형식으로 변경
		for (int i = 0; i < res.size(); i++) {
			String qnaDate = res.get(i).getQnaDate().substring(0, 10);
			res.get(i).setQnaDate(qnaDate);
		}
        
		return res;
	}

	/**
	 * QnA 목록 페이징 처리
	 * @return int (dao에서 넘어온 list의 개수)
	 * @author 강현주
	 */
	@Override
	public int listCount() {
		return dao.listCount();
	}

	/**
	 * QnA 작성일이 오늘이면 목록에 new를 표시
	 * @return String (dao에서 조회한 오늘 날짜값)
	 * @author 강현주
	 */
	@Override
	public String findSysdate() {
		return dao.findSysdate();
	}

	/**
	 * QnA 상세 보기
	 * @param int qnaNo
	 * @return QnaVo (dao에서 select해온 qnaVo)
	 * @author 강현주
	 */
	@Override
	public QnaVo selectOne(int qnaNo) {
		return dao.selectOne(qnaNo);
	}

	/**
	 * QnA 글 작성
	 * @param QnaVo vo
	 * @param String memberId
	 * @return int (insert 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int insert(QnaVo vo, String memberId) {
		
		vo.setMemberId(memberId);
		
		//qna가 비밀글인지 아닌지 체크 -> 비밀글이면 qnaOpen 값을 Y로 저장해서 dao로 보냄
		String qnaOpen = vo.getQnaOpen();
		if (qnaOpen==null) {
			vo.setQnaOpen("Y");
			return dao.insert(vo);
		} else {
			return dao.insert(vo);
		}
	}

	/**
	 * QnA 글 작성
	 * @param QnaVo vo
	 * @return int (update 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int update(QnaVo vo) {
		
		//qna가 비밀글인지 아닌지 체크 -> 비밀글이면 qnaOpen 값을 Y로 저장해서 dao로 보냄
		String qnaOpen = vo.getQnaOpen();
		if (qnaOpen==null) {
			vo.setQnaOpen("Y");
			return dao.update(vo);
		} else {
			return dao.update(vo);
		}
	}

	/**
	 * QnA 글 삭제
	 * @param int qnaNo
	 * @return int (delete 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int delete(int qnaNo) {
		return dao.delete(qnaNo);
	}

	/**
	 * QnA 제목으로 검색
	 * @param String searchContent
	 * @param PagingVo page
	 * @return List<QnaVo> res 
	 * @author 강현주
	 */
	@Override
	public List<QnaVo> searchByTitle(String searchContent, PagingVo page) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchContent", searchContent);
		map.put("rowStart", Integer.toString(page.getRowStart()));
		map.put("rowEnd", Integer.toString(page.getRowEnd()));
		
		return dao.searchByTitle(map);
	}

	/**
	 * QnA 내용으로 검색
	 * @param String searchContent
	 * @param PagingVo page
	 * @return List<QnaVo> res 
	 * @author 강현주
	 */
	@Override
	public List<QnaVo> searchByContent(String searchContent, PagingVo page) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchContent", searchContent);
		map.put("rowStart", Integer.toString(page.getRowStart()));
		map.put("rowEnd", Integer.toString(page.getRowEnd()));
		
		return dao.searchByContent(map);
	}

	/**
	 * QnA 해당 글의 답글 조회해오기
	 * @param int qnaNo
	 * @return ReplyVo (dao에서 조회해온 답글) 
	 * @author 강현주
	 */
	@Override
	public ReplyVo selectReply(int qnaNo) {
		return dao.selectReply(qnaNo);
	}

	/**
	 * QnA 답글 작성
	 * @param ReplyVo reply
	 * @return int (insert 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int insertReply(ReplyVo reply) {
		return dao.insertReply(reply);
	}

	/**
	 * QnA 답글 수정
	 * @param ReplyVo reply
	 * @return int (update 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int updateReply(ReplyVo reply) {
		return dao.updateReply(reply);
	}

	/**
	 * QnA 답글이 있으면 QnA 테이블에서 해당 글의 qna_rep 칼럼 값을 'Y'로 업데이트
	 * @param int qnaNo
	 * @return int (update 성공 여부)
	 * @author 강현주
	 */
	@Override
	public int updateQnaRep(int qnaNo) {
		return dao.updateQnaRep(qnaNo);
	}

}
