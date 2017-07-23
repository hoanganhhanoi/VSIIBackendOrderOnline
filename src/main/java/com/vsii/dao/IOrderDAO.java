package com.vsii.dao;

import java.util.Date;
import java.util.List;

import com.vsii.entity.Order;

public interface IOrderDAO {
	public List<Order> getAllOrders();
	public Order getOrder(int orderId);
	public List<Order> getOrderByUser(int userId);
	public List<Order> findOrderByDate(Date startDate, Date endDate);
	public boolean order(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(int orderId);
}
