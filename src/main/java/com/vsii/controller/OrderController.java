package com.vsii.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsii.entity.Order;
import com.vsii.entity.json.CustomResponseType;
import com.vsii.entity.json.OrderJSON;
import com.vsii.service.IOrderService;

@Controller
@RequestMapping(value = "orders")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@RequestMapping(value = "")
	public ResponseEntity<?> getAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		List<OrderJSON> res = new ArrayList<>();
		if (orders.isEmpty()) {
			return new ResponseEntity<CustomResponseType>(new CustomResponseType("success", res, ""),
					HttpStatus.NO_CONTENT);
		} else {
			for (Order order : orders) {
				res.add(new OrderJSON(order.getOrderId(), order.getOrderDate(), order.getDescription(),
						order.getQuantity(), order.getUpdatedAt(), order.getUser().getUserId(),
						order.getStatus().getStatusName(), order.getSupplier().getSupplierId()));
			}
			return new ResponseEntity<CustomResponseType>(new CustomResponseType("success", res, ""), HttpStatus.OK);
		}
	}
}
