package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Orders;
import com.myapp.spring.model.RetailStore;
import com.myapp.spring.repository.RetailStoreRepository;

@RestController
@RequestMapping("/retail_store")

public class RetailApi {

	@Autowired

	private RetailStoreRepository repository;

	@GetMapping("/search")
	public List<RetailStore> findAll() {
		return repository.findAll();
	}

	@GetMapping("/search/{Category}")
	public List<RetailStore> findByCategory(@PathVariable("Category") String Category) {
		return repository.findByCategory(Category);
	}

	@GetMapping("/search/{Category}/{Type}")
	public List<RetailStore> findByType(@PathVariable("Category") String Category, @PathVariable("Type") String Type) {
		return repository.findByType(Category, Type);
	}

	@GetMapping("/search/{Category}/{Type}/{Name}")
	public List<RetailStore> findByName(@PathVariable("Category") String Category, @PathVariable("Type") String Type,
			@PathVariable("Name") String Name) {
		return repository.findByName(Category, Type, Name);
	}

	/*
	 * @PostMapping("/{Category}/{Type}/{Name}/addtocart/signup") public Credentials
	 * saveCredentials(@PathVariable("Category") String
	 * Category, @PathVariable("Type") String Type,
	 * 
	 * @PathVariable("Name") String Name, @RequestBody Credentials Cred) {
	 * 
	 * return repository.saveCredentials(Category, Type, Name, Cred); }
	 */
	@PostMapping("/search/{Category}/{Type}/{Name}/addtocart")
	public Orders placedOrder(@PathVariable("Category") String Category, @PathVariable("Type") String Type,
			@PathVariable("Name") String Name, @RequestBody Orders Ord) {

		return repository.placedOrder(Category, Type, Name, Ord);
	}

}
