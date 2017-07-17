package com.vsii.dao.impl;

import java.util.Date;
import java.util.List;

import com.vsii.dao.IOrderDAO;
import com.vsii.entity.Order;

public class OrderDAO implements IOrderDAO {

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrderByUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findOrderByDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean order(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(long orderId) {
		// TODO Auto-generated method stub
		
	}
	
}
