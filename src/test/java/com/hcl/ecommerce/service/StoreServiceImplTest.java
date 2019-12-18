package com.hcl.ecommerce.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.repository.StoreRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreServiceImplTest {

	@InjectMocks
	StoreServiceImpl storeServiceImpl;

	@Mock
	StoreRepository storeRepository;

	Store store = new Store();
	StoreDto storeDto = new StoreDto();

	@Test
	public void testSaveStorePositive() {
		storeDto.setStoreName("Lakshmi");
		storeDto.setStoreCity("Chennai");
		storeDto.setMobileNumber("9894803625");
		String message = "Store added Successfully";
		String expectedString = storeServiceImpl.saveStore(storeDto);
		assertEquals(expectedString, message);
	}

	@Test
	public void testSaveStoreNegative() {
		String message = "Store not added";
		String expectedString = storeServiceImpl.saveStore(storeDto);
		assertNotEquals(expectedString, message);
	}

}
