package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.service.StoreService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreControllerTest {

	@InjectMocks
	StoreController storeController;

	@Mock
	StoreService storeService;

	Store store = new Store();
	StoreDto storeDto = new StoreDto();

	@Test
	public void testSaveStorePositive() {
		store.setStoreId(1);
		storeDto.setStoreName("Lakshmi");
		storeDto.setStoreCity("Chennai");
		storeDto.setMobileNumber("9894803625");
		String message = "Store added Successfully";
		Mockito.when(storeService.saveStore(storeDto)).thenReturn(message);
		Integer result = storeController.saveStore(storeDto).getStatusCodeValue();
		assertEquals(201, result);
	}

	@Test
	public void testSaveStoreNegative() {
		String message = "Store not Added";
		Mockito.when(storeService.saveStore(storeDto)).thenReturn(message);
		Integer result = storeController.saveStore(storeDto).getStatusCodeValue();
		assertEquals(204, result);
	}

}
