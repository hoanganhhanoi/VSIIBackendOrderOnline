package com.vsii.service;

import java.util.List;

import com.vsii.entity.json.SubOrderJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsii.dao.IOrderDAO;
import com.vsii.entity.Order;
import com.vsii.entity.json.DOrderRequest;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	private IOrderDAO orderDAO;

	@Override
	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	@Override
	public Order getOrderById(int orderId) {
		return orderDAO.getOrderById(orderId);
	}

	@Override
	public int createOrder(DOrderRequest order) {
		int rs = orderDAO.createOrder(order);
		if(rs > 0) 
			return 1;
		else 
			return 0;
	}

	@Override
	public int order(SubOrderJSON subOrder) {
		int rs = orderDAO.order(subOrder);
		if(rs > 0)
			return 1;
		else
			return 0;
	}

	@Override
	public int updateStateOrder(int orderId, int statusId) {
		int rs = orderDAO.updateStateOrder(orderId, statusId);
		if(rs > 0)
			return 1;
		else
			return 0;
	}

}
