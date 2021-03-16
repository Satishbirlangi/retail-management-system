package com.myapp.spring.repository;

import com.myapp.spring.model.UserData;

public interface UserLoginRepository {

	UserData validateLoggedInUser(String userName);
}
