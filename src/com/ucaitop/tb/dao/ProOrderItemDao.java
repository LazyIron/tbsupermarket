package com.ucaitop.tb.dao;

import com.ucaitop.tb.domain.ProOrder;

public interface ProOrderItemDao {
	/**
	 * 向订单项中传递order进行数据的交互
	 * @param proOrder
	 */
	void addProOrderItem(ProOrder proOrder);

}
