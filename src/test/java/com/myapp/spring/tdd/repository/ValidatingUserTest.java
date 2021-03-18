package com.myapp.spring.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.spring.model.RetailStore;
import com.myapp.spring.model.UserData;
import com.myapp.spring.service.UserLoginService;

@SpringBootTest
@AutoConfigureMockMvc
public class ValidatingUserTest {
	boolean expectedStatus = true;
	@Mock
	UserLoginService userloginservice;

	UserData inputData;
	RetailStore prod1;
	List<RetailStore> retaillist;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setup() throws Exception {

		MockitoAnnotations.initMocks(this);

		retaillist = new ArrayList<RetailStore>();

		inputData = new UserData();
		inputData.setUsername("admin");
		inputData.setPassword("admin");

	}

	@Test
	@Order(1)
	public void validatingUser() throws Exception {

		System.out.println("UserName::" + inputData.getUsername());

		when(userloginservice.validateLogin(inputData)).thenReturn(true);

		boolean actualStatus = userloginservice.validateLogin(inputData);

		assertEquals(actualStatus, expectedStatus);
		verify(userloginservice).validateLogin(inputData);
	}

	@Test
	@Order(2)
	public void validatingnonUser() throws Exception {

		System.out.println("UserName::" + inputData.getUsername());
		inputData.setUsername("gayi");
		when(userloginservice.validateLogin(inputData)).thenReturn(false);

		boolean actualStatus = userloginservice.validateLogin(inputData);

		assertEquals(false, actualStatus);
		verify(userloginservice).validateLogin(inputData);
	}
}