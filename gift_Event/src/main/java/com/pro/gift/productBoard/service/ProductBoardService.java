package com.pro.gift.productBoard.service;

import java.util.List;

import com.pro.gift.productBoard.VO.ArticleVO;

public interface ProductBoardService {
	public List<ArticleVO> listArticles() throws Exception;
	public List<ArticleVO> pagingArticle(String startNO, String endNO) throws Exception;
}
