package com.HomeHubV1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
	@Column(name = "firtname",  length = 15, nullable = false)
	String firstName;
	@Column(name = "lastname",  length = 15, nullable = false)
	String lastName;
	@Column(name = "phone",  length = 10)
	String phone;
	@Column(name = "email", length = 50, nullable = false)
	String email;
	@Column(name = "message",  length = 200, nullable = false)
	String message;
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message( String firstName, String lastName, String phone, String email, String message) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
