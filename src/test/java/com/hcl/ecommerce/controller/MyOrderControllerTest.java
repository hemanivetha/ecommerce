package com.hcl.ecommerce.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.ecommerce.dto.OrderDto;
import com.hcl.ecommerce.entity.MyOrder;
import com.hcl.ecommerce.exception.NoOrderFoundException;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.service.MyOrderService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MyOrderControllerTest {

	@InjectMocks
	MyOrderController myOrderController;

	@Mock
	MyOrderService myOrderService;

	OrderDto orderDto = new OrderDto();

	@Test
	public void testOrderProductPositive() throws UserNotFoundException, StoreNotFoundException {
		orderDto.setProductName("Pen");
		orderDto.setStoreName("Lakshmi");
		orderDto.setUserId(1);
		String message = "Order Placed Successfully";
		Mockito.when(myOrderService.orderProduct(orderDto)).thenReturn(message);
		Integer result = myOrderController.orderProduct(orderDto).getStatusCodeValue();
		assertEquals(201, result);
	}

	@Test
	public void testOrderProductNegative() throws UserNotFoundException, StoreNotFoundException {
		orderDto.setProductName("Pen");
		orderDto.setStoreName("Lakshmi");
		orderDto.setUserId(1);
		String message = "Order not Placed";
		Mockito.when(myOrderService.orderProduct(orderDto)).thenReturn(message);
		Integer result = myOrderController.orderProduct(orderDto).getStatusCodeValue();
		assertEquals(204, result);
	}

	@Test
	public void testGetMyOrderPositve() throws NoOrderFoundException {
		MyOrder myOrder = new MyOrder();
		myOrder.setOrderId(1);
		myOrder.setUserId(1);
		myOrder.setUserName("Hema");
		myOrder.setStoreName("Lakshmi");
		myOrder.setStoreCity("Pakkam");
		myOrder.setMobileNumber("9894803625");
		myOrder.setProductName("Pen");
		List<MyOrder> myOrders = new ArrayList<MyOrder>();
		myOrders.add(myOrder);
		Mockito.when(myOrderService.myOrder(1)).thenReturn(myOrders);
		ResponseEntity<List<MyOrder>> myOrderList = myOrderController.getMyOrder(1);
		assertNotNull(myOrderList);
		assertEquals(200, myOrderList.getStatusCodeValue());
	}

	@Test
	public void testGetMyOrderNegative() throws NoOrderFoundException {
		List<MyOrder> myOrders = new ArrayList<MyOrder>();
		Mockito.when(myOrderService.myOrder(0)).thenReturn(myOrders);
		ResponseEntity<List<MyOrder>> myOrderList = myOrderController.getMyOrder(0);
		assertNotNull(myOrderList);
		assertEquals(204, myOrderList.getStatusCodeValue());
	}

}
