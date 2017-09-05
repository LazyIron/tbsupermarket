package com.ucaitop.tb.dao;

import java.sql.SQLException;
import java.util.List;

import com.ucaitop.tb.domain.ProOrder;
import com.ucaitop.tb.domain.Produc;
import com.ucaitop.tb.domain.Product;

/**
 * 商品持久层接口
 * @author AZTQ
 *
 */
public interface ProductDao {
	/**
	 * 得到对应种类的商品
	 */
	List<Produc> selectProductByCategory(String category);
	
	/**
	 * 查找对应商品的基本信息信息
	 */
	Produc selectProduct(String productId);
	
	/**
	 * 查找对应商品的全部信息
	 */
	Product selectProductAll(String productId)throws SQLException;
	/**
	 * 修改商品数量
	 * @param proOrder
	 */
	void updateProCount(ProOrder proOrder);
}
