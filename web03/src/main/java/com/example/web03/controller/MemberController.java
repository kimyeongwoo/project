package com.example.web03.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web03.model.dao.MemberDao;
import com.example.web03.model.dto.MemberVo;

@Controller
public class MemberController {
	@Inject
	MemberDao memberDao;
	// http://localhost:8080/web03/member/getTime
	@RequestMapping("/member/getTime")
	public void getTime(Model model){  //return(���ư� ������ ����)�� ���� type�� void�� ���, ���ư� �������� requestmapping ��η� �����ȴ�
		String time = memberDao.getTime();
		model.addAttribute("time", time);
	}
	
	// http://localhost:8080/web03/member/memberInsert
	@RequestMapping("/member/memberInsert")
	public String memberForm(@ModelAttribute MemberVo vo, Model model, HttpSession session) throws Exception{
		if(vo.getUserid()==null){ //memberForm.jsp�� �Է��� ���� ������ 
			return "member/memberForm"; //  member�������� memberForm.jsp�� �������̵�
		}else{//�Է�������
			//memberForm.jsp���� �Է��� ���� vo�� ����� ����
			int result = memberDao.insertMember(vo);
			if(result>0){  //����������
				//���ǿ� ������� ���� ����
				session.setAttribute("userid", vo.getUserid());
				session.setAttribute("username", vo.getUsername());
				model.addAttribute("message", "ȸ������ ó���� �Ϸ�Ǿ����ϴ�.");
				return "member/main"; //main.jsp�� �̵�
			}else{  //����������
				System.out.println("error");
				model.addAttribute("message", "ȸ�� ��� �������� ������ �߻��߽��ϴ�.");
				return "member/memberForm";//memberForm.jsp�� �̵�
			}
		}
	}
	
	
	@RequestMapping("/member/memberList")
	public void memberList(Model model){
		
		model.addAttribute("list", memberDao.memberList());//�𵨾ȿ� list��� ���������� Dao���� �̾ƿ� �����͵��� ����
		//������ �������� list�� ��� member�������� memberList.jsp ������ ���δ�
	}
	
	@RequestMapping("/member/memberInfo")
	public void memberInfo(String userid, Model model){
		model.addAttribute("dto", memberDao.memberInfo(userid));
	}
	
	@RequestMapping("/member/memberUpdate")
	public String memberUpdate(@ModelAttribute MemberVo vo, Model model){  //���� �Է��� �����͵��� ModelAttribute�� �����
		//��й�ȣ�� ��Ȯ���� Ȯ��
		boolean result = memberDao.pwdCheck(vo.getUserid(), vo.getUserpw());
		if(result){
			//����� ������ update�� ���� ����Ʈ�� �̵�
			memberDao.updateInfo(vo);
			//redirect:/ - ����(��Ʈ�ѷ� ȣ��)
			//jsp�������� ������ redirect:/�� �Ⱦ���
			
			//���� -  /member -> ��Ʈ ���丮 ���� /member
			//         member -> ���� ���丮 ����  member/member
			return "redirect:/member/memberList";
		}else {
			//����� Ʋ���� memberInfo�� �ǵ��ư�
			model.addAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			//�ٵ� ���� message�� ������ �� ��� input ���� ������ �� ���ư���.
			//�׷��� ������ ���� ȸ������ ��ü�� ����
			model.addAttribute("dto", vo);
			return "/member/memberInfo";
		}
	}
	
	
	@RequestMapping("/member/memberDelete")
	public String memberDelete(@ModelAttribute MemberVo vo, Model model){
		
		boolean result = memberDao.pwdCheck(vo.getUserid(), vo.getUserpw());
		if(result){
			memberDao.deleteInfo(vo);
			return "redirect:/member/memberList";
		}else {
			model.addAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			model.addAttribute("dto", vo);
			return "/member/memberInfo";
		}
	}
	
	

}
