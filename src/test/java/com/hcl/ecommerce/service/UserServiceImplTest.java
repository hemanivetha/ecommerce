package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	User user = new User();
	List<User> users = new ArrayList<User>();

	@Before
	public void setUp() {
		user.setUserId(1);
		user.setUserName("Hema");
		user.setPassWord("hema");
	}

	@Test
	public void testLoginUserPositive() {
		Optional<User> optionalUser = Optional.of(user);
		when(userRepository.findById(1)).thenReturn(optionalUser);
		String response = userServiceImpl.loginUser(1, "hema");
		assertEquals("Login Successfull", response);
	}

	@Test
	public void testLoginUser() {
		Optional<User> optionalUser = Optional.of(user);
		when(userRepository.findById(2)).thenReturn(optionalUser);
		String response = userServiceImpl.loginUser(2, "hema");
		assertEquals("Login not Successfull", response);
	}

	@Test
	public void testLoginUserForUnSucessful() {
		Optional<User> optionalUser = Optional.of(user);
		when(userRepository.findById(1)).thenReturn(optionalUser);
		String response = userServiceImpl.loginUser(1, "hema1");
		assertEquals("Login not Successfull", response);
	}

}
