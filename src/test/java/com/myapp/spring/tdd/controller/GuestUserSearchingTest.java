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

//spring context
//environment
//loading the beans
//start the embeded tomcat server
@AutoConfigureMockMvc
public class GuestUserSearchingTest {
	@MockBean
	private RetailStoreRepository service;
	MockHttpServletRequest m;
	@Autowired
	private MockMvc mockMvc;

	// private static File DATA_JSON = Paths.get("src", "test", "resources",
	// "retaildata.json").toFile();
	// RetailStore r[] = null;

	/*
	 * 
	 * 
	 * @BeforeEach / void setup() throws JsonParseException, JsonMappingException,
	 * IOException { System.out.println("running"); // products =
	 * (List<RetailStore>[]) new ObjectMapper().readValue(DATA_JSON, //
	 * RetailStore[].class); r = new ObjectMapper().readValue(DATA_JSON,
	 * RetailStore[].class);
	 * 
	 * }
	 * 
	 * String mapToJson(Object obj) throws JsonProcessingException { ObjectMapper
	 * objectMapper = new ObjectMapper(); return
	 * objectMapper.writeValueAsString(obj); }
	 */

	@Test
	public void SearchingByTheGuestUser() throws Exception {

		// ListRetailStore

		// doReturn(r).when(service).findAll();

		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8989/retail_store/search/search"))
				// .accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*", isA(ArrayList.class)));
	}

	@Test
	public void SearchingByCategory() throws Exception {

		// ListRetailStore

		// doReturn(r).when(service).findAll();

		mockMvc.perform(MockMvcRequestBuilders.get("/retail_store/search/{Category}", "Cooking_Essentials"))
				// .accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*", isA(ArrayList.class)));
	}

	@Test
	public void SearchingByType() throws Exception {

		// ListRetailStore

<<<<<<< HEAD
		String expected = "[ {\r\n" + "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1111,\r\n"
=======
		/*var expected = "[ {\r\n" + "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1111,\r\n"
>>>>>>> c4da5b11af4971f659e2d8aece20d1dae4405777
				+ "    \"type\": \"Rice\",\r\n" + "    \"quantity\": \"5kg\",\r\n" + "    \"price\": 265,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2022-09-13\",\r\n"
				+ "    \"brand\": \"Fortune\",\r\n" + "    \"stock\": 50\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"BasmatiRice\"  }\r\n" + "]"; */
		// doReturn(r).when(service).findAll();

		mockMvc.perform(
				MockMvcRequestBuilders.get("/retail_store/search/{Category}/{Type}", "Cooking_Essentials", "Rice"))
				// .accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*", isA(ArrayList.class)));
	}

	@Test
	public void SearchingByName() throws Exception {

		// ListRetailStore

<<<<<<< HEAD
		String expected = "[ {\r\n" + "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1111,\r\n"
=======
		/*var expected = "[ {\r\n" + "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1111,\r\n"
>>>>>>> c4da5b11af4971f659e2d8aece20d1dae4405777
				+ "    \"type\": \"Rice\",\r\n" + "    \"quantity\": \"5kg\",\r\n" + "    \"price\": 265,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2022-09-13\",\r\n"
				+ "    \"brand\": \"Fortune\",\r\n" + "    \"stock\": 50\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"BasmatiRice\"  }\r\n" + "]";*/
		// doReturn(r).when(service).findAll();

		mockMvc.perform(MockMvcRequestBuilders.get("/retail_store/search/{Category}/{Type}/{Name}",
				"Cooking_Essentials", "Rice", "BasmatiRice"))
				// .accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*", isA(ArrayList.class)));
	}

	@Test
	public void TestingAddtocartforguestuser() throws Exception {

		// ListRetailStore

		// doReturn(r).when(service).findAll();
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
		String or = "{\r\n" + "  \"username\": null,\r\n" + "  \"id\": 1111,\r\n"
				+ "  \"category\": \"Cooking_Essentials\",\r\n" + "  \"type\": \"Rice\",\r\n"
				+ "  \"name\": \"BasmatiRice\",\r\n" + "  \"brand\": \"Fortune\",\r\n" + "  \"quantity\": \"5kg\",\r\n"
				+ "  \"price\": 265,\r\n" + "  \"expiry_Date\": \"2022-09-13\",\r\n" + "  \"count\": 5\r\n" + "}";
		String pl = "{\r\n" + "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1111,\r\n"
				+ "    \"type\": \"Rice\",\r\n" + "    \"price\": 265,\r\n" + "    \"expiry_Date\": \"2022-09-13\",\r\n"
				+ "    \"quantity\": \"5kg\",\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"brand\": \"Fortune\",\r\n" + "    \"count\": 5\r\n" + "  }";
		mockMvc.perform(MockMvcRequestBuilders.post("/retail_store/search/{Category}/{Type}/{Name}/addtocart",
				rt.getCategory(), rt.getType(), rt.getName(), o, m).contentType(MediaType.APPLICATION_JSON).content(pl))
				// .accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

	}

}
