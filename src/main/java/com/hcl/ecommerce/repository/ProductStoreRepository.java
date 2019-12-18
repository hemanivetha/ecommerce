package com.hcl.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.dto.ProductStoreDetailsDto;
import com.hcl.ecommerce.entity.ProductStore;

@Repository
public interface ProductStoreRepository extends JpaRepository<ProductStore, Integer> {

	List<ProductStore> findByProductId(Integer productId);

	void save(ProductStoreDetailsDto productStoreDetailsDto);

}
