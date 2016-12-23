package com.hb.mall1.member.model.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hb.mall1.member.model.dto.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Inject
	SqlSession sqlSession;  //mybatis ½ÇÇà °´Ã¼
	
	
	@Override
	public boolean loginCheck(String userid, String userpw) {
		int result=0;
		try {
			Map<String,String> map = new HashMap<String, String>();
			map.put("userid", userid);
			map.put("userpw", userpw);
			result=sqlSession.selectOne("loginCheck", map);
			if(result==1)return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public int insertMember(MemberVo vo) {
		try{
			return sqlSession.insert("insertMember", vo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public int idChk(String userid) {
		int result2=0;
		try {
			result2=sqlSession.selectOne("IdCheck", userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result2;
	}


	@Override
	public MemberVo ipFind(MemberVo vo) {
		try {
			vo=sqlSession.selectOne("ipfind", vo);
			System.out.println(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}


	@Override
	public int updateMember(MemberVo vo) {
		int result = 0;
		try {
			result = sqlSession.update("updateMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public MemberVo memberOne(String userid) {
		MemberVo vo = null;
		try {
			vo=sqlSession.selectOne("memberOne", userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}


	@Override
	public MemberVo ViewInfo(String userid) {
		MemberVo vo2=null;
		try {
			vo2=sqlSession.selectOne("ViewInfo", userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo2;
	}


	@Override
	public void memberLeave(String userid) {
		try {
			sqlSession.delete("memberLeave", userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
