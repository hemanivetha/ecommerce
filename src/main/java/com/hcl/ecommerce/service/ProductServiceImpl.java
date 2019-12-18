package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.constants.ECommerceConstants;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.repository.ProductRepository;

/**
 * ProductServiceImpl is the service class which implements ProductService
 * 
 * @author Hema This interface is used to save and find the product by
 *         productName
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	/**
	 * saveProduct is used to save the product
	 */
	@Override
	public String saveProduct(String productName) {
		Product product = new Product();
		product.setProductName(productName);
		productRepository.save(product);
		return ECommerceConstants.PRODUCT_ADDED;
	}

	/**
	 * findProductByProductName is used to find the product by productName
	 */
	@Override
	public List<Product> findProductByProductName(String productName) throws ProductNotFoundException {
		List<Product> products = productRepository.findAll();
		List<Product> productsByName = new ArrayList<>();
		for (Product product : products) {
			productsByName.add(product);
		}
		productsByName = productsByName.stream().filter(
				productByName -> productByName.getProductName().toLowerCase().startsWith(productName.toLowerCase()))
				.collect(Collectors.toList());
		if (productsByName.isEmpty()) {
			throw new ProductNotFoundException("No product in this productName");
		}
		return productsByName;
	}

}
