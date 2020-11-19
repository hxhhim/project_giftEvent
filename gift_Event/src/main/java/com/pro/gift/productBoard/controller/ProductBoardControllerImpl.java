package com.pro.gift.productBoard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pro.gift.productBoard.service.ProductBoardService;

@Controller("productBoardController")
public class ProductBoardControllerImpl implements ProductBoardController {
	@Autowired
	private ProductBoardService productBoardService;
		
	@Override
	@RequestMapping(value="/productBoard/listProductArticles.do",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List articlesList = productBoardService.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		System.out.println(articlesList);
		return mav;
	}

}
