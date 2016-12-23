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
		// 여기서 rediredct: 의 중요성을 깨달았다. 
		// product/product_list를 쓰면 그냥 product_list 페이지로 이동한다. 이러면 db에서 값을 불러오지 못하기 때문에 아무것도 안보인다.
		// 그래서 ProductController에 있는 list메소드를 실행해기 위해 product/list 를 썼다. 그러나 이것도 컴퓨터가 못알아처먹는다.
		// redirect:/product/list를 사용하니 그제서야 컨트롤러 안의 list 메소드가 동작했다.
		// redirect: 는 직빵으로 다른 페이지(jsp)로 이동하는 것이 아니라 어떤 컨트롤러 안의 메소드를 거쳐 그 결과를 보고싶을때 사용하는 것이다.
	}
}






