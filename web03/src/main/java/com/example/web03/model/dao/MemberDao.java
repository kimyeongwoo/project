package com.example.web03.model.dao;

import java.util.List;

import com.example.web03.model.dto.MemberVo;

public interface MemberDao {

	public String getTime();
	public int insertMember(MemberVo vo) throws Exception;
	public List<MemberVo> memberList();
	public MemberVo memberInfo(String userid);
	public boolean pwdCheck(String userid, String userpw); //비밀번호 확인
	public void updateInfo(MemberVo vo); //회원 정보 수정
	public void deleteInfo(MemberVo vo); //회원 정보 삭제
}
