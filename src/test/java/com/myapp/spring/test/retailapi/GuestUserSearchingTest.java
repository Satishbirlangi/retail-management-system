package com.myapp.spring.test.retailapi;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
	// MockHttpServletRequest m;
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

		var expected = "[ {\r\n" + "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1111,\r\n"
				+ "    \"type\": \"Rice\",\r\n" + "    \"quantity\": \"5kg\",\r\n" + "    \"price\": 265,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2022-09-13\",\r\n"
				+ "    \"brand\": \"Fortune\",\r\n" + "    \"stock\": 50\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1112,\r\n" + "    \"type\": \"Rice\",\r\n"
				+ "    \"quantity\": \"5kg\",\r\n" + "    \"price\": 329,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2023-09-02\",\r\n"
				+ "    \"brand\": \"Kohinoor authentic\",\r\n" + "    \"stock\": 30\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"SonamasuriRice\",\r\n" + "    \"id\": 1121,\r\n" + "    \"type\": \"Rice\",\r\n"
				+ "    \"quantity\": \"5kg\",\r\n" + "    \"price\": 427,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2021-02-11\",\r\n"
				+ "    \"brand\": \"24 Mantra Oraganic\",\r\n" + "    \"stock\": 22\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"SonamasuriRice\",\r\n" + "    \"id\": 1122,\r\n" + "    \"type\": \"Rice\",\r\n"
				+ "    \"quantity\": \"5kg\",\r\n" + "    \"price\": 265,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2022-04-13\",\r\n"
				+ "    \"brand\": \"Fortune\",\r\n" + "    \"stock\": 70\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Cooking Oil\",\r\n" + "    \"id\": 1211,\r\n" + "    \"type\": \"OilandGhee\",\r\n"
				+ "    \"quantity\": \"5lit\",\r\n" + "    \"price\": 799,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2022-12-21\",\r\n"
				+ "    \"brand\": \"Saffola Gold\",\r\n" + "    \"stock\": 30\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Refined sunflower Oil\",\r\n" + "    \"id\": 1212,\r\n"
				+ "    \"type\": \"OilandGhee\",\r\n" + "    \"quantity\": \"1lit\",\r\n" + "    \"price\": 142,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2022-11-01\",\r\n"
				+ "    \"brand\": \"Fortune\",\r\n" + "    \"stock\": 20\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Ghee\",\r\n" + "    \"id\": 1221,\r\n" + "    \"type\": \"OilandGhee\",\r\n"
				+ "    \"quantity\": \"1lit\",\r\n" + "    \"price\": 462,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2021-11-03\",\r\n"
				+ "    \"brand\": \"Mother Dairy\",\r\n" + "    \"stock\": 34\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Ghee\",\r\n" + "    \"id\": 1222,\r\n" + "    \"type\": \"OilandGhee\",\r\n"
				+ "    \"quantity\": \"1lit\",\r\n" + "    \"price\": 420,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2021-03-01\",\r\n"
				+ "    \"brand\": \"Ashirvad svasti\",\r\n" + "    \"stock\": 10\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Salt\",\r\n" + "    \"id\": 1311,\r\n" + "    \"type\": \"Salt and spices\",\r\n"
				+ "    \"quantity\": \"1kg\",\r\n" + "    \"price\": 18,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2023-03-19\",\r\n"
				+ "    \"brand\": \"Tata\",\r\n" + "    \"stock\": 100\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Salt\",\r\n" + "    \"id\": 1312,\r\n" + "    \"type\": \"Salt and spices\",\r\n"
				+ "    \"quantity\": \"1kg\",\r\n" + "    \"price\": 29,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2023-09-23\",\r\n"
				+ "    \"brand\": \"Tata Salt Lite\",\r\n" + "    \"stock\": 120\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Garam masala\",\r\n" + "    \"id\": 1321,\r\n"
				+ "    \"type\": \"Salt and spices\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 580,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2021-12-02\",\r\n" + "    \"brand\": \"Vedaka\",\r\n"
				+ "    \"stock\": 123\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Chilli Powder\",\r\n"
				+ "    \"id\": 1322,\r\n" + "    \"type\": \"Salt and spices\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 250,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2021-03-12\",\r\n" + "    \"brand\": \"Tata Sampann\",\r\n"
				+ "    \"stock\": 23\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Chana Dal\",\r\n"
				+ "    \"id\": 1411,\r\n" + "    \"type\": \"Dals\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 103,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2021-05-12\",\r\n" + "    \"brand\": \"Vedaka\",\r\n"
				+ "    \"stock\": 43\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Moong Dal\",\r\n"
				+ "    \"id\": 1412,\r\n" + "    \"type\": \"Dals\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 110,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2022-02-12\",\r\n" + "    \"brand\": \"Tata Sampann\",\r\n"
				+ "    \"stock\": 30\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Urad Dal\",\r\n"
				+ "    \"id\": 1413,\r\n" + "    \"type\": \"Dals\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 162,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2022-03-15\",\r\n" + "    \"brand\": \"Vedaka\",\r\n"
				+ "    \"stock\": 35\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Moong Chilka\",\r\n"
				+ "    \"id\": 1414,\r\n" + "    \"type\": \"Dals\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 90,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2022-01-01\",\r\n" + "    \"brand\": \"Organic\",\r\n"
				+ "    \"stock\": 45\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Sugar\",\r\n"
				+ "    \"id\": 1511,\r\n" + "    \"type\": \"Sugar\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 50,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2022-09-30\",\r\n" + "    \"brand\": \"Mawana\",\r\n"
				+ "    \"stock\": 230\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Sugar\",\r\n"
				+ "    \"id\": 1512,\r\n" + "    \"type\": \"Sugar\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 40,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2022-02-23\",\r\n" + "    \"brand\": \"Sugarlite\",\r\n"
				+ "    \"stock\": 130\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Atta\",\r\n"
				+ "    \"id\": 1611,\r\n" + "    \"type\": \"Atta-flour\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 50,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2022-03-23\",\r\n" + "    \"brand\": \"Annapoorna\",\r\n"
				+ "    \"stock\": 120\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Atta\",\r\n"
				+ "    \"id\": 1612,\r\n" + "    \"type\": \"Atta-flour\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 45,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2021-12-03\",\r\n" + "    \"brand\": \"Bhagyalakshmi\",\r\n"
				+ "    \"stock\": 150\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Maida Flour\",\r\n"
				+ "    \"id\": 1621,\r\n" + "    \"type\": \"Atta-flour\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 50,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2021-10-03\",\r\n" + "    \"brand\": \"Bhagyalakshmi\",\r\n"
				+ "    \"stock\": 250\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Wheat Flour\",\r\n"
				+ "    \"id\": 1622,\r\n" + "    \"type\": \"Atta-flour\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 60,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2022-01-23\",\r\n" + "    \"brand\": \"Vedaka\",\r\n"
				+ "    \"stock\": 210\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Ragi Flour\",\r\n"
				+ "    \"id\": 1623,\r\n" + "    \"type\": \"Atta-flour\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 20,\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"expiry_Date\": \"2022-01-09\",\r\n" + "    \"brand\": \"Annapoorna\",\r\n"
				+ "    \"stock\": 240\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Dark Fantacy Chaco fills\",\r\n"
				+ "    \"id\": 2111,\r\n" + "    \"type\": \"Biscuits\",\r\n" + "    \"quantity\": \"300gm\",\r\n"
				+ "    \"price\": 77,\r\n" + "    \"category\": \"Snacks-Beverages\",\r\n"
				+ "    \"expiry_Date\": \"2023-01-29\",\r\n" + "    \"brand\": \"Sunfeast\",\r\n"
				+ "    \"stock\": 5\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Mom's Magic Caschew\",\r\n"
				+ "    \"id\": 2121,\r\n" + "    \"type\": \"Biscuits\",\r\n" + "    \"quantity\": \"600gm\",\r\n"
				+ "    \"price\": 77,\r\n" + "    \"category\": \"Snacks-Beverages\",\r\n"
				+ "    \"expiry_Date\": \"2021-11-02\",\r\n" + "    \"brand\": \"Sunfeast\",\r\n"
				+ "    \"stock\": 201\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Oreo\",\r\n"
				+ "    \"id\": 2131,\r\n" + "    \"type\": \"Biscuits\",\r\n" + "    \"quantity\": \"300gm\",\r\n"
				+ "    \"price\": 63,\r\n" + "    \"category\": \"Snacks-Beverages\",\r\n"
				+ "    \"expiry_Date\": \"2021-10-02\",\r\n" + "    \"brand\": \"Cadbury\",\r\n"
				+ "    \"stock\": 124\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Bourbon cream biscuits\",\r\n"
				+ "    \"id\": 2141,\r\n" + "    \"type\": \"Biscuits\",\r\n" + "    \"quantity\": \"750gm\",\r\n"
				+ "    \"price\": 90,\r\n" + "    \"category\": \"Snacks-Beverages\",\r\n"
				+ "    \"expiry_Date\": \"2022-10-22\",\r\n" + "    \"brand\": \"Duke\",\r\n" + "    \"stock\": 140\r\n"
				+ "  },\r\n" + "  {\r\n" + "    \"name\": \"Horlicks\",\r\n" + "    \"id\": 2211,\r\n"
				+ "    \"type\": \"Health Drinks\",\r\n" + "    \"quantity\": \"750gm\",\r\n"
				+ "    \"price\": 254,\r\n" + "    \"category\": \"Snacks-Beverages\",\r\n"
				+ "    \"expiry_Date\": \"2022-04-21\",\r\n" + "    \"brand\": \"Horlicks\",\r\n"
				+ "    \"stock\": 80\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Cerelac\",\r\n"
				+ "    \"id\": 2221,\r\n" + "    \"type\": \"Health Drinks\",\r\n" + "    \"quantity\": \"300gm\",\r\n"
				+ "    \"price\": 185,\r\n" + "    \"category\": \"Snacks-Beverages\",\r\n"
				+ "    \"expiry_Date\": \"2021-12-21\",\r\n" + "    \"brand\": \"Nestle\",\r\n"
				+ "    \"stock\": 210\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Nangrow\",\r\n"
				+ "    \"id\": 2231,\r\n" + "    \"type\": \"Health Drinks\",\r\n" + "    \"quantity\": \"400gm\",\r\n"
				+ "    \"price\": 494,\r\n" + "    \"category\": \"Snacks-Beverages\",\r\n"
				+ "    \"expiry_Date\": \"2021-08-12\",\r\n" + "    \"brand\": \"Nestle\",\r\n"
				+ "    \"stock\": 100\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Nescafe classic Coffee\",\r\n"
				+ "    \"id\": 2311,\r\n" + "    \"type\": \"Coffee-Tea\",\r\n" + "    \"quantity\": \"100gm\",\r\n"
				+ "    \"price\": 250,\r\n" + "    \"category\": \"Snacks-Beverages\",\r\n"
				+ "    \"expiry_Date\": \"2021-06-28\",\r\n" + "    \"brand\": \"Nescafe\",\r\n"
				+ "    \"stock\": 190\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Red labe Tea\",\r\n"
				+ "    \"id\": 2321,\r\n" + "    \"type\": \"Coffee-Tea\",\r\n" + "    \"quantity\": \"500gm\",\r\n"
				+ "    \"price\": 265,\r\n" + "    \"category\": \"Snacks-Beverages\",\r\n"
				+ "    \"expiry_Date\": \"2021-09-13\",\r\n" + "    \"brand\": \"Brooke Bond\",\r\n"
				+ "    \"stock\": 410\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Chakra Gold Tea\",\r\n"
				+ "    \"id\": 2322,\r\n" + "    \"type\": \"Coffee-Tea\",\r\n" + "    \"quantity\": \"500gm\",\r\n"
				+ "    \"price\": 288,\r\n" + "    \"category\": \"Snacks-Beverages\",\r\n"
				+ "    \"expiry_Date\": \"2021-11-30\",\r\n" + "    \"brand\": \"Tata\",\r\n" + "    \"stock\": 340\r\n"
				+ "  },\r\n" + "  {\r\n" + "    \"name\": \"3 Roses Tea\",\r\n" + "    \"id\": 2323,\r\n"
				+ "    \"type\": \"Coffee-Tea\",\r\n" + "    \"quantity\": \"250gm\",\r\n" + "    \"price\": 180,\r\n"
				+ "    \"category\": \"Snacks-Beverages\",\r\n" + "    \"expiry_Date\": \"2022-01-30\",\r\n"
				+ "    \"brand\": \"Brooke Bond\",\r\n" + "    \"stock\": 190\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"MadAngles\",\r\n" + "    \"id\": 2411,\r\n" + "    \"type\": \"Snacks\",\r\n"
				+ "    \"quantity\": \"72.5gm\",\r\n" + "    \"price\": 20,\r\n"
				+ "    \"category\": \"Snacks-Beverages\",\r\n" + "    \"expiry_Date\": \"2021-11-22\",\r\n"
				+ "    \"brand\": \"Bingo\",\r\n" + "    \"stock\": 100\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Tomato Chips\",\r\n" + "    \"id\": 2421,\r\n" + "    \"type\": \"Snacks\",\r\n"
				+ "    \"quantity\": \"52.5gm\",\r\n" + "    \"price\": 20,\r\n"
				+ "    \"category\": \"Snacks-Beverages\",\r\n" + "    \"expiry_Date\": \"2022-01-22\",\r\n"
				+ "    \"brand\": \"Bingo\",\r\n" + "    \"stock\": 120\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Alu bhujiya\",\r\n" + "    \"id\": 2431,\r\n" + "    \"type\": \"Snacks\",\r\n"
				+ "    \"quantity\": \"350gm\",\r\n" + "    \"price\": 80,\r\n"
				+ "    \"category\": \"Snacks-Beverages\",\r\n" + "    \"expiry_Date\": \"2021-11-12\",\r\n"
				+ "    \"brand\": \"Haldiram's\",\r\n" + "    \"stock\": 80\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Dry Fruit Mix\",\r\n" + "    \"id\": 2441,\r\n" + "    \"type\": \"Snacks\",\r\n"
				+ "    \"quantity\": \"150gm\",\r\n" + "    \"price\": 70,\r\n"
				+ "    \"category\": \"Snacks-Beverages\",\r\n" + "    \"expiry_Date\": \"2021-06-02\",\r\n"
				+ "    \"brand\": \"Haldiram's\",\r\n" + "    \"stock\": 110\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Boondi\",\r\n" + "    \"id\": 2451,\r\n" + "    \"type\": \"Snacks\",\r\n"
				+ "    \"quantity\": \"150gm\",\r\n" + "    \"price\": 40,\r\n"
				+ "    \"category\": \"Snacks-Beverages\",\r\n" + "    \"expiry_Date\": \"2021-08-22\",\r\n"
				+ "    \"brand\": \"Haldiram's\",\r\n" + "    \"stock\": 130\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Oats\",\r\n" + "    \"id\": 3111,\r\n" + "    \"type\": \"Breakfast Foods\",\r\n"
				+ "    \"quantity\": \"1kg\",\r\n" + "    \"price\": 160,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2021-11-21\",\r\n"
				+ "    \"brand\": \"Quaker\",\r\n" + "    \"stock\": 230\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Oats\",\r\n" + "    \"id\": 3112,\r\n" + "    \"type\": \"Breakfast Foods\",\r\n"
				+ "    \"quantity\": \"500gm\",\r\n" + "    \"price\": 169,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2021-10-06\",\r\n"
				+ "    \"brand\": \"Saffola\",\r\n" + "    \"stock\": 127\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Oats\",\r\n" + "    \"id\": 3113,\r\n" + "    \"type\": \"Breakfast Foods\",\r\n"
				+ "    \"quantity\": \"1kg\",\r\n" + "    \"price\": 436,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2022-12-06\",\r\n"
				+ "    \"brand\": \"DiSano\",\r\n" + "    \"stock\": 72\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Cornflakes\",\r\n" + "    \"id\": 3121,\r\n"
				+ "    \"type\": \"Breakfast Foods\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 149,\r\n" + "    \"category\": \"Packaged-Foods\",\r\n"
				+ "    \"expiry_Date\": \"2022-02-16\",\r\n" + "    \"brand\": \"Kellog's\",\r\n"
				+ "    \"stock\": 220\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Caregrow\",\r\n"
				+ "    \"id\": 3122,\r\n" + "    \"type\": \"Breakfast Foods\",\r\n"
				+ "    \"quantity\": \"355gm\",\r\n" + "    \"price\": 355,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2021-12-06\",\r\n"
				+ "    \"brand\": \"Nestle\",\r\n" + "    \"stock\": 120\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Chacos\",\r\n" + "    \"id\": 3131,\r\n" + "    \"type\": \"Breakfast Foods\",\r\n"
				+ "    \"quantity\": \"255gm\",\r\n" + "    \"price\": 275,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2022-04-16\",\r\n"
				+ "    \"brand\": \"Solimo\",\r\n" + "    \"stock\": 540\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Chacos\",\r\n" + "    \"id\": 3141,\r\n" + "    \"type\": \"Breakfast Foods\",\r\n"
				+ "    \"quantity\": \"1.2g\",\r\n" + "    \"price\": 410,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2021-09-06\",\r\n"
				+ "    \"brand\": \"Kellog's\",\r\n" + "    \"stock\": 440\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Honey\",\r\n" + "    \"id\": 3211,\r\n" + "    \"type\": \"Sauces and Spreads\",\r\n"
				+ "    \"quantity\": \"400gm\",\r\n" + "    \"price\": 231,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2021-05-02\",\r\n"
				+ "    \"brand\": \"Dabur\",\r\n" + "    \"stock\": 75\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Honey\",\r\n" + "    \"id\": 3212,\r\n" + "    \"type\": \"Sauces and Spreads\",\r\n"
				+ "    \"quantity\": \"1kg\",\r\n" + "    \"price\": 440,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2021-06-20\",\r\n"
				+ "    \"brand\": \"Saffola\",\r\n" + "    \"stock\": 105\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Eggless Mayonnaise\",\r\n" + "    \"id\": 3221,\r\n"
				+ "    \"type\": \"Sauces and Spreads\",\r\n" + "    \"quantity\": \"900gm\",\r\n"
				+ "    \"price\": 150,\r\n" + "    \"category\": \"Packaged-Foods\",\r\n"
				+ "    \"expiry_Date\": \"2021-04-30\",\r\n" + "    \"brand\": \"Del monte\",\r\n"
				+ "    \"stock\": 325\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Ginger Garlic Paste\",\r\n"
				+ "    \"id\": 3231,\r\n" + "    \"type\": \"Sauces and Spreads\",\r\n"
				+ "    \"quantity\": \"900gm\",\r\n" + "    \"price\": 150,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2021-04-30\",\r\n"
				+ "    \"brand\": \"Dabur\",\r\n" + "    \"stock\": 325\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Red Chilli Sauce\",\r\n" + "    \"id\": 3241,\r\n"
				+ "    \"type\": \"Sauces and Spreads\",\r\n" + "    \"quantity\": \"200gm\",\r\n"
				+ "    \"price\": 50,\r\n" + "    \"category\": \"Packaged-Foods\",\r\n"
				+ "    \"expiry_Date\": \"2021-04-14\",\r\n" + "    \"brand\": \"WeikField\",\r\n"
				+ "    \"stock\": 125\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"TomatoPuree\",\r\n"
				+ "    \"id\": 3251,\r\n" + "    \"type\": \"Sauces and Spreads\",\r\n"
				+ "    \"quantity\": \"200gm\",\r\n" + "    \"price\": 20,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2021-03-24\",\r\n"
				+ "    \"brand\": \"Dabur\",\r\n" + "    \"stock\": 150\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Rava idli mix\",\r\n" + "    \"id\": 3311,\r\n"
				+ "    \"type\": \"Ready Meals and Mixes\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 134,\r\n" + "    \"category\": \"Packaged-Foods\",\r\n"
				+ "    \"expiry_Date\": \"2021-04-30\",\r\n" + "    \"brand\": \"MTR\",\r\n" + "    \"stock\": 100\r\n"
				+ "  },\r\n" + "  {\r\n" + "    \"name\": \"Dosa mix\",\r\n" + "    \"id\": 3321,\r\n"
				+ "    \"type\": \"Ready Meals and Mixes\",\r\n" + "    \"quantity\": \"1kg\",\r\n"
				+ "    \"price\": 100,\r\n" + "    \"category\": \"Packaged-Foods\",\r\n"
				+ "    \"expiry_Date\": \"2021-04-04\",\r\n" + "    \"brand\": \"MTR\",\r\n" + "    \"stock\": 190\r\n"
				+ "  },\r\n" + "  {\r\n" + "    \"name\": \"Dosa mix\",\r\n" + "    \"id\": 3322,\r\n"
				+ "    \"type\": \"Ready Meals and Mixes\",\r\n" + "    \"quantity\": \"180gm\",\r\n"
				+ "    \"price\": 46,\r\n" + "    \"category\": \"Packaged-Foods\",\r\n"
				+ "    \"expiry_Date\": \"2021-04-14\",\r\n" + "    \"brand\": \"Tata Sampann\",\r\n"
				+ "    \"stock\": 30\r\n" + "  },\r\n" + "  {\r\n" + "    \"name\": \"Masala Upma\",\r\n"
				+ "    \"id\": 3331,\r\n" + "    \"type\": \"Ready Meals and Mixes\",\r\n"
				+ "    \"quantity\": \"180gm\",\r\n" + "    \"price\": 65,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2021-09-04\",\r\n"
				+ "    \"brand\": \"MTR\",\r\n" + "    \"stock\": 221\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Thick Tomato Soup\",\r\n" + "    \"id\": 3341,\r\n"
				+ "    \"type\": \"Ready Meals and Mixes\",\r\n" + "    \"quantity\": \"53gm\",\r\n"
				+ "    \"price\": 42,\r\n" + "    \"category\": \"Packaged-Foods\",\r\n"
				+ "    \"expiry_Date\": \"2021-09-14\",\r\n" + "    \"brand\": \"Knorr\",\r\n" + "    \"stock\": 21\r\n"
				+ "  },\r\n" + "  {\r\n" + "    \"name\": \"Choclairs\",\r\n" + "    \"id\": 3411,\r\n"
				+ "    \"type\": \"Chacolates\",\r\n" + "    \"quantity\": \"175gm\",\r\n" + "    \"price\": 50,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2021-12-01\",\r\n"
				+ "    \"brand\": \"Cadbury\",\r\n" + "    \"stock\": 40\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Hot Chacolate\",\r\n" + "    \"id\": 3412,\r\n" + "    \"type\": \"Chacolates\",\r\n"
				+ "    \"quantity\": \"200gm\",\r\n" + "    \"price\": 166,\r\n"
				+ "    \"category\": \"Packaged-Foods\",\r\n" + "    \"expiry_Date\": \"2022-02-21\",\r\n"
				+ "    \"brand\": \"Cadbury\",\r\n" + "    \"stock\": 120\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Hair Oil\",\r\n" + "    \"id\": 4111,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"1lit\",\r\n" + "    \"price\": 327,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-12-21\",\r\n"
				+ "    \"brand\": \"Parachute\",\r\n" + "    \"stock\": 30\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Hair Oil\",\r\n" + "    \"id\": 4112,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"640ml\",\r\n" + "    \"price\": 200,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-02-02\",\r\n"
				+ "    \"brand\": \"Vatika\",\r\n" + "    \"stock\": 40\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Hair Oil\",\r\n" + "    \"id\": 4113,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"500ml\",\r\n" + "    \"price\": 362,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-12-12\",\r\n"
				+ "    \"brand\": \"Induleka\",\r\n" + "    \"stock\": 50\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Hair Oil\",\r\n" + "    \"id\": 4114,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"120ml\",\r\n" + "    \"price\": 80,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-01-12\",\r\n"
				+ "    \"brand\": \"Parachute Ayurvedic\",\r\n" + "    \"stock\": 59\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Shampoo\",\r\n" + "    \"id\": 4121,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"1lit\",\r\n" + "    \"price\": 490,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-02-01\",\r\n"
				+ "    \"brand\": \"Dove\",\r\n" + "    \"stock\": 60\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Shampoo\",\r\n" + "    \"id\": 4122,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"1lit\",\r\n" + "    \"price\": 400,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-12-11\",\r\n"
				+ "    \"brand\": \"Clinic Plus\",\r\n" + "    \"stock\": 90\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Shampoo\",\r\n" + "    \"id\": 4123,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"190\",\r\n" + "    \"price\": 150,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-09-01\",\r\n"
				+ "    \"brand\": \"TRESemme\",\r\n" + "    \"stock\": 93\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Shampoo\",\r\n" + "    \"id\": 4124,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"600ml\",\r\n" + "    \"price\": 453,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-09-12\",\r\n"
				+ "    \"brand\": \"Head&Shoulders\",\r\n" + "    \"stock\": 34\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Conditioners\",\r\n" + "    \"id\": 4131,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"190ml\",\r\n" + "    \"price\": 166,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-09-19\",\r\n"
				+ "    \"brand\": \"L'Oreals Paris\",\r\n" + "    \"stock\": 45\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Conditioners\",\r\n" + "    \"id\": 4132,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"250ml\",\r\n" + "    \"price\": 230,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-02-11\",\r\n"
				+ "    \"brand\": \"Head&Shoulders\",\r\n" + "    \"stock\": 70\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Conditioners\",\r\n" + "    \"id\": 4133,\r\n" + "    \"type\": \"HairCare\",\r\n"
				+ "    \"quantity\": \"150ml\",\r\n" + "    \"price\": 234,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-12-11\",\r\n"
				+ "    \"brand\": \"Himalaya\",\r\n" + "    \"stock\": 410\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Body Lotions\",\r\n" + "    \"id\": 4211,\r\n" + "    \"type\": \"Body Care\",\r\n"
				+ "    \"quantity\": \"400ml\",\r\n" + "    \"price\": 299,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-01-21\",\r\n"
				+ "    \"brand\": \"Nivea\",\r\n" + "    \"stock\": 80\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Body Lotions\",\r\n" + "    \"id\": 4212,\r\n" + "    \"type\": \"Body care\",\r\n"
				+ "    \"quantity\": \"400ml\",\r\n" + "    \"price\": 241,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-01-02\",\r\n"
				+ "    \"brand\": \"Vaseline\",\r\n" + "    \"stock\": 60\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Body Lotions\",\r\n" + "    \"id\": 4213,\r\n" + "    \"type\": \"Body care\",\r\n"
				+ "    \"quantity\": \"150ml\",\r\n" + "    \"price\": 239,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-10-27\",\r\n"
				+ "    \"brand\": \"Ponds\",\r\n" + "    \"stock\": 20\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Perfumes\",\r\n" + "    \"id\": 4221,\r\n" + "    \"type\": \"Body care\",\r\n"
				+ "    \"quantity\": \"150ml\",\r\n" + "    \"price\": 140,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-10-08\",\r\n"
				+ "    \"brand\": \"Axe\",\r\n" + "    \"stock\": 212\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Perfumes\",\r\n" + "    \"id\": 4222,\r\n" + "    \"type\": \"Body care\",\r\n"
				+ "    \"quantity\": \"220ml\",\r\n" + "    \"price\": 224,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-11-18\",\r\n"
				+ "    \"brand\": \"Engage\",\r\n" + "    \"stock\": 22\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Perfumes\",\r\n" + "    \"id\": 4223,\r\n" + "    \"type\": \"Body care\",\r\n"
				+ "    \"quantity\": \"100ml\",\r\n" + "    \"price\": 90,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-11-18\",\r\n"
				+ "    \"brand\": \"Spinz\",\r\n" + "    \"stock\": 10\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Perfumes\",\r\n" + "    \"id\": 4224,\r\n" + "    \"type\": \"Body care\",\r\n"
				+ "    \"quantity\": \"250ml\",\r\n" + "    \"price\": 845,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-11-01\",\r\n"
				+ "    \"brand\": \"Beat\",\r\n" + "    \"stock\": 80\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Deodorants\",\r\n" + "    \"id\": 4231,\r\n" + "    \"type\": \"Body care\",\r\n"
				+ "    \"quantity\": \"150ml\",\r\n" + "    \"price\": 104,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-06-12\",\r\n"
				+ "    \"brand\": \"Fresh\",\r\n" + "    \"stock\": 120\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Deodorants\",\r\n" + "    \"id\": 4232,\r\n" + "    \"type\": \"Body care\",\r\n"
				+ "    \"quantity\": \"100ml\",\r\n" + "    \"price\": 248,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-06-11\",\r\n"
				+ "    \"brand\": \"Solimo\",\r\n" + "    \"stock\": 80\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Deodorants\",\r\n" + "    \"id\": 4233,\r\n" + "    \"type\": \"Body care\",\r\n"
				+ "    \"quantity\": \"150ml\",\r\n" + "    \"price\": 159,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-12-31\",\r\n"
				+ "    \"brand\": \"Nivea pearl and beauty\",\r\n" + "    \"stock\": 30\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Tooth Paste\",\r\n" + "    \"id\": 4311,\r\n" + "    \"type\": \"Oral Care\",\r\n"
				+ "    \"quantity\": \"185gm\",\r\n" + "    \"price\": 122,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-11-03\",\r\n"
				+ "    \"brand\": \"Colgate\",\r\n" + "    \"stock\": 100\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Tooth Paste\",\r\n" + "    \"id\": 4312,\r\n" + "    \"type\": \"Oral Care\",\r\n"
				+ "    \"quantity\": \"300gm\",\r\n" + "    \"price\": 103,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-08-13\",\r\n"
				+ "    \"brand\": \"CloseUp\",\r\n" + "    \"stock\": 190\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Tooth Paste\",\r\n" + "    \"id\": 4313,\r\n" + "    \"type\": \"Oral Care\",\r\n"
				+ "    \"quantity\": \"400gm\",\r\n" + "    \"price\": 125,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-09-23\",\r\n"
				+ "    \"brand\": \"Meswak\",\r\n" + "    \"stock\": 120\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Tooth Paste\",\r\n" + "    \"id\": 4314,\r\n" + "    \"type\": \"Oral Care\",\r\n"
				+ "    \"quantity\": \"300gm\",\r\n" + "    \"price\": 96,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-10-03\",\r\n"
				+ "    \"brand\": \"DaburRed\",\r\n" + "    \"stock\": 50\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Tooth Brush\",\r\n" + "    \"id\": 4321,\r\n" + "    \"type\": \"Oral Care\",\r\n"
				+ "    \"quantity\": \"1pc\",\r\n" + "    \"price\": 75,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-01-13\",\r\n"
				+ "    \"brand\": \"Oral-B\",\r\n" + "    \"stock\": 20\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Tooth Brush\",\r\n" + "    \"id\": 4322,\r\n" + "    \"type\": \"Oral Care\",\r\n"
				+ "    \"quantity\": \"1pc\",\r\n" + "    \"price\": 99,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-01-29\",\r\n"
				+ "    \"brand\": \"Colgate\",\r\n" + "    \"stock\": 120\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Face Wash\",\r\n" + "    \"id\": 4411,\r\n" + "    \"type\": \"Face Care\",\r\n"
				+ "    \"quantity\": \"150ml\",\r\n" + "    \"price\": 175,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-09-09\",\r\n"
				+ "    \"brand\": \"Clean&Clear\",\r\n" + "    \"stock\": 90\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Face Wash\",\r\n" + "    \"id\": 4412,\r\n" + "    \"type\": \"Face Care\",\r\n"
				+ "    \"quantity\": \"200ml\",\r\n" + "    \"price\": 260,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2022-01-01\",\r\n"
				+ "    \"brand\": \"Ponds\",\r\n" + "    \"stock\": 80\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Lipbalm\",\r\n" + "    \"id\": 4421,\r\n" + "    \"type\": \"Face Care\",\r\n"
				+ "    \"quantity\": \"1.2gm\",\r\n" + "    \"price\": 128,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-07-21\",\r\n"
				+ "    \"brand\": \"Nivea\",\r\n" + "    \"stock\": 30\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"Lipbalm\",\r\n" + "    \"id\": 4422,\r\n" + "    \"type\": \"Face Care\",\r\n"
				+ "    \"quantity\": \"4gm\",\r\n" + "    \"price\": 157,\r\n"
				+ "    \"category\": \"Personal Care\",\r\n" + "    \"expiry_Date\": \"2021-08-15\",\r\n"
				+ "    \"brand\": \"Maybelline NewYork\",\r\n" + "    \"stock\": 40\r\n" + "  }\r\n" + "]";
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

		var expected = "[ {\r\n" + "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1111,\r\n"
				+ "    \"type\": \"Rice\",\r\n" + "    \"quantity\": \"5kg\",\r\n" + "    \"price\": 265,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2022-09-13\",\r\n"
				+ "    \"brand\": \"Fortune\",\r\n" + "    \"stock\": 50\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"BasmatiRice\"  }\r\n" + "]";
		// doReturn(r).when(service).findAll();

		mockMvc.perform(
				MockMvcRequestBuilders.get("/retail_store/search/{Category}/{Type}", "Cooking_Essentials", "Rice"))
				// .accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*", isA(ArrayList.class)));
	}

	@Test
	public void SearchingByName() throws Exception {

		// ListRetailStore

		var expected = "[ {\r\n" + "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1111,\r\n"
				+ "    \"type\": \"Rice\",\r\n" + "    \"quantity\": \"5kg\",\r\n" + "    \"price\": 265,\r\n"
				+ "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"expiry_Date\": \"2022-09-13\",\r\n"
				+ "    \"brand\": \"Fortune\",\r\n" + "    \"stock\": 50\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"name\": \"BasmatiRice\"  }\r\n" + "]";
		// doReturn(r).when(service).findAll();

		mockMvc.perform(MockMvcRequestBuilders.get("/retail_store/search/{Category}/{Type}/{Name}",
				"Cooking_Essentials", "Rice", "BasmatiRice"))
				// .accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*", isA(ArrayList.class)));
	}

}