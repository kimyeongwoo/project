package com.example.web03.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.web03.model.dto.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Inject
	SqlSession sqlSession;  //mybatis 실행 객체
	
	@Override
	public String getTime() {
		return sqlSession.selectOne("getTime");
	}

	@Override
	public int insertMember(MemberVo vo) {
		try{
			return sqlSession.insert("insertMember", vo); //insert된 레코드의 줄 갯수가 리턴으로 올라감
			//성공하면 1이 return된다.
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
		//실패하면 0이 return 된다
	}

	@Override
	public List<MemberVo> memberList() {
		List<MemberVo> list=null;
		try {
			list=sqlSession.selectList("memberList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberVo memberInfo(String userid) {
		MemberVo vo = null;
		try {
			vo=sqlSession.selectOne("memberInfo", userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean pwdCheck(String userid, String userpw) {
		int result=0;
		try {
			Map<String,String> map = new HashMap<String, String>();
			map.put("userid", userid);
			map.put("userpw", userpw);
			//mybatis에는 1개의 매개변수만 전달할 수 있음
			//전달할 값이 여러개인 경우 map 또는 dto를 사용
			result=sqlSession.selectOne("pwdCheck", map);
			if(result==1)return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateInfo(MemberVo vo) {
		try {
			sqlSession.update("updateInfo", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteInfo(MemberVo vo) {
		try {
			sqlSession.delete("deleteInfo", vo.getUserid());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
