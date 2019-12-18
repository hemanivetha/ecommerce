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
 * Product is the pojo class
 * 
 * @author Hema This class contains 2 fields
 */

@Entity
@Table(name = "product")
@Getter
@Setter
@SequenceGenerator(name = "productsequence", initialValue = 100)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productsequence")
	private Integer productId;
	private String productName;

}
