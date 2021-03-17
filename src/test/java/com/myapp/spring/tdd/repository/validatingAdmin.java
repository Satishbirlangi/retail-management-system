package com.myapp.spring.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myapp.spring.model.AdminData;

public class validatingAdmin {
	@MockBean
	private AdminData ad;

	@Test
	@DisplayName("Validating admin")
	public void ValidatingAdmin() {
		AdminData ad = new AdminData();
		ad.setUsername("admin");
		ad.setPassword("admin");
		AdminData ad1 = new AdminData();
		ad1.setUsername("admin");
		ad1.setPassword("admin");

		assertNotNull(ad);
		assertSame("admin", ad.getPassword());
		assertSame("admin", ad.getUsername());
		assertSame("admin", ad1.getPassword());
		assertSame("admin", ad1.getUsername());

	}

}
