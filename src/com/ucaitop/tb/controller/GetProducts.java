package com.ucaitop.tb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucaitop.tb.domain.Product;
import com.ucaitop.tb.service.ProductService;
import com.ucaitop.tb.service.impl.ProductServiceImpl;

/**
 * 获取到当前种类的所有数据
 */
@WebServlet("/GetProducts")
public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetProducts() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        //服务器返回类型设置为json格式  
        response.setContentType("application/json; charset=utf-8");  
        //清缓存  
        response.setHeader("pragma", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
		//设置编码
		request.setCharacterEncoding("utf-8");
		
		//获取传递的种类信息
		String category = request.getParameter("classify");
		System.out.println(category);
		//创建服务层对象
		ProductService ps = new ProductServiceImpl();
		

        //服务器响应  
        PrintWriter out = response.getWriter();
		//调用查找多个商品的方法
		String proList = ps.findProductByCategory(category);
		
		//将获取到的信息返回到页面上
		out.print(proList);
		
		System.out.println(proList);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
