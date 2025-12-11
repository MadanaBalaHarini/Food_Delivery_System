package com.tap.model;

public class Restaurant {

    private int restaurantid;
    private String restaurantname;
    private String address;
    private double rating;
    private String cuisine;
    private int deliverytime; 
    private boolean isactive;
    private String imageurl;
    private int adminuserid;
    
    

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Restaurant(int restaurantid, String restaurantname, String address, double rating, String cuisine,
			int deliverytime, boolean isactive, String imageurl, int adminuserid) {
		super();
		this.restaurantid = restaurantid;
		this.restaurantname = restaurantname;
		this.address = address;
		this.rating = rating;
		this.cuisine = cuisine;
		this.deliverytime = deliverytime;
		this.isactive = isactive;
		this.imageurl = imageurl;
		this.adminuserid = adminuserid;
	}



	public int getRestaurantid() {
		return restaurantid;
	}



	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}



	public String getRestaurantname() {
		return restaurantname;
	}



	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}



	public String getCuisine() {
		return cuisine;
	}



	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}



	public int getDeliverytime() {
		return deliverytime;
	}



	public void setDeliverytime(int deliverytime) {
		this.deliverytime = deliverytime;
	}



	public boolean getIsactive() {
		return isactive;
	}



	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}



	public String getImageurl() {
		return imageurl;
	}



	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}



	public int getAdminuserid() {
		return adminuserid;
	}



	public void setAdminuserid(int adminuserid) {
		this.adminuserid = adminuserid;
	}



	@Override
	public String toString() {
		return "restaurant [restaurantid=" + restaurantid + ", restaurantname=" + restaurantname + ", address="
				+ address + ", rating=" + rating + ", cuisine=" + cuisine + ", deliverytime=" + deliverytime
				+ ", isactive=" + isactive + ", imageurl=" + imageurl + ", adminuserid=" + adminuserid + "]";
	}

    
}
