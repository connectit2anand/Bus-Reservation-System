package services;
import java.util.*;

import entities.Passenger;
import exception.InvalidDetailsException;


public interface PassengerService {
	
	public void signUp(Scanner sc,Map<String,Passenger> passenger) throws InvalidDetailsException ;
	
	public void signIn(Scanner sc,Map<String,Passenger> passenger)throws InvalidDetailsException ;
	
	public void listOfBus();
	
	public String busNumber();
	
	public void deleteTicket();
	
	public void bookingHistory();
	
	public void deleteAccount();
	
		
}
