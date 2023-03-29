package entities;
import java.util.*;

public class Passenger extends User{
	
	private int id;
	private int busNumber;
	private int numberOfSeatsBooked;
	private List<Integer> seatNumbers;
	
	
	public Passenger(String username, String password, String address, String email,
			 int busNumber,int numberOfSeatsBooked, List<Integer> seatNumbers) {
		super(username, password, address, email);
		
		
		this.busNumber = busNumber;
		this.numberOfSeatsBooked = numberOfSeatsBooked;
		this.seatNumbers = seatNumbers;
		
	}
	
	public int getBusNumber() {
		return busNumber;
	}
	
	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}
	
	public int getNumberOfSeatsBooked() {
		return numberOfSeatsBooked;
	}
	
	public void setNumberOfSeatsBooked(int numberOfSeatsBooked) {
		this.numberOfSeatsBooked = numberOfSeatsBooked;
	}
	
	public List<Integer> getSeatNumbers() {
		return seatNumbers;
	}
	
	public void setSeatNumbers(List<Integer> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}
	
}
