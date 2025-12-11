package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private  Map<Integer, CartItem> items ;
	
	public Cart() {
		this.items=new HashMap<>();
	}

	public Map<Integer, CartItem> getItems(){
		return items;
		
	}
	public void addItem(CartItem item) {
		
		int itemId=item.getId();
		if(items.containsKey(itemId))
		{
			CartItem existingItem=items.get(itemId);
			
			int newQua=item.getQuantity();
			int oldQua=existingItem.getQuantity();
			
			int sumQua=newQua+oldQua;
			
			existingItem.setQuantity(sumQua);
		}
		else
		{
			items.put(itemId, item);
		}
	}
	
	public void updateQuantity(int id, int quantity) {
		if(items.containsKey(id))
		{
			if(quantity <= 0)
			{
				items.remove(id);
			}
			else
			{
				items.get(id).setQuantity(quantity);
			}
		}
	}


	public void removeItem(int id) {
	    items.remove(id);
	}
	
	public double getTotalPrice() {
		return items.values().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
	}

	public int getMenuId() {
		
		return 0;
	}

}
