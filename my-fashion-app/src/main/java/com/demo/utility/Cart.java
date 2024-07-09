package com.demo.utility;

public class Cart {

	private int product_id;
	private int userId;
	private int qty;
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getProduct_id() {
		return product_id;
	}
	public int getUserId() {
		return userId;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
