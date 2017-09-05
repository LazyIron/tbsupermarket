package com.ucaitop.tb.domain;

public class Produc {
	private String pro_id;//商品id
	private String pro_name;//商品名字
	private double price;//商品价钱
	private String imgUrl;//图片的路径
	private int count;//商品数量
	
	//创建无参的构造方法
	public Produc(){
			
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Produc [pro_id=" + pro_id + ", pro_name=" + pro_name + ", price=" + price + ", imgUrl=" + imgUrl
				+ ", count=" + count + "]";
	}
	
	
	
}
