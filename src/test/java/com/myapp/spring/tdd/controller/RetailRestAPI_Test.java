
package com.myapp.spring.tdd.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.Orders;
import com.myapp.spring.model.RetailStore;
import com.myapp.spring.repository.RetailStoreRepository;

@SpringBootTest

//spring context
//environment
//loading the beans
//start the embeded tomcat server
@AutoConfigureMockMvc
public class RetailRestAPI_Test {

	@MockBean
	private RetailStoreRepository service;

	@Autowired
	private MockMvc mockMvc;
	private static File DATA_JSON = Paths.get("src", "main", "resources", "retaildata.json").toFile();

	// List<RetailStore> products[] = null;
	RetailStore products[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("running");
		// products = (List<RetailStore>[]) new ObjectMapper().readValue(DATA_JSON,
		// RetailStore[].class);
		products = new ObjectMapper().readValue(DATA_JSON, RetailStore[].class);

	}

	String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@Test
	@DisplayName("RetailRestAPI Testing with Category")
	public void TestingCategory() throws Exception {

		// Prepared mock flight
		RetailStore rt = new RetailStore();
		List<RetailStore> r = new ArrayList<RetailStore>();

		rt.setCategory("Cooking_Essentials");
		rt.setId(1111);
		rt.setBrand("Fortune");
		rt.setPrice(265);
		rt.setName("BasmatiRice");
		rt.setExpiry_Date("2022-09-13T07:00:00.000+00:00");
		rt.setType("Rice");
		rt.setQuantity("5kg");
		rt.setStock(90);
		r.add(rt);
		// r.add("category","CookingEssentials");

		// prepared mock service method

		doReturn(r).when(service).findByCategory(rt.getCategory());

		// perform get request

		mockMvc.perform(MockMvcRequestBuilders.get("/retail_store/search/{Category}", "Cooking_Essentials"))
				// .andExpect(status().isOk())//.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				// validate response body

				// {"id":1,"airlines":"Airindia","distance":789}

				.andExpect(jsonPath("$[0].category", is("Cooking_Essentials"))).andExpect(jsonPath("$[0].id", is(1111)))
				.andExpect(jsonPath("$[0].brand", is("Fortune"))).andExpect(jsonPath("$[0].price", is(265)))
				.andExpect(jsonPath("$[0].name", is("BasmatiRice"))).andExpect(jsonPath("$[0].type", is("Rice")))
				.andExpect(jsonPath("$[0].stock", is(90))).andExpect(jsonPath("$[0].quantity", is("5kg")))
				.andExpect(jsonPath("$[0].expiry_Date", is("2022-09-13T07:00:00.000+00:00")));

		/*
		 * is(" {\r\n" + "    \"id\": 1111,\r\n" +
		 * "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"price\": 265,\r\n" +
		 * "    \"brand\": \"Fortune\",\r\n" +
		 * "    \"expiry_Date\": \"2022-09-13T07:00:00.000+00:00\",\r\n" +
		 * "    \"quantity\": \"5kg\",\r\n" + "    \"name\": \"BasmatiRice\",\r\n" +
		 * "    \"type\": \"Rice\",\r\n" + " \"stock\":90\r\n" + "}")));
		 */
	}

	@Test
	@DisplayName("RetailRestAPI Testing with Type")
	public void TestingType() throws Exception {

		// Prepared mock flight
		RetailStore rt = new RetailStore();
		List<RetailStore> r = new ArrayList<RetailStore>();

		rt.setCategory("Cooking_Essentials");
		rt.setId(1111);
		rt.setBrand("Fortune");
		rt.setPrice(265);
		rt.setName("BasmatiRice");
		rt.setExpiry_Date("2022-09-13T07:00:00.000+00:00");
		rt.setType("Rice");
		rt.setQuantity("5kg");
		rt.setStock(90);
		r.add(rt);
		// r.add("category","CookingEssentials");

		// prepared mock service method

		doReturn(r).when(service).findByType(rt.getCategory(), rt.getType());

		// perform get request

		mockMvc.perform(
				MockMvcRequestBuilders.get("/retail_store/search/{Category}/{Type}", "Cooking_Essentials", "Rice"))
				// .andExpect(status().isOk())//.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				// validate response body

				// {"id":1,"airlines":"Airindia","distance":789}

				.andExpect(jsonPath("$[0].category", is("Cooking_Essentials"))).andExpect(jsonPath("$[0].id", is(1111)))
				.andExpect(jsonPath("$[0].brand", is("Fortune"))).andExpect(jsonPath("$[0].price", is(265)))
				.andExpect(jsonPath("$[0].name", is("BasmatiRice"))).andExpect(jsonPath("$[0].type", is("Rice")))
				.andExpect(jsonPath("$[0].stock", is(90))).andExpect(jsonPath("$[0].quantity", is("5kg")))
				.andExpect(jsonPath("$[0].expiry_Date", is("2022-09-13T07:00:00.000+00:00")));

		/*
		 * is(" {\r\n" + "    \"id\": 1111,\r\n" +
		 * "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"price\": 265,\r\n" +
		 * "    \"brand\": \"Fortune\",\r\n" +
		 * "    \"expiry_Date\": \"2022-09-13T07:00:00.000+00:00\",\r\n" +
		 * "    \"quantity\": \"5kg\",\r\n" + "    \"name\": \"BasmatiRice\",\r\n" +
		 * "    \"type\": \"Rice\",\r\n" + " \"stock\":90\r\n" + "}")));
		 */
	}

	@Test
	@DisplayName("RetailRestAPI Testing with Name")
	public void TestingName() throws Exception {

		// Prepared mock flight
		RetailStore rt = new RetailStore();

		RetailStore rt2 = new RetailStore(3121, "Packaged-Foods", "Breakfast Foods", "Cornflakes", "Kellog's", "1kg",
				149, "2022-02-16", 220);

		List<RetailStore> r = new ArrayList<RetailStore>();
		List<RetailStore> r2 = new ArrayList<RetailStore>();

		rt.setCategory("Cooking_Essentials");
		rt.setId(1111);
		rt.setBrand("Fortune");
		rt.setPrice(265);
		rt.setName("BasmatiRice");
		rt.setExpiry_Date("2022-09-13T07:00:00.000+00:00");
		rt.setType("Rice");
		rt.setQuantity("5kg");
		rt.setStock(90);
		r.add(rt);
		r2.add(rt2);
		// r.add("category","CookingEssentials");

		// prepared mock service method

		doReturn(r).when(service).findByName(rt.getCategory(), rt.getType(), rt.getName());
		doReturn(r2).when(service).findByName(rt2.getCategory(), rt2.getType(), rt2.getName());

		// perform get request

		mockMvc.perform(MockMvcRequestBuilders.get("/retail_store/search/{Category}/{Type}/{Name}",
				"Cooking_Essentials", "Rice", "BasmatiRice"))
				// .andExpect(status().isOk())//.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				// validate response body

				// {"id":1,"airlines":"Airindia","distance":789}

				.andExpect(jsonPath("$[0].category", is("Cooking_Essentials"))).andExpect(jsonPath("$[0].id", is(1111)))
				.andExpect(jsonPath("$[0].brand", is("Fortune"))).andExpect(jsonPath("$[0].price", is(265)))
				.andExpect(jsonPath("$[0].name", is("BasmatiRice"))).andExpect(jsonPath("$[0].type", is("Rice")))
				.andExpect(jsonPath("$[0].stock", is(90))).andExpect(jsonPath("$[0].quantity", is("5kg")))
				.andExpect(jsonPath("$[0].expiry_Date", is("2022-09-13T07:00:00.000+00:00")));

		/*
		 * is(" {\r\n" + "    \"id\": 1111,\r\n" +
		 * "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"price\": 265,\r\n" +
		 * "    \"brand\": \"Fortune\",\r\n" +
		 * "    \"expiry_Date\": \"2022-09-13T07:00:00.000+00:00\",\r\n" +
		 * "    \"quantity\": \"5kg\",\r\n" + "    \"name\": \"BasmatiRice\",\r\n" +
		 * "    \"type\": \"Rice\",\r\n" + " \"stock\":90\r\n" + "}")));
		 */
	}

	@Test
	@DisplayName("RetailRestAPI Testing all")
	public void TestingAll() throws Exception {

		// Prepared mock flight
		RetailStore rt = new RetailStore();
		RetailStore rt1 = new RetailStore();
		List<RetailStore> r = new ArrayList<RetailStore>();

		rt.setCategory("Cooking_Essentials");

		rt.setId(1111);
		rt.setBrand("Fortune");
		rt.setPrice(265);
		rt.setName("BasmatiRice");
		rt.setExpiry_Date("2022-09-13T07:00:00.000+00:00");
		rt.setType("Rice");
		rt.setQuantity("5kg");
		rt.setStock(90);
		r.add(rt);

		rt1.setCategory("Snacks-Beverages");

		rt1.setId(2111);
		rt1.setBrand("Sunfeast");
		rt1.setPrice(77);
		rt1.setName("Dark Fantacy Chaco fills");
		rt1.setExpiry_Date("2023-01-29");
		rt1.setType("Biscuits");
		rt1.setQuantity("300gm");
		rt1.setStock(5);
		r.add(rt1);

		doReturn(r).when(service).findAll();

		// perform get request

		mockMvc.perform(MockMvcRequestBuilders.get("/retail_store/search"))
				// .andExpect(status().isOk())//.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(jsonPath("$[0].category", is("Cooking_Essentials")))
				.andExpect(jsonPath("$[0].id", is(1111))).andExpect(jsonPath("$[0].brand", is("Fortune")))
				.andExpect(jsonPath("$[0].price", is(265))).andExpect(jsonPath("$[0].name", is("BasmatiRice")))
				.andExpect(jsonPath("$[0].type", is("Rice"))).andExpect(jsonPath("$[0].stock", is(90)))
				.andExpect(jsonPath("$[0].quantity", is("5kg")))
				.andExpect(jsonPath("$[0].expiry_Date", is("2022-09-13T07:00:00.000+00:00")))

				.andExpect(jsonPath("$[1].category", is("Snacks-Beverages"))).andExpect(jsonPath("$[1].id", is(2111)))
				.andExpect(jsonPath("$[1].brand", is("Sunfeast"))).andExpect(jsonPath("$[1].price", is(77)))
				.andExpect(jsonPath("$[1].name", is("Dark Fantacy Chaco fills")))
				.andExpect(jsonPath("$[1].type", is("Biscuits"))).andExpect(jsonPath("$[1].stock", is(5)))
				.andExpect(jsonPath("$[1].quantity", is("300gm")))
				.andExpect(jsonPath("$[1].expiry_Date", is("2023-01-29")));

	}

	@Test
	public void addCart() throws Exception {
		Orders ord = new Orders();// whichever data your entity class have
		Orders ord1 = new Orders(null, 2111, "Snacks-Beverages", "Biscuits", "Dark Fantacy Chaco fills", "Sunfeast",
				"300gm", 77, "2023-01-29", 3);

		RetailStore rt = new RetailStore();

		ord.setBrand("Fortune");
		ord.setCategory("Cooking_Essentials");
		ord.setCount(4);
		ord.setExpiry_Date("2022-09-13T07:00:00.000+00:00");
		ord.setId(1111);
		ord.setName("BasmatiRice");
		ord.setPrice(265);
		ord.setQuantity("5kg");
		ord.setType("Rice");
		ord.setUsername(null);

		rt.setCategory("Cooking_Essentials");
		rt.setId(1111);
		rt.setBrand("Fortune");
		rt.setPrice(265);
		rt.setName("BasmatiRice");
		rt.setExpiry_Date("2022-09-13T07:00:00.000+00:00");
		rt.setType("Rice");
		rt.setQuantity("5kg");
		rt.setStock(90);

		String inputJson = mapToJson(ord);
		String inputJson1 = mapToJson(ord1);

		doReturn(ord).when(service).placedOrder(rt.getCategory(), rt.getType(), rt.getName(), ord);
		doReturn(ord1).when(service).placedOrder("Snacks-Beverages", "Biscuits", "Dark Fantacy Chaco fills", ord1);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/retail_store/search/Cooking_Essentials/Rice/BasmatiRice/addtocart")
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andExpect(status().isOk());

		mockMvc.perform(MockMvcRequestBuilders
				.post("/retail_store/search/Snacks-Beverages/Biscuits/Dark Fantacy Chaco fills/addtocart")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson1)).andExpect(status().isOk());
		// .andExpect(jsonPath("$.category", is("Snacks-Beverages")));

		// Mockito.when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(emp);

		// .content(toJSON(ord))
		// .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
		// .andExpect(status().isOk())
		// .andExpect(content().contentType("application/json"));
	}
}
