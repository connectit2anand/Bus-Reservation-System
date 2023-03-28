package entities;

import java.io.Serializable;

public class BusDetails implements Serializable{
	
	private int busNumber;
	private int noOfVacantSeats;
	private int totalSeats;
	private int noOfOccupiedSeats;
	
	
	
	public BusDetails(int busNumber, int noOfVacantSeats, int totalSeats, int noOfOccupiedSeats) {
		super();
		this.busNumber = busNumber;
		this.noOfVacantSeats = noOfVacantSeats;
		this.totalSeats = totalSeats;
		this.noOfOccupiedSeats = noOfOccupiedSeats;
	}
	
	public int getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}
	public int getNoOfVacantSeats() {
		return noOfVacantSeats;
	}
	public void setNoOfVacantSeats(int noOfVacantSeats) {
		this.noOfVacantSeats = noOfVacantSeats;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getNoOfOccupiedSeats() {
		return noOfOccupiedSeats;
	}
	public void setNoOfOccupiedSeats(int noOfOccupiedSeats) {
		this.noOfOccupiedSeats = noOfOccupiedSeats;
	}
	
	
}
