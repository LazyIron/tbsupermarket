package com.ucaitop.tb.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucaitop.tb.domain.Product;

/**
 * 删除购物车内商品的应用
 */
@WebServlet("/DelCatPro")
public class DelCarPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DelCarPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("proid");
		//创建用户对象
		Product product = new Product();
		//给对象赋值
		product.setPro_id(id);
		//从session获取数据
		Map<Product,String> map = (Map<Product, String>) request.getSession().getAttribute("car");
		//之后将要删除的，在map集合中删除掉
		map.remove(product);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
