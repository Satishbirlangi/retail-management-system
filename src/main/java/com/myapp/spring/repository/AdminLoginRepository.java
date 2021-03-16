package com.myapp.spring.repository;

import com.myapp.spring.model.AdminData;

public interface AdminLoginRepository {
	AdminData validateLoggedInAdmin(String userName);
}
