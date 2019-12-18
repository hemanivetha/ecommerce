package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.constants.ECommerceConstants;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.service.ProductService;

/**
 * ProductController is the Controller class
 * 
 * @author Hema This Controller is used to save and list the product based on
 *         the productName
 */

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * 
	 * @param productName
	 * @return
	 */

	@PostMapping("")
	public ResponseEntity<String> saveProduct(@RequestParam String productName) {
		String result = productService.saveProduct(productName);
		if (result.equals(ECommerceConstants.PRODUCT_ADDED)) {
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * 
	 * @param productName
	 * @return
	 * @throws ProductNotFoundException
	 */

	@GetMapping("/byProductNames")
	public ResponseEntity<List<Product>> getProductByProductName(@RequestParam String productName)
			throws ProductNotFoundException {
		List<Product> products = productService.findProductByProductName(productName);
		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

}
