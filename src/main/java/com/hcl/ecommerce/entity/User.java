package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * User is the pojo class
 * 
 * @author Hema This class contains 3 fields
 */

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

	@Id
	private Integer userId;
	private String userName;
	private String passWord;

}
