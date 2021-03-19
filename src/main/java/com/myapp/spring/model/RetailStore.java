package com.myapp.spring.model;

public class RetailStore {

	private Integer itemId;

	private String itemCategory;

	public Integer getId() {
		return itemId;
	}

	public void setId(Integer id) {
		itemId = id;
	}

	public String getCategory() {
		return itemCategory;
	}

	public void setCategory(String category) {
		itemCategory = category;
	}

	public String getType() {
		return itemType;
	}

	public void setType(String type) {
		itemType = type;
	}

	public String getName() {
		return itemName;
	}

	public void setName(String name) {
		itemName = name;
	}

	public String getBrand() {
		return itemBrand;
	}

	public void setBrand(String brand) {
		itemBrand = brand;
	}

	public String getQuantity() {
		return itemQuantity;
	}

	public void setQuantity(String quantity) {
		itemQuantity = quantity;
	}

	public Integer getPrice() {
		return itemPrice;
	}

	public void setPrice(Integer price) {
		itemPrice = price;
	}

	public String getExpiry_Date() {
		return itemExpiryDate;
	}

	public void setExpiry_Date(String expiryDate) {
		itemExpiryDate = expiryDate;
	}

	public Integer getStock() {
		return itemStock;
	}

	public void setStock(Integer stock) {
		itemStock = stock;
	}

	public RetailStore(Integer id, String category, String type, String name, String brand, String quantity,
			Integer price, String expiryDate, Integer stock) {
		itemId = id;
		itemCategory = category;
		itemType = type;
		itemName = name;
		itemBrand = brand;
		itemQuantity = quantity;
		itemPrice = price;
		itemExpiryDate = expiryDate;
		itemStock = stock;
	}

	private String itemType;

	private String itemName;

	private String itemBrand;

	private String itemQuantity;

	private Integer itemPrice;

	private String itemExpiryDate;

	private Integer itemStock;

	public RetailStore() {
	}

}
