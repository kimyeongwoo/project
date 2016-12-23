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
	public void getTime(Model model){  //return(돌아갈 페이지 지정)이 없고 type가 void일 경우, 돌아갈 페이지는 requestmapping 경로로 지정된다
		String time = memberDao.getTime();
		model.addAttribute("time", time);
	}
	
	// http://localhost:8080/web03/member/memberInsert
	@RequestMapping("/member/memberInsert")
	public String memberForm(@ModelAttribute MemberVo vo, Model model, HttpSession session) throws Exception{
		if(vo.getUserid()==null){ //memberForm.jsp에 입력한 값이 없으면 
			return "member/memberForm"; //  member폴더안의 memberForm.jsp로 페이지이동
		}else{//입력했을때
			//memberForm.jsp에서 입력한 값이 vo에 저장된 상태
			int result = memberDao.insertMember(vo);
			if(result>0){  //성공햇을때
				//세션에 사용자의 정보 저장
				session.setAttribute("userid", vo.getUserid());
				session.setAttribute("username", vo.getUsername());
				model.addAttribute("message", "회원가입 처리가 완료되었습니다.");
				return "member/main"; //main.jsp로 이동
			}else{  //실패했을때
				System.out.println("error");
				model.addAttribute("message", "회원 등록 과정에서 에러가 발생했습니다.");
				return "member/memberForm";//memberForm.jsp로 이동
			}
		}
	}
	
	
	@RequestMapping("/member/memberList")
	public void memberList(Model model){
		
		model.addAttribute("list", memberDao.memberList());//모델안에 list라는 변수명으로 Dao에서 뽑아온 데이터들을 저장
		//위에서 지정해준 list의 경우 member폴더안의 memberList.jsp 에서만 쓰인다
	}
	
	@RequestMapping("/member/memberInfo")
	public void memberInfo(String userid, Model model){
		model.addAttribute("dto", memberDao.memberInfo(userid));
	}
	
	@RequestMapping("/member/memberUpdate")
	public String memberUpdate(@ModelAttribute MemberVo vo, Model model){  //폼에 입력한 데이터들은 ModelAttribute에 저장됨
		//비밀번호가 정확한지 확인
		boolean result = memberDao.pwdCheck(vo.getUserid(), vo.getUserpw());
		if(result){
			//비번이 맞으면 update를 통해 리스트로 이동
			memberDao.updateInfo(vo);
			//redirect:/ - 서블릿(컨트롤러 호출)
			//jsp페이지로 갈때는 redirect:/를 안쓴다
			
			//번외 -  /member -> 루트 디렉토리 기준 /member
			//         member -> 현재 디렉토리 기준  member/member
			return "redirect:/member/memberList";
		}else {
			//비번이 틀리면 memberInfo로 되돌아감
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			//근데 위의 message가 수행이 될 경우 input 안의 값들이 다 날아간다.
			//그래서 다음과 같이 회원정보 객체를 저장
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
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("dto", vo);
			return "/member/memberInfo";
		}
	}
	
	

}
