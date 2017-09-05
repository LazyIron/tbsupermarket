package com.ucaitop.tb.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.ucaitop.tb.dao.ProductDao;
import com.ucaitop.tb.dao.impl.ProductDaoImpl;
import com.ucaitop.tb.domain.Produc;
import com.ucaitop.tb.domain.Product;
import com.ucaitop.tb.service.ProductService;
import com.ucaitop.tb.util.GetGson;
/**
 * 商品服务层接口的实现
 * @author AZTQ
 *
 */
public class ProductServiceImpl implements ProductService {
	//将dao层的对象进行实例化
	ProductDao pd = new ProductDaoImpl();
	
	/**
	 * 根据种类信息获取数据的方法
	 */
	@Override
	public String findProductByCategory(String category) {
		
		//根据本服务层的方法，调用持久层方法
		List<Produc> proList = pd.selectProductByCategory(category);
		
		//将获取到的数据转换成json数据
		String proListJson = GetGson.getJson(proList);
		
		//将获取的json数据返回到控制层
		return proListJson;
	}
	/**
	 * 根据id找到基本信息的方法
	 */
	@Override
	public String findProduct(String productId) {
		// TODO Auto-generated method stub
		//通过id找到对应id的商品的基本信息
		Produc produc = pd.selectProduct(productId);
		//将此对象的信息转换信息
		String projson = GetGson.getJson(produc);
		//将的到的信息转换成json数据
		return projson;
	}
	/**
	 * 根据id找到商品详细信息的方法
	 */
	@Override
	public String findProductAll(String productId) {
		// TODO Auto-generated method stub
		
		//操作持久层对象调用方法，获得一个全参的对象
		Product product = null;
		try {
			product = pd.selectProductAll(productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//将对象数据转换成json
		String proJson = getJson(product);
		
		//将转换好的数据返回到controller
		return proJson;
	}
	/**
	 * 根据id找到详细信息并且返回对象
	 */
	@Override
	public Product findProductById(String proid) {

		//操作持久层对象调用方法，获得一个全参的对象
		Product product = null;
		try {
			product = pd.selectProductAll(proid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回找到的对象信息
		return product;
	}

	
//	#####################################################
	
	//使用google开源的gson方法 可以在这里将这个方法进行提取，
	//以后都会有json数据的返回，所以需要用到这个数据的转换，可以创建一个json数据的工具类
	private String getJson(List<Product> proList){
		//创建一个Gson对象
		Gson gson = new Gson();
		//将集合或者对象用gson对象中的toJson方法转换成json数据
		String proListJson = gson.toJson(proList);
		//将转换好的字符串返回到方法中！得到json数据
		return proListJson;
	}
	/**
	 * 将对象的数据转成json格式
	 */
	private  String getJson(Product product){
		//创建一个Gson对象
		Gson gson = new Gson();
		
		//将传入的参数转换成json数据
		String proJson = gson.toJson(product);
		
		//将得得到的json数据返回到控制层
		return proJson;
	}
	
}
