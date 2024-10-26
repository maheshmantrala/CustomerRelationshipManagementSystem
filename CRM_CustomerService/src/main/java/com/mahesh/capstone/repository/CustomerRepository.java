package com.mahesh.capstone.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahesh.capstone.DTO.CustomerDto;
import com.mahesh.capstone.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {



}
