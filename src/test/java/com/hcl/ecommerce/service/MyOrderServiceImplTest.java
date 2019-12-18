package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.OrderDto;
import com.hcl.ecommerce.entity.MyOrder;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.NoOrderFoundException;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.repository.MyOrderRepository;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MyOrderServiceImplTest {

	@InjectMocks
	MyOrderServiceImpl myOrderServiceImpl;

	@Mock
	MyOrderRepository myOrderRepository;

	@Mock
	UserRepository userRepository;

	@Mock
	StoreRepository storeRepository;

	static User user = new User();
	static MyOrder myOrder = new MyOrder();
	static Store store = new Store();
	static List<User> users = new ArrayList<User>();
	static List<MyOrder> myOrders = new ArrayList<MyOrder>();
	static OrderDto orderDto = new OrderDto();

	@BeforeClass
	public static void setup() {
		user.setUserId(1);
		myOrder.setOrderId(1);
		myOrder.setProductName("Pen");
		myOrder.setStoreName("Lakshmi");
		myOrder.setStoreCity("Chennai");
		myOrder.setMobileNumber("9894803625");
		myOrder.setUserId(1);
		myOrder.setUserName("Hema");
		myOrders.add(myOrder);
		orderDto.setProductName("Pen");
		orderDto.setStoreName("Lakshmi");
		orderDto.setUserId(1);
	}

	@Test
	public void testOrderProductPositive() throws UserNotFoundException, StoreNotFoundException {
		Mockito.when(userRepository.findByUserId(1)).thenReturn(user);
		Mockito.when(storeRepository.findByStoreName("Lakshmi")).thenReturn(store);
		String message = myOrderServiceImpl.orderProduct(orderDto);
		assertEquals("Order Placed Successfully", message);
	}

	@Test(expected = UserNotFoundException.class)
	public void testOrderProductNegativeForUserNotFound() throws UserNotFoundException, StoreNotFoundException {
		Mockito.when(userRepository.findByUserId(2)).thenReturn(user);
		Mockito.when(storeRepository.findByStoreName("Lakshmi")).thenReturn(store);
		myOrderServiceImpl.orderProduct(orderDto);
	}

	@Test(expected = StoreNotFoundException.class)
	public void testOrderProductNegativeForStoreNotFound() throws UserNotFoundException, StoreNotFoundException {
		Mockito.when(userRepository.findByUserId(1)).thenReturn(user);
		Mockito.when(storeRepository.findByStoreName("Pandian")).thenReturn(store);
		myOrderServiceImpl.orderProduct(orderDto);
	}

	@Test
	public void testMyOrderPositive() throws NoOrderFoundException {
		Mockito.when(myOrderRepository.findByUserId(1)).thenReturn(myOrders);
		List<MyOrder> myOrderList = myOrderServiceImpl.myOrder(1);
		assertEquals(1, myOrderList.size());
	}

	@Test(expected = NoOrderFoundException.class)
	public void testMyOrderNegative() throws NoOrderFoundException {
		List<MyOrder> myOrdersList = new ArrayList<>();
		Mockito.when(myOrderRepository.findByUserId(1)).thenReturn(myOrdersList);
		List<MyOrder> myOrderList = myOrderServiceImpl.myOrder(1);
		assertEquals(myOrdersList.size(), myOrderList.size());
	}

}
