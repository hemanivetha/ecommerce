package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.service.StoreService;

/**
 * StoreController is the Controller class
 * 
 * @author Hema This Controller is used to save store
 */
@RestController
@RequestMapping("/stores")
public class StoreController {

	@Autowired
	StoreService storeService;

	/**
	 * 
	 * @param storeDto
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<String> saveStore(@RequestBody StoreDto storeDto) {
		String result = storeService.saveStore(storeDto);
		if (result.equals("Store added Successfully")) {
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Store not Added", HttpStatus.NO_CONTENT);
	}

}
