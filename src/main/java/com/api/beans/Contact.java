package com.api.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity

@Table(name = "Contact", uniqueConstraints = @UniqueConstraint(columnNames = { "emailAddress", "phoneNumber"}))
public class Contact {

	@Id
	@GeneratedValue
	private long id;
	private String username;
	
	@NotNull(message = "The Email Address is required.")
	@NotEmpty(message = "The Email Address is required.")
	private String emailAddress;
	
	@NotNull(message = "The phone Number is required.")
	@Digits(integer = 10,fraction = 0,message = "The phone Number must 10 digits")
	private long phoneNumber;
	
	private String timetocontact;
	private String message;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTimetocontact() {
		return timetocontact;
	}
	public void setTimetocontact(String timetocontact) {
		this.timetocontact = timetocontact;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Contact() {}
	public Contact(long id, String username,
			@NotNull(message = "The Email Address is required.") @NotEmpty(message = "The Email Address is required.") String emailAddress,
			@NotNull(message = "The phone Number is required.") @NotEmpty(message = "The Phone Number is required.") @Size(min = 10, max = 10) long phoneNumber,
			String timetocontact, String message) {
		super();
		this.id = id;
		this.username = username;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.timetocontact = timetocontact;
		this.message = message;
	}	

}
