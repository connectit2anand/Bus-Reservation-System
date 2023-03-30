package entities;

import java.io.Serializable;

import utility.IdGeneration;

public class BusDetails implements Serializable{
	
	
	private String busNumber;
	private int noOfVacantSeats;
	private int totalSeats;
	private int noOfOccupiedSeats = 0;
	
	
	
	public BusDetails(String busNumber, int totalSeats) {
		this.busNumber = busNumber;
		this.totalSeats = totalSeats;
		this.noOfVacantSeats = totalSeats;
		
	}
	
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
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

	@Override
	public String toString() {
		return "BusDetails [busNumber=" + busNumber + ", noOfVacantSeats=" + noOfVacantSeats + ", totalSeats="
				+ totalSeats + ", noOfOccupiedSeats=" + noOfOccupiedSeats + "]";
	}
}
