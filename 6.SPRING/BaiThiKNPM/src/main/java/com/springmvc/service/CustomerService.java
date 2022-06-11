package com.springmvc.service;

import com.springmvc.entity.Customer;

public interface CustomerService {

	java.util.List<Customer> getAll(int offset,int rowcount);

	int countTotalRecords();

	void save(Customer customer);

	Customer get(int id);

	void delete(int id);

	
}
