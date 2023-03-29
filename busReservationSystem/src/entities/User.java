package entities;

import java.io.Serializable;

public class User implements Serializable{
	
	private int id;
	private String username;
	private String password;
	private String address;
	private String email;
	
	public User() {
		super();
	}
	
	public User(String username,String password,String address,String email) {
		
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", address=" + address + ", email=" + email
				+ "]";
	}
	
	
	
}
