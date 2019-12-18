package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.OrderDto;
import com.hcl.ecommerce.entity.MyOrder;
import com.hcl.ecommerce.exception.NoOrderFoundException;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.service.MyOrderService;

import lombok.extern.slf4j.Slf4j;

/**
 * MyOrderController is the Controller class
 * 
 * @author Hema This Controller is used to order the product
 */

@RestController
@RequestMapping("/myorders")
@Slf4j
public class MyOrderController {

	@Autowired
	MyOrderService myOrderService;

	/**
	 * 
	 * @param orderDto
	 * @return
	 * @throws UserNotFoundException
	 * @throws StoreNotFoundException
	 */

	@PostMapping("")
	public ResponseEntity<String> orderProduct(@RequestBody OrderDto orderDto)
			throws UserNotFoundException, StoreNotFoundException {
		log.info("orderPoduct");
		String result = myOrderService.orderProduct(orderDto);
		if (result.equalsIgnoreCase("Order Placed Successfully")) {
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Order not placed", HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws NoOrderFoundException
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<List<MyOrder>> getMyOrder(@RequestParam Integer userId) throws NoOrderFoundException {
		List<MyOrder> myOrder = myOrderService.myOrder(userId);
		if (myOrder.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(myOrder, HttpStatus.OK);
	}

}
