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

import com.hcl.ecommerce.dto.ProductStoreDetailsDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductStoreNotFoundException;
import com.hcl.ecommerce.service.ProductStoreService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductStoreControllerTest {

	@InjectMocks
	ProductStoreController productStoreController;

	@Mock
	ProductStoreService productStoreService;

	ProductStoreDetailsDto productStoreDetailsDto = new ProductStoreDetailsDto();
	List<ProductStoreDetailsDto> productStoreDetailsDtoList = new ArrayList<>();
	Product product = new Product();

	@Test
	public void testStoreDetailsByProductNamePositive()
			throws ProductStoreNotFoundException {
		product.setProductName("Pen");
		productStoreDetailsDto.setStoreId(1);
		productStoreDetailsDto.setStoreName("Lakshmi");
		productStoreDetailsDto.setPrice(10.0);
		productStoreDetailsDto.setRating(4.0);
		productStoreDetailsDtoList.add(productStoreDetailsDto);
		Mockito.when(productStoreService.storeDetails("Pen")).thenReturn(productStoreDetailsDtoList);
		Integer result = productStoreController.storeDetailsByProductName("Pen").getStatusCodeValue();
		assertEquals(1, productStoreDetailsDtoList.size());
		assertEquals(200, result);
	}

	@Test
	public void testStoreDetailsByProductNameNegative()
			throws ProductStoreNotFoundException {
		product.setProductName("Pencil");
		Mockito.when(productStoreService.storeDetails("Pencil")).thenReturn(productStoreDetailsDtoList);
		Integer result = productStoreController.storeDetailsByProductName("Pencil").getStatusCodeValue();
		assertEquals(0, productStoreDetailsDtoList.size());
		assertEquals(204, result);
	}

}
