package com.hcl.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

/**
 * MyOrderServiceImpl is the service class which implements MyOrderService
 * 
 * @author Hema This interface is used to order and list the product
 */

@Service
public class MyOrderServiceImpl implements MyOrderService {

	@Autowired
	MyOrderRepository myOrderRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StoreRepository storeRepository;

	/**
	 * orderProduct is the method used to order the product by passing orderDto
	 */
	@Override
	public String orderProduct(OrderDto orderDto) throws UserNotFoundException, StoreNotFoundException {
		User user = userRepository.findByUserId(orderDto.getUserId());
		if (user != null) {
			Store store = storeRepository.findByStoreName(orderDto.getStoreName());
			if (store != null) {
				MyOrder myOrder = new MyOrder();
				myOrder.setUserId(orderDto.getUserId());
				myOrder.setUserName(user.getUserName());
				myOrder.setStoreName(orderDto.getStoreName());
				myOrder.setStoreCity(store.getStoreCity());
				myOrder.setMobileNumber(store.getMobileNumber());
				myOrder.setProductName(orderDto.getProductName());
				myOrderRepository.save(myOrder);
			} else {
				throw new StoreNotFoundException("No store found");
			}
		} else {
			throw new UserNotFoundException("No User Found in this userId");
		}
		return "Order Placed Successfully";
	}

	/**
	 * myOrder is the method used to list the orders on the userId
	 */
	@Override
	public List<MyOrder> myOrder(Integer userId) throws NoOrderFoundException {
		List<MyOrder> myOrder = myOrderRepository.findByUserId(userId);
		if (myOrder.isEmpty()) {
			throw new NoOrderFoundException("No Orders found on this userId");
		}
		return myOrder;
	}

}
