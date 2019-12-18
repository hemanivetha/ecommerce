package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * OrderDto is the dto class
 * 
 * @author Hema This class contains 3 fields
 */

@Getter
@Setter
public class OrderDto {

	private String productName;
	private String storeName;
	private Integer userId;

}
