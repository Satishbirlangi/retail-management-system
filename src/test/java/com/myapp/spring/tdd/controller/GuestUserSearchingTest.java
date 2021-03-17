package com.myapp.spring.tdd.controller;

import static org.hamcrest.CoreMatchers.isA;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myapp.spring.model.Orders;
import com.myapp.spring.model.RetailStore;
import com.myapp.spring.repository.RetailStoreRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class GuestUserSearchingTest {
	@MockBean
	private RetailStoreRepository service;
	MockHttpServletRequest m;
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void SearchingByTheGuestUser() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8989/retail_store/search/search"))

				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*", isA(ArrayList.class)));
	}

	@Test
	public void SearchingByCategory() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/retail_store/search/{Category}", "Cooking_Essentials"))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*", isA(ArrayList.class)));
	}

	@Test
	public void SearchingByType() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/retail_store/search/{Category}/{Type}", "Cooking_Essentials", "Rice"))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*", isA(ArrayList.class)));
	}

	@Test
	public void SearchingByName() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/retail_store/search/{Category}/{Type}/{Name}",
				"Cooking_Essentials", "Rice", "BasmatiRice")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.*", isA(ArrayList.class)));
	}

	@Test
	public void TestingAddtocartforguestuser() throws Exception {

		Orders o = new Orders();
		RetailStore rt = new RetailStore();
		o.setId(1111);
		o.setCategory("Cooking_Essentials");
		o.setType("Rice");
		o.setName("BasmatiRice");
		o.setBrand("Fortune");
		o.setCount(50);
		o.setExpiry_Date("2022-09-13");
		o.setQuantity("5kg");
		o.setPrice(265);
		rt.setCategory("Cooking_Essentials");
		rt.setType("Rice");
		rt.setName("BasmatiRice");
		String pl = "{\r\n" + "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1111,\r\n"
				+ "    \"type\": \"Rice\",\r\n" + "    \"price\": 265,\r\n" + "    \"expiry_Date\": \"2022-09-13\",\r\n"
				+ "    \"quantity\": \"5kg\",\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"brand\": \"Fortune\",\r\n" + "    \"count\": 5\r\n" + "  }";
		mockMvc.perform(MockMvcRequestBuilders.post("/retail_store/search/{Category}/{Type}/{Name}/addtocart",
				rt.getCategory(), rt.getType(), rt.getName(), o, m).contentType(MediaType.APPLICATION_JSON).content(pl))
				.andDo(print()).andExpect(status().isOk());

	}

}