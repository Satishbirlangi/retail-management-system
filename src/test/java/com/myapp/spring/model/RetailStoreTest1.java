package com.myapp.spring.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.springframework.http.HttpStatus;

class RetailStoreTest1 extends RetailStore {
	public void test1() {

		String Category1 = "Cooking_Essentials";

		String Type1 = "Rice";

		String Name1 = "BasmatiRice";

		assertEquals("true", validate(Category1, Type1, Name1));

	}

}