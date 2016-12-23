package com.example.web03.cart.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web03.cart.model.dao.CartDao;
import com.example.web03.cart.model.dto.CartVo;
import com.example.web03.model.dto.MemberVo;

@Controller
public class CartController {

	@Inject
	CartDao cartDao;
	
	@RequestMapping("/cart/insert")
	public String insert(@ModelAttribute CartVo vo, HttpSession session){
		session.setAttribute("userid", "kim");
		String userid=(String)session.getAttribute("userid");
		System.out.println(userid);
		vo.setUserid(userid);
		cartDao.insert(vo);
		return "redirect:/product/list";
		// ���⼭ rediredct: �� �߿伺�� ���޾Ҵ�. 
		// product/product_list�� ���� �׳� product_list �������� �̵��Ѵ�. �̷��� db���� ���� �ҷ����� ���ϱ� ������ �ƹ��͵� �Ⱥ��δ�.
		// �׷��� ProductController�� �ִ� list�޼ҵ带 �����ر� ���� product/list �� ���. �׷��� �̰͵� ��ǻ�Ͱ� ���˾�ó�Դ´�.
		// redirect:/product/list�� ����ϴ� �������� ��Ʈ�ѷ� ���� list �޼ҵ尡 �����ߴ�.
		// redirect: �� �������� �ٸ� ������(jsp)�� �̵��ϴ� ���� �ƴ϶� � ��Ʈ�ѷ� ���� �޼ҵ带 ���� �� ����� ��������� ����ϴ� ���̴�.
	}
}






