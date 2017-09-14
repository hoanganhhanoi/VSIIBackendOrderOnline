package com.vsii.service;

import java.util.List;

import com.vsii.entity.Order;
import com.vsii.entity.json.DOrderRequest;
import com.vsii.entity.json.SubOrderJSON;

public interface IOrderService {
	public List<Order> getAllOrders();
	public Order getOrderById(int orderId);
	public int createOrder(DOrderRequest order);
	public int order(SubOrderJSON subOrder);
	public int updateStateOrder(int orderId, int statusId);
}
