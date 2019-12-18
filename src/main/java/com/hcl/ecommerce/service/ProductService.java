package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;

public interface ProductService {

	public String saveProduct(String productName);

	public List<Product> findProductByProductName(String productName) throws ProductNotFoundException;

}
