package com.ucaitop.tb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucaitop.tb.service.ProductService;
import com.ucaitop.tb.service.impl.ProductServiceImpl;

/**
 * 获取商品的全部信息
 */
@WebServlet("/GetProductAll")
public class GetProductAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetProductAll() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码

		//获取点击传递的信息
		String product = request.getParameter("productId");
		//创建服务层对象
		ProductService ps = new ProductServiceImpl();
		//调用服务层方法
		String proAll = ps.findProductAll(product);
		//将信息返回到前端
		response.getWriter().print(proAll);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
