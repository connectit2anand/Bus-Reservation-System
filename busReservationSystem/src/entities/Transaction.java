package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import utility.IdGeneration;

import java.io.Serializable;

public class Transaction implements Serializable{
	
	private Long id;
	private String username;
	private String busNumber;
	private int eachSeatPrice;
	private int numberOfSeats;
	private int total;
	private String source;
	private String destination;
	private LocalDateTime td;
	
	
	
	public Transaction( String username, String busNumber, int eachSeatPrice,
			int numberOfSeats, int total,
			String source, String destination, LocalDateTime td) {
		
		this.id = IdGeneration.generatetId();
		this.username = username;
		this.busNumber = busNumber;
		this.eachSeatPrice = eachSeatPrice;
		this.numberOfSeats = numberOfSeats;
		this.total = total;
		this.source = source;
		this.destination = destination;
		this.td = td;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public void setEachSeatPrice(int eachSeatPrice) {
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
	@Override
	public String toString() {
		return "Transaction [id=" + id + "\n username=" + username + "\n busNumber=" + busNumber + "\n eachSeatPrice="
				+ eachSeatPrice + "\n numberOfSeats=" + numberOfSeats + "\n total=" + total + "\n source=" + source
				+ "\n destination=" + destination + "\n td=" + td + "]";
	}
	
}
