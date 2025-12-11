package com.tap.model;

public class OrderItems {
    private int orderitemid;
    private int orderid;
    private int quantity;
    private String itemname;
    private int menuid;
    private double totalprice;
    
	public OrderItems() {
	}

	

//	public OrderItems( int orderid, int quantity, int menuid, double totalprice) {
//		super();
//		this.orderid = orderid;
//		this.quantity = quantity;
//		this.menuid = menuid;
//		this.totalprice = totalprice;
//	}
	public OrderItems(int orderitemid,int orderid,String itemname,int menuid,double totalprice) {
		this.orderitemid=orderitemid;
		this.orderid=orderid;
		this.itemname=itemname;
		this.menuid=menuid;
		this.totalprice=totalprice;
	}


	public OrderItems( int orderid,int orderitemid,int quantity, double totalprice) {
		super();
	
		this.orderid = orderid;
		this.orderitemid = orderitemid;
		this.quantity = quantity;
		this.totalprice = totalprice;
	}
	
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}

	public int getQuantity() {
		return quantity;
	}
	public int getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "OrderItems [orderitemid=" + orderitemid + ", orderid=" + orderid + ", itemname=" + itemname
				+ ", menuid=" + menuid + ", totalprice=" + totalprice + "]";
	}


    
    
}
