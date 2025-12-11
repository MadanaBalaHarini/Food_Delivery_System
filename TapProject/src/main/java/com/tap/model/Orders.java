package com.tap.model;

import java.util.Date;

public class Orders {
	private int orderid;
	private Date orderdate;
	private int restaurantid;
	private int userid;
	private double totalamount;
	private String paymentmethod;
	private String status;
	private String deliveryaddress;
	
	public Orders() {

	}
	
	public Orders(int orderid, Date orderdate, int restaurantid, int userid, double totalamount, String paymentmethod,
			String status, String deliveryaddress) {
		super();
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.restaurantid = restaurantid;
		this.userid = userid;
		this.totalamount = totalamount;
		this.paymentmethod = paymentmethod;
		this.status = status;
		this.deliveryaddress = deliveryaddress;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", orderdate=" + orderdate + ", restaurantid=" + restaurantid
				+ ", userid=" + userid + ", totalamount=" + totalamount + ", paymentmethod=" + paymentmethod
				+ ", status=" + status + ", deliveryaddress=" + deliveryaddress + "]";
	}
	
}
