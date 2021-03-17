package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.Orders;
import com.myapp.spring.model.RetailStore;

public interface RetailStoreRepository {

	List<RetailStore> findAll();

	List<RetailStore> findByCategory(String Category);

	List<RetailStore> findByType(String Category, String Type);

	List<RetailStore> findByName(String Category, String Type, String Name);

	Orders placedOrder(String Category, String Type, String Name, Orders order);

//	Orders finalOrder(String Category, String Type, String Name);

	Orders reguserplacedOrder(String Category, String Type, String Name, Orders order);

}
