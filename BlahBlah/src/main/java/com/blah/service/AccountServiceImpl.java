package com.blah.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blah.dao.AccountDao;
import com.blah.vo.MemberVo;


@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao dao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public MemberVo login(MemberVo vo) {
		return dao.login(vo);
	}


	@Override
	public int signup(MemberVo vo) {
		return dao.signup(vo);
	}

	@Override
	public String idchk(String memberId) throws Exception {
		
		return dao.checkId(memberId);
	}
	public Map<String, String> selectSearchId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.selectSearchId(map);
	}

	
	@Override
	public MemberVo naverLogin(String apiResult) {
		/**
		 * apiResult json 구조 {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
		// 2. String형식인 apiResult를 json형태로 바꿈
		MemberVo vo = null;
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(apiResult);
			JSONObject jsonObj = (JSONObject) obj;
			// 3. 데이터 파싱
			// Top레벨 단계 _response 파싱
			JSONObject response_obj = (JSONObject) jsonObj.get("response");
			String memberId = (String) response_obj.get("id");
			String email = (String) response_obj.get("email");
			String name = (String) response_obj.get("name");
			
			vo = new MemberVo(memberId,"pwd","USER",name,email,null,null,"Y");
			if(dao.checkApiId(memberId)!=null) {
				return dao.login(vo);
			}else {
				dao.insertApiMember(vo);
				return vo;
			}
			
		} catch (ParseException e) {
			System.out.println("naver 회원 정보 파싱 실패");
			e.printStackTrace();
		}
		return vo;
		
	}


	@Override
	public MemberVo kakaoLogin(HashMap<String, String> userInfo) {
		
		MemberVo vo = null;
		String memberId = userInfo.get("id");
		String memberName = userInfo.get("nickname");
		
		
		try {
			vo = new MemberVo(memberId,"pwd","USER",memberName,memberId+"@daum.net",null,null,"Y");	//카카오 api 이메일 못가져옴,,
			if(dao.checkApiId(memberId)!=null) {
				return dao.login(vo);
			}else {
				dao.insertApiMember(vo);
				return vo;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}


	@Override
	public Map<String, String> selectEmail(String memberId) {
		return dao.selectEmail(memberId);
	}


	@Override
	public String newPwd() {
	    StringBuffer key = new StringBuffer();
	    Random rnd = new Random();
	    
	    for (int i = 0; i < 10; i++) {
	        int index = rnd.nextInt(3);

	        switch (index) {
	            case 0:
	                key.append((char) ((int) (rnd.nextInt(26)) + 97));
	                break;
	            case 1:
	                key.append((char) ((int) (rnd.nextInt(26)) + 65));
	                break;
	            case 2:
	                key.append((rnd.nextInt(10)));
	                break;
	        }
	    }
	    return key.toString();
	}


	@Override
	public int updatePwd(MemberVo vo) {
		vo.setMemberPw(passwordEncoder.encode(vo.getMemberPw()));
		return dao.updatePwd(vo);
	}
	
}


