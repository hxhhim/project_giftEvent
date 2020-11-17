package com.pro.gift.product.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("productDAO")
public class productDAOImpl implements productDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllProductList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertNewProduct(Map productMap) throws DataAccessException {
		System.out.println("dao"+productMap);
		sqlSession.insert("mapper.product.insertNewProduct", productMap);
		
	}

}
