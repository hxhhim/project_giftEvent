package com.pro.gift.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.gift.product.DAO.productDAO;
import com.pro.gift.product.VO.productVO;

@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class productServiceImpl implements productService {
	@Autowired
	private productDAO productDAO;
	
	@Override
	public List<productVO> listproduct() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewProduct(Map productMap) throws Exception {
		System.out.println("service"+productMap);
		productDAO.insertNewProduct(productMap);

	}

}
