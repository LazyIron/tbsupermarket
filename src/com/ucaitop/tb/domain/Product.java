package com.ucaitop.tb.domain;
/**
 * @author AZTQ
 * 商品的实体类
 */
public class Product {
	
	
	private String pro_id;//商品id
	private String pro_name;//商品名字
	private double price;//商品价钱
	private String imgUrl;//图片的路径
	private String privilege;//特免信息
	private int arrival_time;//到达时间
	private int count;//商品数量
	private String evaluate;//商品默认的评论
	private String category;//种类信息
	private String weight;//商品重量
	
	//创建无参的构造方法
	public Product(){
		
	}
	
	
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public int getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(int arrival_time) {
		this.arrival_time = arrival_time;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [pro_id=" + pro_id + ", pro_name=" + pro_name + ", price=" + price + ", imgUrl=" + imgUrl
				+ ", privilege=" + privilege + ",  count=" + count + ",arrival_time=" + arrival_time + ", evaluate="
				+ evaluate + ", category=" + category + "]";
	}
	
	


}
