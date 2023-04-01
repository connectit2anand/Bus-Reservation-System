package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

public class Transaction implements Serializable{
	
	private int id;
	private String username;
	private String busNumber;
	private double eachSeatPrice;
	private int numberOfSeats;
	private int total;
	private String source;
	private String destination;
	private LocalDateTime td;
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
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDateTime getTd() {
		return td;
	}
	public void setTd(LocalDateTime td) {
		this.td = td;
	}
	
}
