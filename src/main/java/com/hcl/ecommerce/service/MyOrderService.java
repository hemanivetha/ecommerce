package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.OrderDto;
import com.hcl.ecommerce.entity.MyOrder;
import com.hcl.ecommerce.exception.NoOrderFoundException;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.exception.UserNotFoundException;

public interface MyOrderService {

	public String orderProduct(OrderDto orderDto) throws UserNotFoundException, StoreNotFoundException;

	List<MyOrder> myOrder(Integer userId) throws NoOrderFoundException;

}
