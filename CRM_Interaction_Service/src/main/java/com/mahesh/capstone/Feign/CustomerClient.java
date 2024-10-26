package com.mahesh.capstone.Feign;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mahesh.capstone.DTO.CustomerDto;


@FeignClient(name = "customer-service", url = "http://localhost:8082")
public interface CustomerClient {
    @GetMapping("/customers/{id}")
    CustomerDto getCustomerById(@PathVariable("id") Long id);
}
