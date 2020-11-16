package com.pro.gift.product.service;

import java.util.List;
import java.util.Map;

import com.pro.gift.product.VO.productVO;

public interface productService {
	public List<productVO> listproduct() throws Exception;
	public void addNewProduct(Map productMap)throws Exception;
	
}
