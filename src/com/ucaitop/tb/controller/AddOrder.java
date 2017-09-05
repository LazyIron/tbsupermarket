package com.ucaitop.tb.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Array;
import com.ucaitop.tb.domain.ProOrder;
import com.ucaitop.tb.domain.ProOrderItem;
import com.ucaitop.tb.domain.Product;
import com.ucaitop.tb.domain.User;
import com.ucaitop.tb.service.ProOrderService;
import com.ucaitop.tb.service.impl.ProOrderServiceImpl;
import com.ucaitop.tb.util.UUIDUtil;

/**
 * 订单的添加功能
 */
@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddOrder() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到session对象，
		HttpSession session = request.getSession();
		//从session中获取购物车信息以及user对象
		User user= (User) session.getAttribute("user");
		Map<Product,String> map = (Map<Product, String>) session.getAttribute("car");
		//创建订单对象
		ProOrder proOrder = new ProOrder();
		//将购物车信息都遍历出来，并找到相对应的信息！
		proOrder.setId(UUIDUtil.getUUID());
		//将用户信息放入订单
		proOrder.setUser(user);
		//将其他信息仿佛订单对象中
		
		/**
		 * 	private double money; // 订单总价
			private String receiverAddress; // 收货人地址
			private String receiverName; // 收货人姓名
			private String receiverPhone; // 收货人电话
			private int paystate; // 订单状态
			private Date ordertime; // 下单时间
		 */
		String mon = request.getParameter("money");
		//将总价钱转换为double类型
		double money = Double.parseDouble(mon);
		String receiverAddress = request.getParameter("re_add");
		String reName = request.getParameter("re_name");
		String reTele = request.getParameter("re_tele");
		String orderTime = request.getParameter("on_time");
		//将时间转换成标准格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date orderDate = null;
		try {
			orderDate = (Date) sdf.parse(orderTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//然后将数据封装到order对象中
		proOrder.setMoney(money);
		proOrder.setReceiverAddress(receiverAddress);
		proOrder.setReceiverName(reName);
		proOrder.setReceiverPhone(reTele);
		proOrder.setOrdertime(orderDate);
		//创建订单项集合
		List<ProOrderItem> itemList = new ArrayList<ProOrderItem>();
		//将购物车中的东西获取出来添加在订单中！
		for(Product product:map.keySet()){
			//创建订单项对象
			ProOrderItem proOrderItem = new ProOrderItem();
			//将得到的信息放入proOrderItem
			proOrderItem.setProduct(product);
			proOrderItem.setProOrder(proOrder);
			proOrderItem.setBuynum(Integer.parseInt(map.get(product)));
			//将订单项集合加入到集合中
			itemList.add(proOrderItem);
		}
		//给订单添加订单列表信息
		proOrder.setOrderItems(itemList);
		//创建服务层对象
		ProOrderService pos = new ProOrderServiceImpl();
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
