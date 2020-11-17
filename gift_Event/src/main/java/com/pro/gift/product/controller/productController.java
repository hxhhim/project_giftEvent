package com.pro.gift.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface productController {
	
	public ModelAndView listproduct(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	public ResponseEntity addNewProduct(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
