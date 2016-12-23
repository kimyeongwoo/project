package com.hb.mall1.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hb.mall1.member.model.dao.MemberDao;
import com.hb.mall1.member.model.dto.MemberVo;

@Controller
public class MemberController {

	@Inject
	MemberDao memberDao;
	
	
	@RequestMapping("/member/main")
	public void enterMain(){
		
	}//���������� �̵�
	
	
	@RequestMapping("/member/login")
	public String memberLogin(@ModelAttribute MemberVo vo, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		boolean result;
		result=memberDao.loginCheck(vo.getUserid(), vo.getUserpw());
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		if(vo.getUserid()==null){
			return "/member/login";
		}else if(result){
			writer.println("<script type='text/javascript'>");
			writer.println("alert('���������� �α��� �Ǿ����ϴ�.');");
			writer.println("</script>");
			writer.flush();
			MemberVo vo2=null;
			vo2=memberDao.memberOne(vo.getUserid());//Ư�� ���̵�(1��)�� ���õ� ������ �� userid �� username �� ������ 
			session.setAttribute("userid", vo2.getUserid()); //������ �������� session�� �������
			session.setAttribute("username", vo2.getUsername());
			return "/member/main";
		}else{
			writer.println("<script type='text/javascript'>");
			writer.println("alert('���̵�/��й�ȣ�� Ȯ���� �ּ���.');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
			return "/member/login";
		}
		
	}//�α���
	
	
	@RequestMapping("/member/logout")
	public String memberLogout(HttpSession session){
		session.setAttribute("userid", null);
		session.setAttribute("username", null);
		return "member/main";
	}//�α׾ƿ� - ������ null�� ������ش�
	
	
	@RequestMapping("/member/join")
	public String memberForm(@ModelAttribute MemberVo vo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		if(vo.getUserid()==null){ 
			return "member/join";
		}else{
			int result = memberDao.insertMember(vo);
			
			if(result>0){
				writer.println("<script type='text/javascript'>");
				writer.println("alert('ȸ������ ó���� �Ϸ�Ǿ����ϴ�.');");
				writer.println("</script>");
				writer.flush();
				return "member/main";
			}else{
				System.out.println("error");
				writer.println("<script type='text/javascript'>");
				writer.println("alert('ȸ�� ��� �������� ������ �߻��߽��ϴ�. �ٽ� Ȯ�����ֽʽÿ�.');");
				writer.println("history.back();");
				writer.println("</script>");
				writer.flush();
				return "member/join";
			}
		}
	}//ȸ������
	
	
	@RequestMapping("/member/idchk")
	public String memberIdchk(String userid, Model model){
		int result2 = memberDao.idChk(userid);
		if(result2>0){
			model.addAttribute("message1", "�ߺ��� ���̵� �ֽ��ϴ�.");
			return "member/idchk";
		}else{
			model.addAttribute("message1", "��밡���� ���̵� �Դϴ�.");
			return "member/idchk";
		}
	}//ȸ������ �� ���̵�üũ
	
	
	@RequestMapping("/member/info")
	public void memberInfo(){
		
	}//���������� �̵�
	
	
	@RequestMapping("/member/modifyForm")
	public String modifyForm(@ModelAttribute MemberVo vo, Model model, HttpSession session){
		String userid = (String) session.getAttribute("userid");
		vo=memberDao.ViewInfo(userid);
		
		model.addAttribute("userid", vo.getUserid());
		model.addAttribute("username", vo.getUsername());
		model.addAttribute("userpw", vo.getUserpw());
		model.addAttribute("zipcode", vo.getZipcode());
		model.addAttribute("addr", vo.getAddr());
		model.addAttribute("addr2", vo.getAddr2());
		model.addAttribute("tel1", vo.getTel1());
		model.addAttribute("tel2", vo.getTel2());
		model.addAttribute("tel3", vo.getTel3());
		model.addAttribute("email1", vo.getEmail1());
		model.addAttribute("email2", vo.getEmail2());
		
		return "member/modifyForm";
	}//������������ Ŭ���� �������̵�
	

	@RequestMapping("/member/modify")
	public String memberModify(@ModelAttribute MemberVo vo, HttpServletRequest request, HttpServletResponse response) throws IOException{
		int result=0;
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		result=memberDao.updateMember(vo);
		if(result==1){
			writer.println("<script type='text/javascript'>");
			writer.println("alert('�����Ϸ�');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
			return "/member/modifyForm";
		}else{
			writer.println("<script type='text/javascript'>");
			writer.println("alert('���������� �ٽ� Ȯ�����ּ���.');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
			return "/member/modifyForm";
		}
	}//��������
	
	
	@RequestMapping("/member/leave")
	public String memberLeave(String userid, HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println(userid);
		memberDao.memberLeave(userid);
		
		session.setAttribute("userid", null);
		session.setAttribute("username", null);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script type='text/javascript'>");
		writer.println("alert('���������� ȸ��Ż���ϼ̽��ϴ�.');");
		writer.println("</script>");
		writer.flush();
		
		
		return "member/main";
	}
	
}
