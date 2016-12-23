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
//		sqlSession.insert("cart.insert", vo); ������ mapper�� �������� ������ mapper�̸��� �������ְ� ������ ("mapper�̸�.����", sql���� ���� ����); ����Ѵ� 
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
