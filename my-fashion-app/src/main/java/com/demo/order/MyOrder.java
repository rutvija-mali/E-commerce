package com.demo.order;

public class MyOrder {

	 private int myOrderId,userid;
	 public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	private String orderid;
	 private int amount;
	 private String paymentid;
	 private String receipt ,status;
	public int getMyOrderId() {
		return myOrderId;
	}
	public String getOrderid() {
		return orderid;
	}
	public int getAmount() {
		return amount;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public String getReceipt() {
		return receipt;
	}
	public String getStatus() {
		return status;
	}
	public void setMyOrderId(int myOrderId) {
		this.myOrderId = myOrderId;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
