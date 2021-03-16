package com.myapp.spring.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myapp.spring.model.UserData;

public class ValidatingUserTest {
	@MockBean
	private UserData ud = new UserData();

	@Test
	@DisplayName("Validating user")
	public void testFlightNotFoundForNonExistingId() {

		ud.setUsername("admin");
		ud.setPassword("admin");

		assertNotNull(ud);
		assertSame("admin", ud.getPassword());
		assertSame("admin", ud.getUsername());

	}

}
