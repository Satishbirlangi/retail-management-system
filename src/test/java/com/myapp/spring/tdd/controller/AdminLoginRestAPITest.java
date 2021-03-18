package com.myapp.spring.tdd.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.AdminData;
import com.myapp.spring.responseType.ResponseType;
import com.myapp.spring.rest.api.AdminLoginRestAPI;

@SpringBootTest

@AutoConfigureMockMvc
public class AdminLoginRestAPITest {

	@MockBean
	ResponseType r = new ResponseType();
	MockHttpServletRequest m;
	@Autowired
	private MockMvc mockMvc;
	private AdminLoginRestAPI service;
	private static File DATA_JSON = Paths.get("src", "test", "resources", "admin.json").toFile();

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {

	}

	@Test
	public void ValidatingAdmin() throws Exception {
		AdminData ad = new AdminData();

		ad.setUsername("admin");
		ad.setPassword("admin");

		doReturn(r).when(service).validateLogin(ad, m);
		mockMvc.perform(post("/retail_store/validate-admin", ad, m).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(ad)))

				.andExpect(status().isCreated());

		assertEquals(true, r.getMessage());

	}

	@Test
	public void ValidatingnonAdmin() throws Exception {

		AdminData ad = new AdminData();

		ad.setUsername("admfin");
		ad.setPassword("admin");

		// doReturn(r).when(service).validateLogin(ad.getUsername());
		assertEquals(false, r.getMessage());

	}
}