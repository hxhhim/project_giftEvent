package com.pro.gift.productBoard.DAO;

import java.util.List;

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
		List<ArticleVO> articlesList = articlesList = sqlSession.selectList("mapper.productBoard.selectAllArticlesList");
		return null;
	}

}
