package com.mahesh.capstone.Controller;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mahesh.capstone.DTO.CustomerDto;
import com.mahesh.capstone.controller.CustomerController;
import com.mahesh.capstone.service.CustomerService;
import jakarta.ws.rs.core.MediaType;

@WebMvcTest(CustomerController.class)
public class TestController {
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private CustomerService customerService;

	    @InjectMocks
	    private CustomerController customerController;

	    private CustomerDto customer1;
	    private CustomerDto customer2;

	    @BeforeEach
	    public void setup() {
	        MockitoAnnotations.openMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

	        customer1 = new CustomerDto(1L, "John", "Doe", "john.doe@example.com","1234567890");
	        customer2 = new CustomerDto(1L, "Jane", "Doe", "jane.doe@example.com","1234567890");
	    }

	   
	    
	    @Test
	    public void testCreateCustomer() throws Exception {
	        CustomerDto customerDto = new CustomerDto(1L, "Jane", "Doe", "jane.doe@example.com", "1234567890"); 
	        when(customerService.createCustomer(any(CustomerDto.class))).thenReturn(customerDto);

	        mockMvc.perform(post("/customers/add")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{\"id\": 1, \"firstname\": \"Jane\", \"lastname\": \"Doe\", \"email\": \"jane.doe@example.com\", \"phoneNumber\": \"1234567890\"}"));
	                	    }
	    
	    @Test
	    public void testDeleteCustomer() throws Exception {
    	 
	        mockMvc.perform(delete("/customers/1"))
           .andExpect(status().isNoContent());
	        verify(customerService, times(1)).deleteCustomer(1L);
	    }
	   

}
