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
	SqlSession sqlSession;  //mybatis ���� ��ü
	
	@Override
	public String getTime() {
		return sqlSession.selectOne("getTime");
	}

	@Override
	public int insertMember(MemberVo vo) {
		try{
			return sqlSession.insert("insertMember", vo); //insert�� ���ڵ��� �� ������ �������� �ö�
			//�����ϸ� 1�� return�ȴ�.
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
		//�����ϸ� 0�� return �ȴ�
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
			//mybatis���� 1���� �Ű������� ������ �� ����
			//������ ���� �������� ��� map �Ǵ� dto�� ���
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
