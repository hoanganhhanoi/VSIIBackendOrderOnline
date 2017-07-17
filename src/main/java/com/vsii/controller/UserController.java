package com.vsii.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

import com.vsii.entity.User;
import com.vsii.entity.UserResponse;
import com.vsii.service.IUserService;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		List<UserResponse> res = new ArrayList<>();
		for(User user : users) {
			UserResponse userRes = new UserResponse(user.getUserId(), user.getUserName(), user.getImage(), user.getCreatedAt(), user.getUpdatedAt());
			res.add(userRes);
		}
		if (res.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<UserResponse>>(res, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder) {
		boolean flag = userService.addUser(user);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("{id}").buildAndExpand(user.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
