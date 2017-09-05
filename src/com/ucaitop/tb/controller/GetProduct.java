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
 * 获取单个商品详细信息的接口
 */
@WebServlet("/GetProduct")
public class GetProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码---之后结合过滤器进行编码的修改
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html:charset=utf-8");
		
		//获取值
		String productId = request.getParameter("pro_Id");
		//创建服务层对象
		ProductService ps = new ProductServiceImpl();
		
		//调用获取信息的方法
		String pro = ps.findProduct(productId);
		
		//将得到的信息返回在前端
		response.getWriter().write(pro);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
