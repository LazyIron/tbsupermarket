package com.ucaitop.tb.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.ucaitop.tb.domain.Product;
import com.ucaitop.tb.domain.User;
import com.ucaitop.tb.service.ProductService;
import com.ucaitop.tb.service.impl.ProductServiceImpl;

/**
 * 向购物车添加商品的应用
 */
@WebServlet("/AddProCat")
public class AddProCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddProCar() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取到传过来的数据
		String proid = request.getParameter("pro_id");//获取物品id
		//从后台获取到商品
		ProductService ps = new ProductServiceImpl();
		//通过id获取商品信息
		Product product = ps.findProductById(proid);
		//创建服务器中的session
		HttpSession session = request.getSession();
		//从session中获取到用户


         User user = (User)session .getAttribute("user");
		    //判断是否有用户登录
		    if(user==null){
			//返回错误的提示，转到登录页面

		}


		//判断session中是否有购物车
		Map<Product,String> carMap = (Map<Product, String>) session.getAttribute("shoppingcar");
		int num = 1;
		if(carMap==null){
			//创建购物车对象，也就相当于一个map集合
			carMap= new HashMap<Product,String>();
		}
		if(carMap.containsKey(product)){
			num = Integer.parseInt(carMap.get(product))+1;
		}
		//将新的购物车信息更新
		carMap.put(product, num+"");
		
		//将更新好的购物车，更新到session中
		session.setAttribute("che", carMap);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
