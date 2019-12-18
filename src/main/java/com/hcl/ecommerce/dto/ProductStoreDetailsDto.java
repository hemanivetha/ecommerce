package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * ProductStoreDetailsDto is the dto class
 * 
 * @author Hema This class contains 4 fields
 */

@Getter
@Setter
public class ProductStoreDetailsDto {

	private Integer storeId;
	private Double price;
	private String storeName;
	private Double rating;

}
