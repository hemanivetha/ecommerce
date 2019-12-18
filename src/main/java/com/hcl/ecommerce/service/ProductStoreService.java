package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.ProductStoreDetailsDto;
import com.hcl.ecommerce.exception.ProductStoreNotFoundException;

public interface ProductStoreService {

	public List<ProductStoreDetailsDto> storeDetails(String productName)
			throws ProductStoreNotFoundException;

}
