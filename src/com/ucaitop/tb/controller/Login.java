package com.ucaitop.tb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucaitop.tb.domain.User;
import com.ucaitop.tb.service.UserService;
import com.ucaitop.tb.service.impl.UserServiceImpl;
import com.ucaitop.tb.util.Message;
import com.ucaitop.tb.util.Validation;

/**
 * 判断登陆的servlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//设置请求的编码格式
//		request.setCharacterEncoding("utf-8");
//		//设置相应的编码格式
//		response.setContentType("text/html:charset=utf-8");
		
		//创建写入客户端对象
		PrintWriter out  = response.getWriter();
		//获取参数
		String tele = request.getParameter("user_phone");
		String pass = request.getParameter("user_pass_word");
		//判断用户名密码格式是否正确
		if(!Validation.isTelephone(tele)){
			//用户名格式错误
			out.print(Message.getError());
		}
		
		if(!Validation.isPassword(pass)){
			//密码格式错误
			out.print(Message.getError());
		}
				//创建服务层对象
				UserService us = new UserServiceImpl();
				//调用验证登陆的方法
				User user = us.findUser(tele, pass);
				//判断返回的对象是否为空
				if(user!=null){
					//找到匹配对象证明登陆成功返回一个值
					out.print(Message.getSuccse());;
					//将返回的user对象放到session中，方便后期的验证
					request.getSession().setAttribute("user", user);
					
				}else{
					//返回用户名密码错误
					out.print(Message.getError());
				}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
