package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.ProductStoreDetailsDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.ProductStore;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.exception.ProductStoreNotFoundException;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.ReviewRepository;
import com.hcl.ecommerce.repository.StoreRepository;

/**
 * ProductStoreServiceImpl is the service class which implements
 * ProductStoreService
 * 
 * @author Hema This interface is used to show the details of the store
 */

@Service
public class ProductStoreServiceImpl implements ProductStoreService {

	@Autowired
	ProductStoreRepository productStoreRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	StoreRepository storeRepository;

	@Autowired
	ReviewRepository reviewRepository;

	/**
	 * storeDetails is used to show storeDetails
	 */
	@Override
	public List<ProductStoreDetailsDto> storeDetails(String productName)
			throws ProductStoreNotFoundException {
		List<ProductStoreDetailsDto> productStoreDetailsList = new ArrayList<>();
		Product product = productRepository.findProductByProductName(productName);
		List<ProductStore> productStore = productStoreRepository.findByProductId(product.getProductId());
		if (productStore != null) {
			for (ProductStore productStores : productStore) {
				List<Store> store = storeRepository.findByStoreId(productStores.getStoreId());
				ProductStoreDetailsDto productStoreDetailsDto = new ProductStoreDetailsDto();
				for (Store storeDetail : store) {
					productStoreDetailsDto.setRating(reviewRepository.findByStoreId(storeDetail.getStoreId()));
					productStoreDetailsDto.setStoreId(storeDetail.getStoreId());
					productStoreDetailsDto.setStoreName(storeDetail.getStoreName());
					productStoreDetailsDto.setPrice(productStores.getPrice());
					productStoreDetailsList.add(productStoreDetailsDto);
				}
			}
		}else {
			throw new ProductStoreNotFoundException("No productStore");
		}
		return productStoreDetailsList;
	}

}
