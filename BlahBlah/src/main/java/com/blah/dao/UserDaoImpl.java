package com.blah.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.FeedbackVo;
import com.blah.vo.LessonVo;
import com.blah.vo.MemberVo;
import com.blah.vo.MsgVo;
import com.blah.vo.MyclassVo;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<LessonVo> selectMyClass(MemberVo vo) {
		List<LessonVo> list = new ArrayList<LessonVo>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectMyClass", vo);
		} catch(Exception e) {
			System.out.println("[error] : selectMyClass");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<LessonVo> selectClosedMyClass(MemberVo vo) {
		List<LessonVo> list = new ArrayList<LessonVo>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectMyClosedClass", vo);
		} catch(Exception e) {
			System.out.println("[error] : selectMyClosedClass");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberVo selectMember(MemberVo vo) {
		
		MemberVo res = new MemberVo();
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "selectMember", vo);
		} catch(Exception e) {
			System.out.println("[error] : selectMember");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<MyclassVo> selectProgress(MemberVo vo) {
		List<MyclassVo> list = new ArrayList<MyclassVo>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectProgress", vo);
		} catch(Exception e) {
			System.out.println("[error] : selectProgress");
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int updateProfile(MemberVo vo) {
		int res= 0;
		try {
			res = sqlSession.update(NAMESPACE+"updateProfile", vo);
		} catch(Exception e) {
			System.out.println("[error] : updateProfile");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int updatePassword(MemberVo vo) {
		int res= 0;
		try {
			res = sqlSession.update(NAMESPACE+"updatePassword", vo);
		} catch(Exception e) {
			System.out.println("[error] : updatePassword");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteMember(MemberVo vo) {
		int res= 0;
		try {
			res = sqlSession.update(NAMESPACE+"deleteMember", vo);
		} catch(Exception e) {
			System.out.println("[error] : deleteMember");
			e.printStackTrace();
		}
		return res;
	}
	/**
	 *	@deprecated 폐기 예정
	 */
	@Override
	public LessonVo getLessonInfo1(int lessonNo) {
		LessonVo lesson = new LessonVo();
		try {
			lesson = sqlSession.selectOne(NAMESPACE+"getLessonInfo", lessonNo);
		} catch (Exception e) {
			System.out.println("[error] : getLessonInfo");
			e.printStackTrace();
		}
		return lesson;
	}
	/**
	 * @deprecated 폐기 예정
	 */
	@Override
	public MyclassVo getClassInfo(int lessonNo) {
		MyclassVo myClass = new MyclassVo();
		myClass = sqlSession.selectOne(NAMESPACE+"getClassInfo", lessonNo);
		return myClass;
	}
	
	@Override
	public HashMap<String, Object> getLessonInfo(int lessonNo) {
		HashMap<String, Object> map = sqlSession.selectOne(NAMESPACE+"getLessonInfo",lessonNo);
		return map;
	}

	@Override
	public List<String> selectTutorPhoto(MemberVo vo) {
		List<String> list = new ArrayList<String>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectTutorPhoto", vo);
			System.out.println(list);
		} catch(Exception e) {
			System.out.println("[error] : selectTutorPhoto");
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int insertFeedback(FeedbackVo vo) {
		int res = sqlSession.insert(NAMESPACE+"insertFeedback",vo);
		return res;
	}
	@Override
	public int updateFeedback(FeedbackVo vo) {
		int res = sqlSession.update(NAMESPACE+"updateFeedback", vo);
		return res;
	}
	@Override
	public String getTutorName(int lessonNo) {
		String res = sqlSession.selectOne(NAMESPACE+"getTutorName", lessonNo);
		return res;
	}
	@Override
	public List<FeedbackVo> selectFeedback(Map<String, Object> pk) {
		List<FeedbackVo> feedback=null;
		feedback = sqlSession.selectList(NAMESPACE+"selectFeedback", pk);
		return feedback;
	}
	

	@Override
	public List<LessonVo> selectFav(String memberId) {
		List<LessonVo> list = new ArrayList<LessonVo>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectFav", memberId);
		} catch(Exception e) {
			System.out.println("[error] : selectFav");
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int wroteFeedback(Map<String, Object> pk) {
		int res = sqlSession.selectOne(NAMESPACE+"wroteFeedback",pk);
		return res;
	}
	@Override
	public int setRemainClass(Map<String, Object> pk) {
		int res = sqlSession.update(NAMESPACE+"setRemainClass", pk);
		return res;
	}

	@Override
	public HashMap<String, Integer> getProgress(Map<String, String> map) {
		HashMap<String, Integer> res = sqlSession.selectOne(NAMESPACE + "getProgress", map);
		return res;
	}

	@Override
	public int insertMsg(MsgVo vo) {
		// TODO 쪽지 보내기
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insertMsg",vo);
		}catch (Exception e) {
			System.out.println("[error] : insertMsg");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int readMsg(int msgNo) {
		// TODO 쪽지 읽었다고 처리
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"readMsg",msgNo);
		}catch (Exception e) {
			System.out.println("[error] : readMsg");
			e.printStackTrace();
		}
		return res;
	}


	@Override
	public List<MsgVo> getAllMsg(String memberId) {
		// TODO 모든 받은 쪽지 목록
		List<MsgVo> list = new ArrayList<MsgVo>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "getAllMsg", memberId);
		} catch(Exception e) {
			System.out.println("[error] : getAllMsg");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getUnreadAllMsg(String memberId) {
		// TODO 읽지 않은 쪽지 갯수
		int res = 0;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"getUnreadAllMsg",memberId);
		}catch (Exception e) {
			System.out.println("[error] : getUnreadAllMsg");
			e.printStackTrace();
		}
		return res;
	}
}
