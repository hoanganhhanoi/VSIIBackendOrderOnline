package com.vsii.dao;

import java.util.List;

import com.vsii.entity.Order;
import com.vsii.entity.json.DOrderRequest;
import com.vsii.entity.json.SubOrderJSON;

public interface IOrderDAO {
	public List<Order> getAllOrders();
	public Order getOrderById(int orderId);
	public List<Order> getOrderByUser(int userId);
	public int createOrder(DOrderRequest order);
//	public List<Order> findOrderByDate(Date startDate, Date endDate);
	public int order(SubOrderJSON subOrder);
	public int updateOrder(Order order);
	public int updateStateOrder(int orderId, int statusId);
//	public void deleteOrder(int orderId);
}
