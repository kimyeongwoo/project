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
		
	}//메인페이지 이동
	
	
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
			writer.println("alert('정상적으로 로그인 되었습니다.');");
			writer.println("</script>");
			writer.flush();
			MemberVo vo2=null;
			vo2=memberDao.memberOne(vo.getUserid());//특정 아이디(1명)에 관련된 정보들 중 userid 와 username 만 가져옴 
			session.setAttribute("userid", vo2.getUserid()); //위에서 뽑은것을 session에 집어넣음
			session.setAttribute("username", vo2.getUsername());
			return "/member/main";
		}else{
			writer.println("<script type='text/javascript'>");
			writer.println("alert('아이디/비밀번호를 확인해 주세요.');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
			return "/member/login";
		}
		
	}//로그인
	
	
	@RequestMapping("/member/logout")
	public String memberLogout(HttpSession session){
		session.setAttribute("userid", null);
		session.setAttribute("username", null);
		return "member/main";
	}//로그아웃 - 세션을 null로 만들어준다
	
	
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
				writer.println("alert('회원가입 처리가 완료되었습니다.');");
				writer.println("</script>");
				writer.flush();
				return "member/main";
			}else{
				System.out.println("error");
				writer.println("<script type='text/javascript'>");
				writer.println("alert('회원 등록 과정에서 문제가 발생했습니다. 다시 확인해주십시오.');");
				writer.println("history.back();");
				writer.println("</script>");
				writer.flush();
				return "member/join";
			}
		}
	}//회원가입
	
	
	@RequestMapping("/member/idchk")
	public String memberIdchk(String userid, Model model){
		int result2 = memberDao.idChk(userid);
		if(result2>0){
			model.addAttribute("message1", "중복된 아이디가 있습니다.");
			return "member/idchk";
		}else{
			model.addAttribute("message1", "사용가능한 아이디 입니다.");
			return "member/idchk";
		}
	}//회원가입 중 아이디체크
	
	
	@RequestMapping("/member/info")
	public void memberInfo(){
		
	}//마이페이지 이동
	
	
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
	}//개인정보변경 클릭시 수정폼이동
	

	@RequestMapping("/member/modify")
	public String memberModify(@ModelAttribute MemberVo vo, HttpServletRequest request, HttpServletResponse response) throws IOException{
		int result=0;
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		result=memberDao.updateMember(vo);
		if(result==1){
			writer.println("<script type='text/javascript'>");
			writer.println("alert('수정완료');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
			return "/member/modifyForm";
		}else{
			writer.println("<script type='text/javascript'>");
			writer.println("alert('수정사항을 다시 확인해주세요.');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
			return "/member/modifyForm";
		}
	}//수정진행
	
	
	@RequestMapping("/member/leave")
	public String memberLeave(String userid, HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println(userid);
		memberDao.memberLeave(userid);
		
		session.setAttribute("userid", null);
		session.setAttribute("username", null);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script type='text/javascript'>");
		writer.println("alert('정상적으로 회원탈퇴하셨습니다.');");
		writer.println("</script>");
		writer.flush();
		
		
		return "member/main";
	}
	
}
