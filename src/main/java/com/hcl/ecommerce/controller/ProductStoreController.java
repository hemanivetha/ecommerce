package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.ProductStoreDetailsDto;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.exception.ProductStoreNotFoundException;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.service.ProductStoreService;

/**
 * ProductStoreController is the Controller class
 * 
 * @author Hema This Controller is used to list the ProductStoreDetailsDto based
 *         on the productName
 */

@RestController
@RequestMapping("/productStores")
public class ProductStoreController {

	@Autowired
	ProductStoreService productStoreService;

	/**
	 * 
	 * @param productName
	 * @return
	 * @throws ProductNotFoundException
	 * @throws ProductStoreNotFoundException
	 * @throws StoreNotFoundException
	 */
	@GetMapping("/byProductNames")
	public ResponseEntity<List<ProductStoreDetailsDto>> storeDetailsByProductName(@RequestParam String productName)
			throws ProductStoreNotFoundException {
		List<ProductStoreDetailsDto> productStoreDetailsDto = productStoreService.storeDetails(productName);
		if (productStoreDetailsDto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(productStoreDetailsDto, HttpStatus.OK);
	}

}
