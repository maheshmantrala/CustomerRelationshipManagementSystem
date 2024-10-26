package com.mahesh.capstone.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.capstone.DTO.CustomerDto;
import com.mahesh.capstone.entity.Customer;
import com.mahesh.capstone.exceptions.RunTimeException;
import com.mahesh.capstone.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
    //get customer By id
	public CustomerDto getCustomerById(Long id) {
		Customer customer=customerRepo.findById(id)
				.orElseThrow(()-> new RunTimeException("Customer Not Found"));
		return mapToDto(customer);
	}
	
	public List<CustomerDto> getAllCustomers(){
		List<Customer>customers=customerRepo.findAll();
		return customers.stream().map(this::mapToDto).collect(Collectors.toList());
	}
	
	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer customer=mapToEntity(customerDto);
		customerRepo.save(customer);
		return mapToDto(customer);
	}
	public void deleteCustomer(Long id) {
		customerRepo.deleteById(id);
	}
	
	private Customer mapToEntity(CustomerDto customerDto) {
		
		Customer customer=new Customer();
		customer.setId(customerDto.getId());
		customer.setFirstname(customerDto.getFirstname());
		customer.setLastname(customerDto.getLastname());
		customer.setEmail(customerDto.getEmail());
		customer.setPhoneNumber(customerDto.getPhoneNumber());
		
		return customer;
	}

	private CustomerDto mapToDto(Customer customer) {
		CustomerDto dto=new CustomerDto();
		dto.setId(customer.getId());
		dto.setFirstname(customer.getFirstname());
		dto.setLastname(customer.getLastname());
		dto.setEmail(customer.getEmail());
		dto.setPhoneNumber(customer.getPhoneNumber());
		
		return dto;
	} 
	

 
 
   
}
