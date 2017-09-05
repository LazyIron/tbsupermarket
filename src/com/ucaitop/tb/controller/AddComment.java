package com.ucaitop.tb.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucaitop.tb.domain.Comment;
import com.ucaitop.tb.service.CommentService;
import com.ucaitop.tb.service.impl.CommentServiceImpl;
import com.ucaitop.tb.util.Message;

/**
 * 添加一条评论
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddComment() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//修改编码
		
		
		//获取传递的参数
		String productId = request.getParameter("productId");
		String userId = request.getParameter("userId");
		String commentM = request.getParameter("comment");
		String strdate = request.getParameter("date");
		//将获取的时间数据转换成Date格式！
		SimpleDateFormat sdf  =   new  SimpleDateFormat( " yyyy-MM-dd" ); 
		Date comDate = null;
		try {
			 comDate=sdf.parse(strdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//创建一个服务层对象
		CommentService cs = new CommentServiceImpl();
		
		//调用一其中添加评论的方法
		cs.addComment(commentM, userId, productId,comDate);
		
		//添加成功返回一个成功的信息
		response.getWriter().print(Message.getSuccse());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
