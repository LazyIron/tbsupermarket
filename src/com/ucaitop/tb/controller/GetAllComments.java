package com.ucaitop.tb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucaitop.tb.service.CommentService;
import com.ucaitop.tb.service.impl.CommentServiceImpl;
/**
 * 获取该商品的全部评论
 * @author AZTQ
 *
 */
@WebServlet("/GetAllComments")
public class GetAllComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GetAllComments() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//修改编码
		
		
		
		//获取请求的动作
		String comm = request.getParameter("productId");
		
		//创建一个服务层的对象
		CommentService cs = new CommentServiceImpl();
		
		//调用查找所有评论的方法
		String comments = cs.findComments(comm);
		
		//将获取到的所有信息返回到页面上
		response.getWriter().print(comments);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
