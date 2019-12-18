package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Store is the pojo class
 * 
 * @author Hema This class contains 4 fields
 */

@Entity
@Table(name = "store")
@Getter
@Setter
@SequenceGenerator(name = "storesequence", initialValue = 1000)
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storesequence")
	private Integer storeId;
	private String storeName;
	private String storeCity;
	private String mobileNumber;

}
