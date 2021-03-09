package com.myapp.spring.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class RetailStore {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Integer Id;

	private String Category;

	private String Type;

	private String Name;

	private String Brand;

	private String Quantity;

	private Integer Price;

	private Date Expiry_Date;

	private Integer Stock;

	public RetailStore() {
	}

	public RetailStore(Integer Id, String Category, String Type, String Name, String Brand, String Quantity,
			Integer Price, Date Expiry_Date, Integer Stock) {
		this.Id = Id;
		this.Category = Category;
		this.Type = Type;
		this.Name = Name;
		this.Brand = Brand;
		this.Quantity = Quantity;
		this.Price = Price;
		this.Expiry_Date = Expiry_Date;
		this.Stock = Stock;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String Category) {
		this.Category = Category;
	}

	public String getType() {
		return Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String Brand) {
		this.Brand = Brand;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String Quantity) {
		this.Quantity = Quantity;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer Price) {
		this.Price = Price;
	}

	public Date getExpiry_Date() {
		return Expiry_Date;
	}

	public void setExpiry_Date(Date Expiry_Date) {
		this.Expiry_Date = Expiry_Date;
	}

	public Integer getStock() {
		return Stock;
	}

	public void setStock(Integer Stock) {
		this.Stock = Stock;
	}

	public boolean validate(String Category, String Type, String Name) {

		List<RetailStore> list = jdbcTemplate.query("select * from retail_store where Category=? and Type=? and Name=?",
				new BeanPropertyRowMapper<>(RetailStore.class), Category, Type, Name);
		boolean a = list.isEmpty();
		if (a == false) {
			return true;
		} else
			return false;

	}

}
