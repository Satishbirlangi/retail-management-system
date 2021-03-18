package com.myapp.spring.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.myapp.spring.model.AdminData;
import com.myapp.spring.service.AdminLoginService;

public class validatingAdmin {
	boolean expectedStatus = true;
	@Mock
	AdminLoginService adminloginservice;

	AdminData inputData;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setup() throws Exception {

		MockitoAnnotations.initMocks(this);

		inputData = new AdminData();
		inputData.setUsername("admin");
		inputData.setPassword("admin");

	}

	@Test
	public void testvalidatingAdmin() throws Exception {

		System.out.println("UserName::" + inputData.getUsername());

		when(adminloginservice.validateAdmin(inputData)).thenReturn(true);

		boolean actualStatus = adminloginservice.validateAdmin(inputData);

		assertEquals(actualStatus, expectedStatus);
		verify(adminloginservice).validateAdmin(inputData);
	}

	@Test
	public void validatingnonAdmin() throws Exception {

		System.out.println("UserName::" + inputData.getUsername());
		inputData.setUsername("gayi");
		when(adminloginservice.validateAdmin(inputData)).thenReturn(false);
		assertEquals(false, adminloginservice.validateAdmin(inputData));
		verify(adminloginservice).validateAdmin(inputData);

	}
}
