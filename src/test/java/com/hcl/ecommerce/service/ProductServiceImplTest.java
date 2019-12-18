package com.hcl.ecommerce.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
import com.hcl.ecommerce.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;

	Product product = new Product();
	List<Product> products = new ArrayList<Product>();

	@Test
	public void testSaveProductPositive() {
		String productName = "pen";
		product.setProductName(productName);
		String message = "Product added Successfully";
		String expectedString = productServiceImpl.saveProduct(productName);
		assertEquals(expectedString, message);
	}

	@Test
	public void testSaveProductNegative() {
		String productName = "";
		String message = "Product not added";
		String expectedString = productServiceImpl.saveProduct(productName);
		assertNotEquals(expectedString, message);
	}

	@Test
	public void testFindProductByProductNamePositive() throws ProductNotFoundException {
		product.setProductId(1);
		product.setProductName("Pen");
		products.add(product);
		Mockito.when(productRepository.findAll()).thenReturn(products);
		List<Product> productList = productServiceImpl.findProductByProductName("Pen");
		assertEquals(1, productList.size());
	}

	@Test(expected = ProductNotFoundException.class)
	public void testFindProductByProductNameNegative() throws ProductNotFoundException {
		Mockito.when(productRepository.findAll()).thenReturn(products);
		List<Product> productList = productServiceImpl.findProductByProductName("Pen");
		assertEquals(0, productList.size());
	}

}
