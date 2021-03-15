package com.myapp.spring.model;

public class RetailStore {

	private Integer Id;

	private String Category;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public String getExpiry_Date() {
		return Expiry_Date;
	}

	public void setExpiry_Date(String expiry_Date) {
		Expiry_Date = expiry_Date;
	}

	public Integer getStock() {
		return Stock;
	}

	public void setStock(Integer stock) {
		Stock = stock;
	}

	public RetailStore(Integer id, String category, String type, String name, String brand, String quantity,
			Integer price, String expiry_Date, Integer stock) {
		Id = id;
		Category = category;
		Type = type;
		Name = name;
		Brand = brand;
		Quantity = quantity;
		Price = price;
		Expiry_Date = expiry_Date;
		Stock = stock;
	}

	private String Type;

	private String Name;

	private String Brand;

	private String Quantity;

	private Integer Price;

	private String Expiry_Date;

	private Integer Stock;

	public RetailStore() {
	}

}
