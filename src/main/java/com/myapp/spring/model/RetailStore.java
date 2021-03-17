package com.myapp.spring.model;

public class RetailStore {

	private Integer id;

	private String category;

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
		return expiry_Date;
	}

	public void setExpiry_Date(String expiry_Date) {
		this.expiry_Date = expiry_Date;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public RetailStore(Integer id, String category, String type, String name, String brand, String quantity,
			Integer price, String expiry_Date, Integer stock) {
		this.id = id;
		this.category = category;
		this.type = type;
		this.name = name;
		this.brand = brand;
		this.quantity = quantity;
		this.price = price;
		this.expiry_Date = expiry_Date;
		this.stock = stock;
	}

	private String type;

	private String name;

	private String brand;

	private String quantity;

	private Integer price;

	private String expiry_Date;

	private Integer stock;

	public RetailStore() {
	}

}
