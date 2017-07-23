package com.vsii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsii.dao.IOrderDAO;
import com.vsii.entity.Order;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	private IOrderDAO orderDAO;

	@Override
	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}
	
	
}
