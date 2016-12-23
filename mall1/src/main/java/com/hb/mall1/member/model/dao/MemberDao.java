package com.hb.mall1.member.model.dao;

import com.hb.mall1.member.model.dto.MemberVo;




public interface MemberDao {

	public boolean loginCheck(String userid, String userpw);
	public int insertMember(MemberVo vo);
	public int idChk(String userid);
	public MemberVo ipFind(MemberVo vo);
	public int updateMember(MemberVo vo);
	public MemberVo memberOne(String userid);
	public MemberVo ViewInfo(String userid);
	public void memberLeave(String userid);
}
