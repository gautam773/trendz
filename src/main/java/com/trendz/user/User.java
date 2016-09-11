package com.trendz.user;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String Username;
	private String Email;
	private String Phone;
	private String Location;
	private String Password;
@Transient
	private String Cpassword;
	private int Role=1;
	private boolean Active=true;
	
	
	
	public String getCpassword() {
		return Cpassword;
	}
	public void setCpassword(String cpassword) {
		Cpassword = cpassword;
	}
	
	
	public int getRole() {
		return Role;
	}
	public void setRole(int role) {
		Role = role;
	}
	
	
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	@NotEmpty(message="Username Is Mandatory.")
	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	
	@NotEmpty(message="Email Is Mandatory.")
	@org.hibernate.validator.constraints.Email
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	@NotEmpty(message="Phone Is Mandatory.")
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	@NotEmpty(message="Location Is Mandatory.")
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
	@NotEmpty(message="Password Is Mandatory.")
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	@Override
	public String toString() {
		return "{ID:\"" + Id + "\", Email:\"" + Email + "\", Username:\"" + Username + "\", Phone:\"" + Phone + "\", Location:\""
				+ Location + "\", Role:\"" + Role + "\", Active:" + Active + ", Delete: false}";
	}
	
}

