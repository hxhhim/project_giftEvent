package com.pro.gift.productBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.gift.productBoard.DAO.ProductBoardDAO;
import com.pro.gift.productBoard.VO.ArticleVO;

@Service("ProductBoardService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductBoardServiceImpl implements ProductBoardService {
	@Autowired
	ProductBoardDAO productBoardDAO;
	
	@Override
	public List<ArticleVO> listArticles() throws Exception {
		List<ArticleVO> articlesList = productBoardDAO.selectAllArticlesList();
		return articlesList;
	}
	@Override
	public List<ArticleVO> pagingArticle(String startNO, String endNO) throws Exception{
		List<ArticleVO> pagingArticleList = productBoardDAO.selectPagingArticlesList(startNO,endNO);
		return pagingArticleList;
	}

}
