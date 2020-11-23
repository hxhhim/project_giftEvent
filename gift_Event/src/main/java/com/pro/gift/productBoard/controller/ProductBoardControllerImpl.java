package com.pro.gift.productBoard.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pro.gift.productBoard.VO.ArticleVO;
import com.pro.gift.productBoard.service.ProductBoardService;

@RestController
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
	
	
	@RequestMapping(value="/productBoard/selectPagingArticlesList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ArticleVO> selectPagingArticlesList(@RequestBody Map num, HttpServletRequest request, HttpServletResponse response)throws Exception{
				
		String startNO = Integer.toString((Integer)num.get("startNum"));
		String endNO = Integer.toString((Integer)num.get("endNum"));
				
		List selpagingArticleList = productBoardService.pagingArticle(startNO,endNO);
		return selpagingArticleList;
	}

}
