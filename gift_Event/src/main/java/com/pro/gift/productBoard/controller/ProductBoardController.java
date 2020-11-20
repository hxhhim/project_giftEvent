package com.pro.gift.productBoard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.pro.gift.productBoard.VO.ArticleVO;

public interface ProductBoardController {
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response)throws Exception;
	public List<ArticleVO> selectPagingArticlesList(String startNO, String endNO,HttpServletRequest request, HttpServletResponse response)throws Exception;
}
