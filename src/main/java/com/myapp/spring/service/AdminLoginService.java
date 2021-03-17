package com.myapp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.spring.model.AdminData;
import com.myapp.spring.repository.AdminLoginRepository;

@Service("adminloginservice")
public class AdminLoginService {
	@Autowired
	AdminLoginRepository repository;

	public boolean validateAdmin(AdminData adminInputData) {
		AdminData adminData = repository.validateLoggedInAdmin(adminInputData.getUsername());
		System.out.println("AdminData::" + adminData);
		if (adminData != null) {
			if (adminInputData.getPassword().equals(adminData.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
