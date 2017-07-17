package com.vsii.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.vsii.entity.Food;
import com.vsii.service.IFoodService;

@Controller
@RequestMapping("foods")
public class FoodController {
	@Autowired
	private IFoodService foodService;
	
	@GetMapping("{id}")
	public ResponseEntity<Food> getUserById(@PathVariable("id") Long id) {
		Food food = foodService.getFoodById(id);
		return new ResponseEntity<Food>(food, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("")
	public ResponseEntity<List<Food>> getAllFoods() {
		List<Food> foods = foodService.getAllFoods();
		if (foods.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Food>>(foods, HttpStatus.OK);
		}
	}

	@RequestMapping(value="", method = RequestMethod.POST, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
	public ResponseEntity<Void> addUser(@RequestBody Food food, UriComponentsBuilder builder) {
		boolean flag = foodService.addFood(food);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("{id}").buildAndExpand(food.getFoodId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<Food> updateUser(@RequestBody Food food) {
		foodService.updateFood(food);
		return new ResponseEntity<Food>(food, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		foodService.deleteFood(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
