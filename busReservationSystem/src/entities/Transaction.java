package entities;

import java.time.LocalDate;
import java.io.Serializable;

public class Transaction implements Serializable{
	
	private int id;
	private String username;
	private String email;
	private String address;
	private String busName;
	private double eachSeatPrice;
	private int numberOfSeats;
	private double total;
	private LocalDate td;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getBusName() {
		return busName;
	}
	
	public void setBusName(String busName) {
		this.busName = busName;
	}
	
	public double getEachSeatPrice() {
		return eachSeatPrice;
	}
	
	public void setEachSeatPrice(double eachSeatPrice) {
		this.eachSeatPrice = eachSeatPrice;
	}
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public LocalDate getTd() {
		return td;
	}
	
	public void setTd(LocalDate td) {
		this.td = td;
	}

	public Transaction() {
		super();
	}

	public Transaction(String username, String email, String address, String busName, double eachSeatPrice,
			int numberOfSeats, double total, LocalDate td) {
		super();
		this.username = username;
		this.email = email;
		this.address = address;
		this.busName = busName;
		this.eachSeatPrice = eachSeatPrice;
		this.numberOfSeats = numberOfSeats;
		this.total = total;
		this.td = td;
	}

	@Override
	public String toString() {
		return "Transaction [username=" + username + ", email=" + email + ", address=" + address + ", busName="
				+ busName + ", eachSeatPrice=" + eachSeatPrice + ", numberOfSeats=" + numberOfSeats + ", total=" + total
				+ ", td=" + td + "]";
	}
	
	
	
	
	
	
}
