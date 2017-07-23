package com.vsii.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.vsii.entity.Food;
import com.vsii.entity.json.CustomResponseType;
import com.vsii.entity.json.FoodJSON;
import com.vsii.service.IFoodService;

@Controller
@RequestMapping(value = "foods")
public class FoodController {
	@Autowired
	private IFoodService foodService;

	@RequestMapping(value = "", params = { "food_id", "supplier_id" }, method = RequestMethod.GET)
	public ResponseEntity<?> getFoodById(@RequestParam("food_id") int foodId,
			@RequestParam("supplier_id") int supplierId) {
		Food food = foodService.getFoodById(foodId, supplierId);
		FoodJSON foodRes = new FoodJSON(food.getFoodId(), food.getFoodName(), food.getDescription(), food.getNewPrice(),
				food.getOldPrice(), food.getCreatedAt(), food.getUpdatedAt(), food.getSupplier().getSupplierId());
		CustomResponseType response = new CustomResponseType();
		response.setStatus("success");
		response.setData(foodRes);
		response.setError("");
		return new ResponseEntity<CustomResponseType>(response, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "{supplier_id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllFoods(@PathVariable("supplier_id") int supplierId) {
		List<Food> foods = foodService.getAllFoods(supplierId);
		List<FoodJSON> res = new ArrayList<>();
		if (foods.isEmpty()) {
			return new ResponseEntity<CustomResponseType>(new CustomResponseType("success", res, ""),
					HttpStatus.NO_CONTENT);
		} else {
			for (Food food : foods) {
				res.add(new FoodJSON(food.getFoodId(), food.getFoodName(), food.getDescription(), food.getNewPrice(),
						food.getOldPrice(), food.getCreatedAt(), food.getUpdatedAt(),
						food.getSupplier().getSupplierId()));
			}
			return new ResponseEntity<CustomResponseType>(new CustomResponseType("success", res, ""), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public ResponseEntity<Void> addUser(@RequestBody Food food, UriComponentsBuilder builder) {
		boolean flag = foodService.addFood(food);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("{id}").buildAndExpand(food.getFoodId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Food> updateUser(@RequestBody Food food) {
		int result = foodService.updateFood(food);
		if (result > 0)
			return new ResponseEntity<Food>(food, HttpStatus.OK);
		else
			return new ResponseEntity<Food>(food, HttpStatus.NOT_IMPLEMENTED);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		int result = foodService.deleteFood(id);
		if (result > 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}
}
