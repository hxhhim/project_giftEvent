package com.pro.gift.product.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface productDAO {
	public List selectAllProductList()throws DataAccessException;
	public void insertNewProduct(Map productMap)throws DataAccessException;
}
