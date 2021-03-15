package com.myapp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.spring.model.UserData;
import com.myapp.spring.repository.UserLoginRepository;

@Service("userloginservice")
public class UserLoginService {
	public String luname;
	@Autowired
	UserLoginRepository repository;

	public boolean validateLogin(UserData userInputData) {
		UserData userData = repository.validateLoggedInUser(userInputData.getUsername());

		System.out.println("UserData::" + userData);
		if (userData != null) {
			if (userInputData.getPassword().equals(userData.getPassword())) {
				luname = userData.getUsername();
				return true;
			}
		}
		return false;
	}

}