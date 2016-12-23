package com.hb.mall1.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hb.mall1.member.model.dao.MemberDao;
import com.hb.mall1.member.model.dto.MemberVo;


@Controller
public class MailController {

	@Inject
	MemberDao memberDao;
	@Autowired
    private EmailSender emailSender;

	@RequestMapping("/member/ipfind")
	public String memberIpfind(@ModelAttribute MemberVo vo, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Email email = new Email();
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		if(vo.getUsername()==null){			
			return "/member/ipfind";
		}else {			
			model.addAttribute("dto", memberDao.ipFind(vo));
			if(memberDao.ipFind(vo)==null){
				writer.println("<script type='text/javascript'>");
				writer.println("alert('등록되지 않은 정보입니다. 다시 확인해주세요.');");
				writer.println("history.back();");
				writer.println("</script>");
				writer.flush();
				return "member/ipfind";
			}else{
				String userid = memberDao.ipFind(vo).getUserid();
				String userpw = memberDao.ipFind(vo).getUserpw();
				String e_mails = memberDao.ipFind(vo).getEmail1()+'@'+memberDao.ipFind(vo).getEmail2();
				
				email.setContent("아이디는 "+userid+" 입니다.");
				email.setContent("아이디는 "+userid+", 비밀번호는 "+userpw+" 입니다.");
	            email.setReciver(e_mails);
	            email.setSubject(userid+"님 비밀번호 찾기 메일입니다.");
	            emailSender.SendEmail(email);
				
	            writer.println("<script type='text/javascript'>");
				writer.println("alert('정상적으로 메일이 전송되었습니다.');");
				writer.println("</script>");
				writer.flush();
	            
				return "/member/main";
			}
		}
	}//ipfind
	
}

