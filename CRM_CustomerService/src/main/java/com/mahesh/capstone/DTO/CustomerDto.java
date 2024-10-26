package com.mahesh.capstone.DTO;

public class CustomerDto {
	private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
   

  

	

	public CustomerDto(long id, String firstname, String lastname, String email, String phoneNumber) {
		
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	

	public CustomerDto() {
		// TODO Auto-generated constructor stub
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	

	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public CustomerDto get() {
		// TODO Auto-generated method stub
		return null;
	}
}
