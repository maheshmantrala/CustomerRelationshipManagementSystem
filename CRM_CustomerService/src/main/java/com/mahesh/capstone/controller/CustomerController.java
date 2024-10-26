package com.mahesh.capstone.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.capstone.DTO.CustomerDto;
import com.mahesh.capstone.service.CustomerService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customers")
public class CustomerController {
	
  @Autowired
  private CustomerService customerService;
  
  @GetMapping("/{id}")
  public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id){
	  return ResponseEntity.ok(customerService.getCustomerById(id));
  }
  
  @PostMapping("/add")
  public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
	  return ResponseEntity.ok(customerService.createCustomer(customerDto));
  }
  
  @GetMapping
  public ResponseEntity <List<CustomerDto>> getAllCustomers(){
	  return ResponseEntity.ok(customerService.getAllCustomers());
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
	  customerService.deleteCustomer(id);
	  return  ResponseEntity.noContent().build();
  }
  
  
 
}