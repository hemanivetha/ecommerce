package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.repository.StoreRepository;

/**
 * StoreServiceImpl is the service class which implements StoreService
 * 
 * @author Hema This interface is used to save the product
 */

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepository;

	/**
	 * saveStore is the method used to save the store
	 */
	@Override
	public String saveStore(StoreDto storeDto) {
		Store store = new Store();
		store.setStoreName(storeDto.getStoreName());
		store.setStoreCity(storeDto.getStoreCity());
		store.setMobileNumber(storeDto.getMobileNumber());
		storeRepository.save(store);
		return "Store added Successfully";
	}

}
