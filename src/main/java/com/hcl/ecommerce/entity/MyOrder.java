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
 * MyOrder is the pojo class
 * 
 * @author Hema This class contains 7 fields
 */

@Entity
@Table(name = "my_order")
@Getter
@Setter
@SequenceGenerator(name = "myordersequence", initialValue = 10000)
public class MyOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myordersequence")
	private Integer orderId;
	private Integer userId;
	private String userName;
	private String storeName;
	private String storeCity;
	private String mobileNumber;
	private String productName;

}
