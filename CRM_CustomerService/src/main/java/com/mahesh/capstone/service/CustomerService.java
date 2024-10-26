package com.mahesh.capstone.service;

import java.util.List;
import com.mahesh.capstone.DTO.CustomerDto;

public interface CustomerService {
 
	CustomerDto getCustomerById(Long id);
	List<CustomerDto> getAllCustomers();
	CustomerDto createCustomer(CustomerDto customerDto);
	void deleteCustomer(Long id);
	
}
