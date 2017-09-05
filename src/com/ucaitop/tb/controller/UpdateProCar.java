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
 * 修改购物车中信息
 * @author AZTQ
 *
 */
@WebServlet("/UpdateProCar")
public class UpdateProCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateProCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("proid");
		String num = request.getParameter("num");
		
		Product product = new Product();
		product.setPro_id(id);
		
		Map<Product,String> map = (Map<Product, String>) request.getSession().getAttribute("car");
		//如果减到0的话将这本书删除	
		if("0".equals(num))
			map.remove(product);
		//判断集合中是否还存在这本书！
		if(map.containsKey(product))
		      map.put(product, num);
		//之后执行刷新功能
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
