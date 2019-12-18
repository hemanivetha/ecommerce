package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.ProductStoreDetailsDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.ProductStore;
import com.hcl.ecommerce.entity.Review;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.exception.ProductStoreNotFoundException;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.ReviewRepository;
import com.hcl.ecommerce.repository.StoreRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductStoreServiceImplTest {

	@InjectMocks
	ProductStoreServiceImpl productStoreServiceImpl;

	@Mock
	ProductStoreRepository productStoreRepository;

	@Mock
	ProductRepository productRepository;

	@Mock
	ReviewRepository reviewRepository;

	@Mock
	StoreRepository storeRepository;

	Product product = new Product();
	ProductStore productStore = new ProductStore();
	List<ProductStore> productStores = new ArrayList<>();
	Store store = new Store();
	List<Store> stores = new ArrayList<>();
	ProductStoreDetailsDto productStoreDetailsDto = new ProductStoreDetailsDto();
	Review review = new Review();
	List<ProductStoreDetailsDto> productStoreDetailsList = new ArrayList<>();

	@Before
	public void setUp() {

		productStore.setProductStoreId(1);
		productStore.setProductId(1);
		productStore.setStoreId(1);
		productStore.setPrice(10.0);
		store.setStoreId(1);
		store.setStoreName("Lakshmi");
		store.setStoreCity("Chennai");
		store.setMobileNumber("9894803625");
		productStoreDetailsDto.setStoreId(1);
		productStoreDetailsDto.setStoreName("Lakshmi");
		productStoreDetailsDto.setRating(4.0);
		productStoreDetailsDto.setPrice(10.0);
		review.setRating(4.0);
	}

	@Test
	public void testStoreDetailsPositive() throws ProductStoreNotFoundException {
		product.setProductId(1);
		product.setProductName("Pen");
		productStores.add(productStore);
		stores.add(store);
		productStoreDetailsList.add(productStoreDetailsDto);
		Mockito.when(productRepository.findProductByProductName("Pen")).thenReturn(product);
		Mockito.when(productStoreRepository.findByProductId(1)).thenReturn(productStores);
		Mockito.when(storeRepository.findByStoreId(1)).thenReturn(stores);
		Mockito.when(reviewRepository.findByStoreId(1)).thenReturn(4.0);
		List<ProductStoreDetailsDto> ProductStoreDetailsDtoList = productStoreServiceImpl.storeDetails("Pen");
		assertEquals(1, ProductStoreDetailsDtoList.size());
	}

	@Test(expected = ProductStoreNotFoundException.class)
	public void testStoreDetailsNegativeForProductStore() throws ProductStoreNotFoundException {
		product.setProductId(1);
		product.setProductName("Pen");
		Mockito.when(productRepository.findProductByProductName("Pen")).thenReturn(product);
		Mockito.when(productStoreRepository.findByProductId(1)).thenReturn(null);
		List<ProductStoreDetailsDto> ProductStoreDetailsDtoList = productStoreServiceImpl.storeDetails("Pen");
		assertEquals(0, ProductStoreDetailsDtoList.size());
	}

}
