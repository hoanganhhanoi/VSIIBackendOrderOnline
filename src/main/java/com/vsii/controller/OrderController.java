package com.vsii.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.vsii.entity.Food;
import com.vsii.entity.Order;
import com.vsii.entity.User;
import com.vsii.entity.json.CustomResponseType;
import com.vsii.entity.json.DOrderRequest;
import com.vsii.entity.json.OrderJSON;
import com.vsii.entity.json.UserJSON;
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
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
		Order order = orderService.getOrderById(id);
		OrderJSON res = new OrderJSON(order.getOrderId(), order.getOrderDate(), order.getDescription(),
				order.getQuantity(), order.getUpdatedAt(), order.getUser().getUserId(),
				order.getStatus().getStatusName(), order.getSupplier().getSupplierId());
		return new ResponseEntity<CustomResponseType>(new CustomResponseType("success", res, ""), HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = { "application/json",
	"application/xml" }, produces = { "application/json", "application/xml" })
	public ResponseEntity<Void> createOrder(@RequestBody DOrderRequest order, UriComponentsBuilder builder) {
		int rs = orderService.createOrder(order);
		if(rs > 0)
			return new ResponseEntity<Void>(HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}
}
