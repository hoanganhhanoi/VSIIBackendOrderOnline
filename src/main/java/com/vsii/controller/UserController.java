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
import org.springframework.web.util.UriComponentsBuilder;

import com.vsii.entity.User;
import com.vsii.entity.json.UserJSON;
import com.vsii.service.IUserService;

@Controller
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<UserJSON> getUserById(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		UserJSON userRes = new UserJSON(user.getUserId(), user.getUserName(), user.getImage(), user.getCreatedAt(), user.getUpdatedAt());
		return new ResponseEntity<UserJSON>(userRes, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "")
	public ResponseEntity<List<UserJSON>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		List<UserJSON> res = new ArrayList<>();
		for(User user : users) {
			UserJSON userRes = new UserJSON(user.getUserId(), user.getUserName(), user.getImage(), user.getCreatedAt(), user.getUpdatedAt());
			res.add(userRes);
		}
		if (res.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<UserJSON>>(res, HttpStatus.OK);
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

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		int result = userService.updateUser(user);
		if(result > 0) 
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<User>(user, HttpStatus.NOT_IMPLEMENTED);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		int result = userService.deleteUser(id);
		if(result > 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}
}
