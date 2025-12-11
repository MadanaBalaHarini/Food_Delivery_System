package com.tap.dao;

import java.util.List;

import com.tap.model.Orders;

public interface OrdersDAO {
	int addOrder(Orders order);
	Orders getOrder(int orderId);
	List<Orders> getAllorders();
	void updateOrder(Orders order);
	void deleteOrder(int orderId);
}
