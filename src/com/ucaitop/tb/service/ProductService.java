package com.ucaitop.tb.service;

import java.util.List;

import com.ucaitop.tb.domain.Product;

/**
 * 关于商品的接口
 * @author AZTQ
 * 
 */
public interface ProductService {
	/**
	 * 得到对应种类的商品,返回对应的字符串
	 */
	String findProductByCategory(String category);
	
	/**
	 * 查找对应商品的基本信息信息
	 */
	String findProduct(String productId);
	
	/**
	 * 查找对应商品的全部信息
	 */
	String findProductAll(String productId);
	
	/**
	 * 查找对应商品的全部信息
	 */
	Product findProductById(String proid);
}
