package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.service.UserService;

/**
 * UserController is the Controller class
 * 
 * @author Hema This Controller is used to verify the user
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 
	 * @param userId
	 * @param passWord
	 * @return
	 */

	@PostMapping("")
	public ResponseEntity<String> loginUser(@RequestParam Integer userId, @RequestParam String passWord) {
		String result = userService.loginUser(userId, passWord);
		if (result.equalsIgnoreCase("Login Successfull")) {
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Login not successfull", HttpStatus.NO_CONTENT);
	}

}
