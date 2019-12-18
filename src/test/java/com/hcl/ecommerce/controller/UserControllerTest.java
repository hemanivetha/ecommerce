package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.service.UserService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	User user = new User();

	@Test
	public void testLoginUserPositive() {

		user.setUserId(1);
		user.setPassWord("hema");
		String message = "Login Successfull";
		Mockito.when(userService.loginUser(1, "hema")).thenReturn(message);
		Integer result = userController.loginUser(1, "hema").getStatusCodeValue();
		assertEquals(201, result);
	}

	@Test
	public void testLoginUserNegative() {
		String message = "Login not successfull";
		Mockito.when(userService.loginUser(1, "hema")).thenReturn(message);
		Integer result = userController.loginUser(1, "hema").getStatusCodeValue();
		assertEquals(204, result);

	}

}
