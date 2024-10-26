package com.mahesh.capstone.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.capstone.DTO.CustomerDto;
import com.mahesh.capstone.DTO.InteractionDto;
import com.mahesh.capstone.Feign.CustomerClient;
import com.mahesh.capstone.Repository.InteractionRepository;
import com.mahesh.capstone.entity.Interaction;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Autowired
    private InteractionRepository interactionRepository;
    @Autowired
    private CustomerClient customerClient;

    @Override
    public InteractionDto getInteractionById(Long id) {
        Interaction interaction = interactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Interaction not found"));
        return mapToDto(interaction);
    }

    @Override
    public List<InteractionDto> getAllInteractions() {
        List<Interaction> interactions = interactionRepository.findAll();
        return interactions.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public InteractionDto createInteraction(InteractionDto interactionDto) {
        Interaction interaction = mapToEntity(interactionDto);
        interaction.setInteractionDate(new Date());
        interactionRepository.save(interaction);
        return mapToDto(interaction);
    }

    @Override
    public void deleteInteraction(Long id) {
        interactionRepository.deleteById(id);
    }

    private InteractionDto mapToDto(Interaction interaction) {
        InteractionDto dto = new InteractionDto();
        dto.setId(interaction.getId());
        dto.setCustomerId(interaction.getCustomerId());
        dto.setType(interaction.getType());
        dto.setDetails(interaction.getDetails());
        dto.setInteractionDate(interaction.getInteractionDate());
        dto.setDescription(interaction.getDescription());
        dto.setInteractionDate(interaction.getInteractionDate());
        return dto;
    }

    private Interaction mapToEntity(InteractionDto interactionDto) {
        Interaction interaction = new Interaction();
        interaction.setId(interactionDto.getId());
        interaction.setCustomerId(interactionDto.getCustomerId());
        interaction.setType(interactionDto.getType());
        interaction.setDetails(interactionDto.getDetails());
        interaction.setInteractionDate(interactionDto.getInteractionDate());
        interaction.setDescription(interactionDto.getDescription());
          return interaction;
    }

	@Override
	public CustomerDto getCustomerInfo(Long customerId) {
		return customerClient.getCustomerById(customerId);
	
	}

	@Override
	public List<Interaction> getInteractionsByCustomerId(Long customerId) {
		 return interactionRepository.findByCustomerId(customerId);
	}
	
}

