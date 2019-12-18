package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * ProductStore is the pojo class
 * 
 * @author Hema This class contains 4 fields
 */

@Entity
@Table(name = "product_store")
@Getter
@Setter
public class ProductStore {

	@Id
	private Integer productStoreId;
	private Integer storeId;
	private Integer productId;
	private Double price;

}
