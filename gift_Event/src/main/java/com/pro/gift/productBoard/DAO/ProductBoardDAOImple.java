package com.pro.gift.productBoard.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.pro.gift.productBoard.VO.ArticleVO;

@Repository("ProductBoardDAO")
public class ProductBoardDAOImple implements ProductBoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllArticlesList() throws DataAccessException {
		List<ArticleVO> articlesList = sqlSession.selectList("mapper.productBoard.selectAllArticlesList");
		return articlesList;
	}
	@Override
	public List selectPagingArticlesList(String startNO, String endNO) throws DataAccessException{
		Map<String,String> startEndNum = new HashMap<String,String>();
		startEndNum.put("startNO",startNO);
		startEndNum.put("endNO",endNO);
		
		List<ArticleVO> selectPagingArticlesList = sqlSession.selectList("mapper.productBoard.selectPagingArticlesList",startEndNum);
		return selectPagingArticlesList;
	}

}
