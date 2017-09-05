package com.vsii.service;

import java.util.List;

import com.vsii.entity.Order;
import com.vsii.entity.SubOrder;
import com.vsii.entity.json.DOrderRequest;

public interface IOrderService {
	public List<Order> getAllOrders();
	public Order getOrderById(int orderId);
	public int createOrder(DOrderRequest order);
	public int order(SubOrder subOrder);
}
