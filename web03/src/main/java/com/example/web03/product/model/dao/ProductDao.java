package com.example.web03.product.model.dao;

import java.util.List;

import com.example.web03.product.model.dto.ProductVo;

public interface ProductDao {
	List<ProductVo> listProduct();
	ProductVo detailProduct(int product_id);
	void updateProduct(ProductVo vo);
	void deleteProduct(int product_id);
}
