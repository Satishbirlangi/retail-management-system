package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.Orders;
import com.myapp.spring.model.RetailStore;

public interface RetailStoreRepository {

	List<RetailStore> findAll();

	List<RetailStore> findByCategory(String category);

	List<RetailStore> findByType(String category, String type);

	List<RetailStore> findByName(String category, String type, String name);

	Orders placedOrder(String category, String type, String name, Orders order);

	Orders reguserplacedOrder(String category, String type, String name, Orders order);

}
