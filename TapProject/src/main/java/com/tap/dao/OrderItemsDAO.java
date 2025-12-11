package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItems;

public interface OrderItemsDAO {
	void addOrderItem(OrderItems orderitem);
	OrderItems getOrderItems(int orderitemid);
	List<OrderItems> getAllOrderItems();
	void updateOrderItem(OrderItems orderitem);
	void deleteOrderitem(int orderitemid);
}
