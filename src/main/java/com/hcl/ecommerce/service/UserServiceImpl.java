package com.hcl.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.UserRepository;

/**
 * UserServiceImpl is the service class which implements UserService
 * 
 * @author Hema This interface is used to verify the user
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * loginUser is used to verify the user
	 */
	@Override
	public String loginUser(Integer userId, String passWord) {
		Optional<User> user = userRepository.findById(userId);
		String result = "";
		if (user.isPresent()) {
			if (userId.equals(user.get().getUserId()) && passWord.equals(user.get().getPassWord())) {
				result = "Login Successfull";
			} else {
				result = "Login not Successfull";
			}
		}

		return result;
	}

}
