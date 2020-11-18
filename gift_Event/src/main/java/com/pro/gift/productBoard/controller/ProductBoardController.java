package com.pro.gift.productBoard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface ProductBoardController {
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
