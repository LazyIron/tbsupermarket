package com.ucaitop.tb.service.impl;

import com.ucaitop.tb.dao.ProOrderDao;
import com.ucaitop.tb.dao.ProOrderItemDao;
import com.ucaitop.tb.dao.ProductDao;
import com.ucaitop.tb.dao.impl.ProOrderDaoImpl;

import com.ucaitop.tb.dao.impl.ProOrderItemDaoImpl;
import com.ucaitop.tb.dao.impl.ProductDaoImpl;
import com.ucaitop.tb.domain.ProOrder;
import com.ucaitop.tb.domain.User;
import com.ucaitop.tb.service.ProOrderService;

public class ProOrderServiceImpl implements ProOrderService {
	//创建三个dao层对象，操作数据库，因为接下来要修改商品的数量，还有添加订单表以及订单项表
	private ProductDao pd = new ProductDaoImpl();
	private ProOrderDao pod = new ProOrderDaoImpl();
	private ProOrderItemDao  poid = new ProOrderItemDaoImpl();
	//提交订单的服务层方法，这里是直接提交就表示成功结算，不出现意外
	@Override
	public void addProOrder(ProOrder proOrder) {
		// TODO Auto-generated method stub
		//利用pd对象调用修改商品数量的方法
		pd.updateProCount(proOrder);
		//利用pod对象向dao层传入order对象，进行添加订单数据
		pod.insertProOrder(proOrder);
		// 利用poid对象向dao层传递数据
		poid.addProOrderItem(proOrder);
	}

	@Override
	public String getAllProOrder(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeProOrder(ProOrder proOrder) {
		// TODO Auto-generated method stub
		return false;
	}

}
