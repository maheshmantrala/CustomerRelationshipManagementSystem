package com.mahesh.capstone.DTO;

import java.util.Date;
import java.util.List;

import com.mahesh.capstone.entity.Interaction;

public class InteractionDto {

    private Long id;
    private Long customerId;
    private String type;
    private String details;
    private String description;
    private Date interactionDate;

   

	

	public InteractionDto() {
		super();
	}

	public InteractionDto(long l, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getInteractionDate() {
        return interactionDate;
    }

    public void setInteractionDate(Date interactionDate) {
        this.interactionDate = interactionDate;
    }

	public void setCustomer(CustomerDto customer) {
		// TODO Auto-generated method stub
		
	}

	public void setInteractions(List<Interaction> interactions) {
		// TODO Auto-generated method stub
		
	}
}
