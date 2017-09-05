package com.vsii.dao;

import java.util.List;

import com.vsii.entity.Order;
import com.vsii.entity.json.DOrderRequest;

public interface IOrderDAO {
	public List<Order> getAllOrders();
	public Order getOrderById(int orderId);
	public List<Order> getOrderByUser(int userId);
	public int createOrder(DOrderRequest order);
//	public List<Order> findOrderByDate(Date startDate, Date endDate);
	public boolean order(Order order);
//	public void updateOrder(Order order);
//	public void deleteOrder(int orderId);
}
