package com.pro.gift.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pro.gift.product.VO.productVO;
import com.pro.gift.product.service.productService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.SeleniumTest;

@Controller("productController")
public class productControllerImpl implements productController {
	
	@Autowired
	private productService productService;
	@Autowired
	private productVO productVO;
	
	public static List<productVO> plist;
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe";
	
	@Override
	public ModelAndView listproduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/product/addNewProduct.do")
	public ResponseEntity addNewProduct(HttpServletRequest request,  HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		Map<String, Object> productMap = new HashMap<String,Object>();
		getproduct();
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		for(productVO pVO : plist) {
			String brand = pVO.getBrand();
			String pcode = pVO.getPcode();
			String price = pVO.getPrice();
			String pname = pVO.getPname();
			System.out.println(pname);
			String event = pVO.getEvent();
			String creationDate = pVO.getCreationDate();
			String eventMonth = pVO.getEventMonth();
			String imageFileName = pVO.getImageFileName();
			String item = pVO.getItem();
			System.out.println(pVO);
			
			productMap.put("brand", brand);
			productMap.put("pcode", pcode);
			productMap.put("price", price);
			productMap.put("pname", pname);
			productMap.put("event", event);
			productMap.put("imageFileName", imageFileName);
			productMap.put("item", item);
			productMap.put("creationDate",creationDate);
			productMap.put("eventMonth", eventMonth);
			System.out.println("map"+productMap);
			
			productService.addNewProduct(productMap);
			
		}
		
		return null;
	}
	
	
	public void getproduct(){
	SeleniumTest selTest = new SeleniumTest();
	 plist = selTest.crawl(WEB_DRIVER_ID,WEB_DRIVER_PATH);
	
	}
}
