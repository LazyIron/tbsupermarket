package com.ucaitop.tb.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ucaitop.tb.domain.Product;


@WebServlet("/GetProCar")
public class GetProCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GetProCar() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从购物车中取数据先从请求中获取session
		HttpSession session = request.getSession();
		//从session中获取购物车
		Map<Product,String> carMap = (Map<Product, String>) session.getAttribute("car");
		//判断购物车中是否有物品
		if(carMap!=null){
			//购物车显示什么信息，从数据库中获取
			
			//将要展示的信息，编写成字符串，返回到页面中
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
