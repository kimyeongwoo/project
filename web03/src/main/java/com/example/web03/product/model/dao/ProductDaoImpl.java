package com.example.web03.product.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.web03.product.model.dto.ProductVo;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ProductVo> listProduct() {
		List<ProductVo> list1=new ArrayList<ProductVo>();
		try {
			list1=sqlSession.selectList("list_product");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	@Override
	public ProductVo detailProduct(int product_id) {
		
		return sqlSession.selectOne("detail_product", product_id);
	}

	@Override
	public void updateProduct(ProductVo vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int product_id) {
		// TODO Auto-generated method stub

	}

}
