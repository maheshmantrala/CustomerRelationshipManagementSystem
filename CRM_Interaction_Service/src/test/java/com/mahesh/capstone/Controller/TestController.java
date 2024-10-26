package com.mahesh.capstone.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import com.mahesh.capstone.DTO.InteractionDto;
import com.mahesh.capstone.Service.InteractionService;

import jakarta.ws.rs.core.MediaType;

@WebMvcTest(InteractionController.class)
@SpringBootTest
@TestConfiguration
public class TestController {
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private InteractionService interactionService;
	    @BeforeEach
	    public void setup() {
	        MockitoAnnotations.openMocks(this);
	    }
	    
	    @Test
	    public void testCreateInteraction() throws Exception {
	        InteractionDto interactionDto = new InteractionDto(1L, "Type", "Details", "Description");
	        when(interactionService.createInteraction(any(InteractionDto.class))).thenReturn(interactionDto);

	        mockMvc.perform(post("/interactions/add")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("{\"id\": 1, \"type\": \"Type\", \"details\": \"Details\", \"description\": \"Description\"}"))
	                .andExpect(status().isOk());
	                
	    }
	    @Test
	    public void testDeleteInteraction() throws Exception {
	        doNothing().when(interactionService).deleteInteraction(1L);

	        mockMvc.perform(delete("/interactions/1"))
	                .andExpect(status().isNoContent());
	    }
	    @Test
	    public void testGetInteractionById() throws Exception {
	        InteractionDto interactionDto = new InteractionDto(1L, "Type", "Details", "Description");
	        when(interactionService.getInteractionById(1L)).thenReturn(interactionDto);

	        mockMvc.perform(get("/interactions/1"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.id").value(1L));
	    }
	    @Test
	    public void testGetAllInteractions() throws Exception {
	        List<InteractionDto> interactions = Arrays.asList(
	                new InteractionDto(1L, "Type1", "Details1", "Description1"),
	                new InteractionDto(2L, "Type2", "Details2", "Description2")
	        );
	        when(interactionService.getAllInteractions()).thenReturn(interactions);

	        mockMvc.perform(get("/interactions/getall"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.length()").value(2));
	    }
}
