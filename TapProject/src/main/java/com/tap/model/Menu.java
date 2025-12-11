package com.tap.model;

public class Menu {
	private int menuid;
	private String menuname;
	private double price;
	private boolean isavailable;
	private String description;
	private String imageurl;
	private int restaurantid;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(int menuid, String menuname, double price, boolean isavailable, String description, String imageurl,
			int restaurantid) {
		super();
		this.menuid = menuid;
		this.menuname = menuname;
		this.price = price;
		this.isavailable = isavailable;
		this.description = description;
		this.imageurl = imageurl;
		this.restaurantid = restaurantid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getIsavailable() {
		return isavailable;
	}
	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", menuname=" + menuname + ", price=" + price + ", isavailable=" + isavailable
				+ ", description=" + description + ", imageurl=" + imageurl + ", restaurantid=" + restaurantid + "]";
	}
	
}
