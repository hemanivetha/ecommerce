package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.service.ProductService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {

	@InjectMocks
	ProductController productController;

	@Mock
	ProductService productService;

	Product product = new Product();
	List<Product> productList = new ArrayList<Product>();

	@Test
	public void testSaveProductPositive() {
		product.setProductId(1);
		product.setProductName("Pen");
		String message = "Product added Successfully";
		Mockito.when(productService.saveProduct("Pen")).thenReturn(message);
		Integer result = productController.saveProduct("Pen").getStatusCodeValue();
		assertEquals(201, result);
	}

	@Test
	public void testSaveProductNegative() {
		String message = "Product not added";
		Mockito.when(productService.saveProduct("Pen")).thenReturn(message);
		Integer result = productController.saveProduct("Pen").getStatusCodeValue();
		assertEquals(204, result);
	}

	@Test
	public void testGetProductByProductNamePositive() throws ProductNotFoundException {
		product.setProductName("Pen");
		productList.add(product);
		Mockito.when(productService.findProductByProductName("Pen")).thenReturn(productList);
		Integer result = productController.getProductByProductName("Pen").getStatusCodeValue();
		assertEquals(200, result);
	}

	@Test
	public void testGetProductByProductNameNegative() throws ProductNotFoundException {
		Mockito.when(productService.findProductByProductName("Pen")).thenReturn(productList);
		Integer result = productController.getProductByProductName("Pen").getStatusCodeValue();
		assertEquals(204, result);
	}

}
