
package com.myapp.spring.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Orders {

	@Autowired

	private String username;

	private Integer id;

	private String category;

	private String type;

	private String name;

	private String brand;

	private String quantity;

	private Integer price;

	private String expiryDate;

	private Integer count;

	public Orders(String username, Integer id, String category, String type, String name, String brand, String quantity,
			Integer price, String expiryDate, Integer count) {

		this.username = username;
		this.id = id;
		this.category = category;
		this.type = type;
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.price = price;
		this.expiryDate = expiryDate;
		this.count = count;
	}

	public Orders() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getExpiry_Date() {
		return expiryDate;
	}

	public void setExpiry_Date(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
