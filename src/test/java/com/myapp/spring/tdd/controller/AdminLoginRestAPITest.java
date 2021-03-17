package com.myapp.spring.tdd.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import com.myapp.spring.model.AdminData;
import com.myapp.spring.responseType.ResponseType;

@SpringBootTest

@AutoConfigureMockMvc
public class AdminLoginRestAPITest {

	@MockBean
	private AdminLoginRestAPITest service;
	ResponseType r = new ResponseType();
	MockHttpServletRequest m;
	@Autowired
	private MockMvc mockMvc;

	AdminData user[] = null;
	AdminData ad = new AdminData();

	@Test
	public void ValidatingAdmin() throws Exception {
		ad.setUsername("admin");
		ad.setPassword("admin");
		String k = "{\r\n" + "     \"username\":\"admin\",\r\n" + "    \"password\":\"admin\"\r\n" + "  }";

		String expectedjson = "{\r\n" + "  \"errcode\": 200,\r\n" + "  \"status\": \"success\",\r\n"
				+ "  \"message\": \"Valid Admin\",\r\n" + "  \"run\": null\r\n" + "}";

		mockMvc.perform(post("/retail_store/validate-admin").contentType(MediaType.APPLICATION_JSON).content(k))

				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(expectedjson));
	}

	@Test
	public void ValidatingnonAdmin() throws Exception {
		ad.setUsername("admin");
		ad.setPassword("admin");
		String k = "{\r\n" + "     \"username\":\"admkin\",\r\n" + "    \"password\":\"admin\"\r\n" + "  }";

		String expectedjson = "{\r\n" + "  \"errcode\": 404,\r\n" + "  \"status\": \"failure\",\r\n"
				+ "  \"message\": \"InValid Admin\",\r\n" + "  \"run\": null\r\n" + "}";
		mockMvc.perform(post("/retail_store/validate-admin").contentType(MediaType.APPLICATION_JSON).content(k))

				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(expectedjson));
	}

}