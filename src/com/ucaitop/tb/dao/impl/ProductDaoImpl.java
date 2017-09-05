package com.ucaitop.tb.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * 商品数据层接口的实现
 * 将工具类进行拓展，如果说用户访问的多了，程序是没有办法承载这么的用户的对象的
 * 所以就能过渡到一个数据库连接池的拓展，将连接池引入
 * 也可以尝试着拓展一下持久层框架。
 * 原生的jdbc能实现最快速的查询，但是编写代码太复杂，
 * hibernate查询的效率是最慢的，但是非常非常的方便
 * mybatis的查询效率要比hibernate要快，但是不是很麻烦
 */
import java.util.List;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import com.ucaitop.tb.dao.ProductDao;
import com.ucaitop.tb.domain.ProOrder;
import com.ucaitop.tb.domain.Produc;
import com.ucaitop.tb.domain.Product;
import com.ucaitop.tb.util.C3P0Util;
import com.ucaitop.tb.util.DBUtil;

public class ProductDaoImpl implements ProductDao {
	
	/**
	 * 通过jdbc，连接数据库，获得数据库中的数据
	 */
	@Override
	public List<Produc> selectProductByCategory(String category) {
		// TODO Auto-generated method stub
		//创建存储数据的List集合
		List<Produc> proList = new ArrayList<Produc>();
		//创建数据库的连接
		Connection conn = DBUtil.getConn();
		
		try {
			//创建操作数据库的对象
			PreparedStatement ps = conn.prepareStatement("select * from tb_product where category=?");			
			//将？占位符的值进行传递，这里的站位符的值需要从1开始
			ps.setString(1, category);
			//创建结果集对象
			ResultSet re = ps.executeQuery();
			//遍历结果集
			while(re.next()){
				//先创建接收数据的对象
				Produc produc = new Produc();
				//获取数据并存在对象中,根据我们想获取到的数据存入
//				String id =re.getString("proid");
//				String name=re.getString("proname");
//				int count = re.getInt("count");
//				String img = re.getString("imgUrl");//获取图片路径资源
//				double prc = re.getDouble("price");//获取价钱
				produc.setPro_id(re.getString("proid"));//获取id值
				produc.setPro_name(re.getString("proname"));//获取商品的名称
				produc.setCount(re.getInt("count"));//获取商品数量
				produc.setImgUrl(re.getString("imgUrl"));
				produc.setPrice(re.getDouble("price"));
				//将查到的多个数据进行封装存入集合
				proList.add(produc);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return proList;
	}
	/**
	 * 在数据库中找到数据的基本信息
	 */
	@Override
	public Produc selectProduct(String productId) {
		//创建一个对象接收数据 
		Produc produc = new Produc();
		//创建数据库的连接
		Connection conn = DBUtil.getConn();
		
		try {
			//创建操作数据库的对象
			PreparedStatement ps = conn.prepareStatement("select * from tb_product where proid=?");			
			//将？占位符的值进行传递，这里的站位符的值需要从1开始
			ps.setString(1, productId);
			//创建结果集对象
			ResultSet re = ps.executeQuery();
			//遍历结果集
			while(re.next()){
				//获取数据并存在对象中,根据我们想获取到的数据存入
				produc.setPro_id(re.getString("proid"));//获取id值
				produc.setPro_name(re.getString("proname"));//获取商品的名称
//				product.setArrival_time(re.getInt("arrival_time"));//获取到货时间
				produc.setCount(re.getInt("count"));//获取商品数量
				produc.setImgUrl(re.getString("imgUrl"));//获取图片路径资源			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produc;
	}
	/**
	 * 获取到商品全部的数据
	 * @throws SQLException 
	 */
	@Override
	public Product selectProductAll(String productId) throws SQLException {
		// TODO Auto-generated method stub
		//创建商品对象
		Product product = new Product();
		
		//创建连接对象，进行操作数据库
		QueryRunner qr = new QueryRunner(C3P0Util.getDatasourse());
		//根据需求选择相对应的方法来操作数据库
		product = qr.query("select * from tb_product where proid=?", new BeanHandler<Product>(Product.class),productId);
		return product;
	}
	@Override
	public void updateProCount(ProOrder proOrder) {
		// TODO Auto-generated method stub
		
	}

}
