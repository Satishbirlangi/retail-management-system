package com.myapp.spring.tdd.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.myapp.spring.model.Orders;
import com.myapp.spring.model.RetailStore;
import com.myapp.spring.model.UserData;
import com.myapp.spring.responseType.ResponseType;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

@SpringBootTest

//spring context
//environment
//loading the beans
//start the embeded tomcat server
@AutoConfigureMockMvc
public class UserLoginRestAPITest {

	@MockBean
	private UserLoginRestAPITest service;
	ResponseType r = new ResponseType();
	MockHttpServletRequest m;
	@Autowired
	private MockMvc mockMvc;

	UserData user[] = null;
	UserData ud = new UserData();

	@Test
	@Order(1)
	public void ValidatingUser() throws Exception {
		ud.setUsername("admin");
		ud.setPassword("admin");
		String k = "{\r\n" + "     \"username\":\"admin\",\r\n" + "    \"password\":\"admin\"\r\n" + "  }";
//		doReturn(r).when(service).validateLogin(ud, m);
		String expectedjson = "{\r\n" + "  \"errcode\": 200,\r\n" + "  \"status\": \"success\",\r\n"
				+ "  \"message\": \"Valid User\",\r\n" + "  \"run\": null\r\n" + "}";

		mockMvc.perform(post("/retail_store/validate-user").contentType(MediaType.APPLICATION_JSON).content(k))
				// .accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(expectedjson));
	}

	@Test
	@Order(2)
	public void testSearchRegisteredUser() throws Exception {
		MockHttpSession session = new MockHttpSession();
		ud.setUsername("admin");
		ud.setPassword("admin");

		session.setAttribute("isAuthenticated", true);

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/retail_store/reg_search", m)

				.session(session);

		mockMvc.perform(builder).andDo(print())

				.andExpect(MockMvcResultMatchers.status()

						.isOk());

	}

	@Test
	@Order(3)
	public void testSearchRegisteredUserByCategory() throws Exception {
		MockHttpSession session = new MockHttpSession();
		ud.setUsername("admin");
		ud.setPassword("admin");

		session.setAttribute("isAuthenticated", true);
		RetailStore rt = new RetailStore();
		rt.setCategory("Cooking_Essentials");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/retail_store/reg_search/{Category}", rt.getCategory(), m)

				.session(session);

		mockMvc.perform(builder).andDo(print())

				.andExpect(MockMvcResultMatchers.status()

						.isOk());

	}

	@Test
	@Order(4)
	public void testSearchRegisteredUserByType() throws Exception {
		MockHttpSession session = new MockHttpSession();
		ud.setUsername("admin");
		ud.setPassword("admin");

		session.setAttribute("isAuthenticated", true);
		RetailStore rt = new RetailStore();

		rt.setCategory("Cooking_Essentials");
		rt.setType("Rice");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/retail_store/reg_search/{Category}/{Type}", rt.getCategory(), rt.getType(), m)

				.session(session);

		mockMvc.perform(builder).andDo(print())

				.andExpect(MockMvcResultMatchers.status()

						.isOk());

	}

	@Test
	@Order(5)
	public void testSearchRegisteredUserByName() throws Exception {
		MockHttpSession session = new MockHttpSession();
		ud.setUsername("admin");
		ud.setPassword("admin");

		session.setAttribute("isAuthenticated", true);
		RetailStore rt = new RetailStore();

		rt.setCategory("Cooking_Essentials");
		rt.setType("Rice");
		rt.setName("BasmatiRice");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/retail_store/reg_search/{Category}/{Type}/{Name}", rt.getCategory(), rt.getType(), rt.getName(),
						m)

				.session(session);

		mockMvc.perform(builder).andDo(print())

				.andExpect(MockMvcResultMatchers.status()

						.isOk());

	}

	/*
	 * @Test
	 * 
	 * @Order(6) public void testSearchRegisteredUserAddToCart() throws Exception {
	 * MockHttpSession session = new MockHttpSession(); MockHttpSession session1 =
	 * new MockHttpSession();
	 * 
	 * ud.setUsername("admin"); ud.setPassword("admin");
	 * 
	 * session.setAttribute("isAuthenticated", true);
	 * session1.setAttribute("registeredusername", true); Orders o = new Orders();
	 * RetailStore rt = new RetailStore(); o.setId(1111);
	 * o.setCategory("Cooking_Essentials"); o.setType("Rice");
	 * o.setName("BasmatiRice"); o.setBrand("Fortune"); o.setCount(50);
	 * o.setExpiry_Date("2022-09-13"); o.setQuantity("5kg"); o.setPrice(265);
	 * rt.setCategory("Cooking_Essentials"); rt.setType("Rice");
	 * rt.setName("BasmatiRice"); o.setUsername("admin");
	 * MockHttpServletRequestBuilder builder = MockMvcRequestBuilders .post(
	 * "/retail_store/reg_search/Cooking_Essentials/Rice/BasmatiRice/RegUseraddtocart",
	 * rt.getCategory(), rt.getType(), rt.getName(), o, m)
	 * 
	 * .session(session).session(session1);
	 * 
	 * mockMvc.perform(builder).andDo(print()).andExpect(MockMvcResultMatchers.
	 * status()
	 * 
	 * .isOk()); }
	 * 
	 * @Test
	 * 
	 * @Order(7) public void newtestSearchRegisteredUserAddToCart() throws Exception
	 * { MockHttpSession session = new MockHttpSession(); MockHttpSession session1 =
	 * new MockHttpSession();
	 * 
	 * ud.setUsername("admin"); ud.setPassword("admin");
	 * 
	 * session.setAttribute("isAuthenticated", true);
	 * session1.setAttribute("registeredusername", true); Orders o = new Orders();
	 * RetailStore rt = new RetailStore(); o.setId(1111);
	 * o.setCategory("Cooking_Essentials"); o.setType("Rice");
	 * o.setName("BasmatiRice"); o.setBrand("Fortune"); o.setCount(50);
	 * o.setExpiry_Date("2022-09-13"); o.setQuantity("5kg"); o.setPrice(265);
	 * rt.setCategory("Cooking_Essentials"); rt.setType("Rice");
	 * rt.setName("BasmatiRice"); o.setUsername("admin"); //
	 * MockHttpServletRequestBuilder builder = MockMvcRequestBuilders // .post(
	 * "/retail_store/reg_search/Cooking_Essentials/Rice/BasmatiRice/RegUseraddtocart",
	 * // rt.getCategory(), // rt.getType(), rt.getName(), o, m) //
	 * 
	 * // mockMvc.perform(builder).andDo(print()).andExpect(MockMvcResultMatchers.
	 * status()
	 * 
	 * var k = "{\\r\\n\"\r\n" +
	 * "				+ \"    \\\"username\\\":\\\"admin\\\",\\r\\n\"\r\n" +
	 * "				+ \"    \\\"name\\\": \\\"BasmatiRice\\\",\\r\\n\"\r\n" +
	 * "				+ \"    \\\"id\\\": 1111,\\r\\n\"\r\n" +
	 * "				+ \"    \\\"type\\\": \\\"Rice\\\",\\r\\n\"\r\n" +
	 * "				+ \"    \\\"price\\\": 265,\\r\\n\"\r\n" +
	 * "				+ \"    \\\"expiry_Date\\\": \\\"2022-09-13\\\",\\r\\n\"\r\n"
	 * + "				+ \"    \\\"quantity\\\": \\\"5kg\\\",\\r\\n\"\r\n" +
	 * "				+ \"    \\\"category\\\": \\\"Cooking_Essentials\\\",\\r\\n\"\r\n"
	 * + "				+ \"    \\\"brand\\\": \\\"Fortune\\\",\\r\\n\"\r\n" +
	 * "				+ \"    \\\"count\\\": 5\\r\\n\"\r\n" +
	 * "				+ \"  }"; var expectedjson = "{\r\n" +
	 * "  \"username\": \"admin\",\r\n" + "  \"id\": 1111,\r\n" +
	 * "  \"category\": \"Cooking_Essentials\",\r\n" + "  \"type\": \"Rice\",\r\n" +
	 * "  \"name\": \"BasmatiRice\",\r\n" + "  \"brand\": \"Fortune\",\r\n" +
	 * "  \"quantity\": \"5kg\",\r\n" + "  \"price\": 265,\r\n" +
	 * "  \"expiry_Date\": \"2022-09-13\",\r\n" + "  \"count\": 5\r\n" + "}";
	 * mockMvc.perform(post("/retail_store/validate-user").contentType(MediaType.
	 * APPLICATION_JSON).content(k)
	 * .session(session).session(session1)).andDo(print()).andExpect(content().json(
	 * expectedjson));
	 * 
	 * }
	 */@Test
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
		/*
		 * var or = "{\r\n" + "  \"username\": null,\r\n" + "  \"id\": 1111,\r\n" +
		 * "  \"category\": \"Cooking_Essentials\",\r\n" + "  \"type\": \"Rice\",\r\n" +
		 * "  \"name\": \"BasmatiRice\",\r\n" + "  \"brand\": \"Fortune\",\r\n" +
		 * "  \"quantity\": \"5kg\",\r\n" + "  \"price\": 265,\r\n" +
		 * "  \"expiry_Date\": \"2022-09-13\",\r\n" + "  \"count\": 5\r\n" + "}";
		 */
//ArrayList<String> p=new ArrayList<>();
		String p = "{\r\n" + "    \"name\": \"BasmatiRice\",\r\n" + "    \"id\": 1111,\r\n"
				+ "    \"type\": \"Rice\",\r\n" + "    \"price\": 265,\r\n" + "    \"expiry_Date\": \"2022-09-13\",\r\n"
				+ "    \"quantity\": \"5kg\",\r\n" + "    \"category\": \"Cooking_Essentials\",\r\n"
				+ "    \"brand\": \"Fortune\",\r\n" + "    \"count\": 5\r\n" + "  }";

		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(p);

		// Read more:
		// https://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz6pGXdgUnj
		mockMvc.perform(MockMvcRequestBuilders.post("/retail_store/search/{Category}/{Type}/{Name}/addtocart",
				rt.getCategory(), rt.getType(), rt.getName(), o, m).contentType(MediaType.APPLICATION_JSON).content(p))
				// .accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void ValidatingnonUser() throws Exception {
		ud.setUsername("admin");
		ud.setPassword("admin");
		String k = "{\r\n" + "     \"username\":\"addmin\",\r\n" + "    \"password\":\"admin\"\r\n" + "  }";
//		doReturn(r).when(service).validateLogin(ud, m);
		String expectedjson = "{\r\n" + "  \"errcode\": 404,\r\n" + "  \"status\": \"failure\",\r\n"
				+ "  \"message\": \"InValid User\",\r\n" + "  \"run\": null\r\n" + "}";
		mockMvc.perform(post("/retail_store/validate-user").contentType(MediaType.APPLICATION_JSON).content(k))
				// .accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(expectedjson));
	}

}