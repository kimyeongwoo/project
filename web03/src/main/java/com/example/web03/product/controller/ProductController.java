package com.example.web03.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web03.product.model.dao.ProductDao;
import com.example.web03.product.model.dto.ProductVo;

@Controller
public class ProductController {
	@Inject
	ProductDao productDao;
	
	@RequestMapping("/product/list")
	public String list(Model model){
		List<ProductVo> list1=new ArrayList<ProductVo>();
		list1=productDao.listProduct();
		model.addAttribute("list", list1);
		
		return "product/product_list";
	}
	
	
	@RequestMapping("/product/detail/{product_id}")
	public String detail(@PathVariable("product_id")int product_id, Model model){
		
		model.addAttribute("vo", productDao.detailProduct(product_id));
		return "product/product_detail";
	}
	
	
}
