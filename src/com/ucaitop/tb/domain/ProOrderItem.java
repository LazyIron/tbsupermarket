package com.ucaitop.tb.domain;


/**
 * 订单项表
 * @author AZTQ
 *
 */
public class ProOrderItem {
	
	
	private ProOrder proOrder; //订单对象
	private Product product;//订单商品对象
	private int buynum;//购买的数量

	
	
	
	
	public ProOrder getProOrder() {
		return proOrder;
	}
	public void setProOrder(ProOrder proOrder) {
		this.proOrder = proOrder;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	
	
}
