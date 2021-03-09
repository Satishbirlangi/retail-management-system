package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.myapp.spring.model.Credentials;
import com.myapp.spring.model.Orders;
import com.myapp.spring.model.RetailStore;

@Repository // It's a data Repository Class
public class RetailStoreRepositoryImpl implements RetailStoreRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<RetailStore> findAll() {
		// TODO Auto-generated method stub
		// return null;
		return jdbcTemplate.query("select * from retail_store", new BeanPropertyRowMapper<>(RetailStore.class));
	}

	@Override
	public List<RetailStore> findByCategory(String Category) {
		// TODO Auto-generated method stub
		List<RetailStore> list = jdbcTemplate.query("select * from retail_store where Category=?",
				new BeanPropertyRowMapper<>(RetailStore.class), Category);
		boolean a = list.isEmpty();
		if (a == false) {
			return list;
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Category not found");

	}

	@Override
	public List<RetailStore> findByType(String Category, String Type) {
		// TODO Auto-generated method stub
		List<RetailStore> list = jdbcTemplate.query("select * from retail_store where Category=? and Type=?",
				new BeanPropertyRowMapper<>(RetailStore.class), Category, Type);
		boolean a = list.isEmpty();
		if (a == false) {
			return list;
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Type not found");
	}

	@Override
	public List<RetailStore> findByName(String Category, String Type, String Name) {
		// TODO Auto-generated method stub
		List<RetailStore> list = jdbcTemplate.query("select * from retail_store where Category=? and Type=? and Name=?",
				new BeanPropertyRowMapper<>(RetailStore.class), Category, Type, Name);
		boolean a = list.isEmpty();
		if (a == false) {
			return list;
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Name not found");

	}

	@Override
	public Credentials saveCredentials(String Category, String Type, String Name, Credentials Cred) {
		// TODO Auto-generated method stub
		// return null;

		List<RetailStore> list = jdbcTemplate.query("select * from retail_store where Category=? and Type=? and Name=?",
				new BeanPropertyRowMapper<>(RetailStore.class), Category, Type, Name);
		boolean a = list.isEmpty();

		if (a == false) {

			jdbcTemplate.update("insert into credentials(Username,Password) Values (?,?)", Cred.getUsername(),
					Cred.getPassword());
			jdbcTemplate.update("update orders set Username=? where Username is NULL", Cred.getUsername());
			return Cred;
		} else

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product details have an error");

	}

	@Override
	public Orders placedOrder(String Category, String Type, String Name, Orders order) {
		// TODO Auto-generated method stub
		// return null;

		List<RetailStore> list = jdbcTemplate.query("select * from retail_store where Category=? and Type=? and Name=?",
				new BeanPropertyRowMapper<>(RetailStore.class), Category, Type, Name);
		boolean a = list.isEmpty();

		if (a == false) {

			jdbcTemplate.update(
					"insert into orders(Username,Id,Category,Type,Name,Brand,Quantity,Price,Expiry_Date,Count) Values (?,?,?,?,?,?,?,?,?,?)",
					order.getUsername(), order.getId(), order.getCategory(), order.getType(), order.getName(),
					order.getBrand(), order.getQuantity(), order.getPrice(), order.getExpiry_Date(), order.getCount());
			return order;
		} else

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product details have an error");

	}
}
