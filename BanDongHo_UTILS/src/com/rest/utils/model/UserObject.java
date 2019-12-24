package com.rest.utils.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserObject {
	/**
	 * 
	 */
	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private int role;

	// 0 la username
	// 1 la admin

	public UserObject() {
	}

	public UserObject(int id, String username, String password, String email, String address, int role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
	}

	public int getRole() {
		return role;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
