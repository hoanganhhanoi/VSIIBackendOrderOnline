package com.vsii.entity.json;

import java.util.List;

public class DOrderRequest {
	public int orderId;
	public String description;
	public int userId;
	public int status;
	public int supplierId;
	public List<Integer> detailOrder;
}
