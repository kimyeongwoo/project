package com.example.web03.cart.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.web03.cart.model.dto.CartVo;

@Repository
public class CartDaoImpl implements CartDao {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insert(CartVo vo) {
//		sqlSession.insert("cart.insert", vo); 원래는 mapper를 여러개로 나눠서 mapper이름을 지정해주고 저렇게 ("mapper이름.선언", sql문에 사용될 변수); 써야한다 
		sqlSession.insert("insert", vo);
	}

	@Override
	public List<CartVo> listCart(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int cart_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int cart_id) {
		// TODO Auto-generated method stub

	}

}
