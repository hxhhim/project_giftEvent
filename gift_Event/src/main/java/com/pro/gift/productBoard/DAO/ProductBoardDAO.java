package com.pro.gift.productBoard.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ProductBoardDAO {
	public List selectAllArticlesList() throws DataAccessException;
	public List selectPagingArticlesList(String startNO, String endNO) throws DataAccessException;
}
