package com.pro.gift.productBoard.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.pro.gift.productBoard.VO.ArticleVO;

public interface ProductBoardController {
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response)throws Exception;
	public List<ArticleVO> selectPagingArticlesList(@RequestBody Map num, HttpServletRequest request, HttpServletResponse response)throws Exception;
}
