package com.example.web03.cart.model.dao;

import java.util.List;

import com.example.web03.cart.model.dto.CartVo;

public interface CartDao {
	public void insert(CartVo vo);
	List<CartVo> listCart(String userid);
	void delete(int cart_id);
	void update(int cart_id);
}
