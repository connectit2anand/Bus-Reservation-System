package services;
import java.util.*;

import entities.BusDetails;
import entities.Passenger;
import exception.InvalidDetailsException;


public interface PassengerService {
	
	public Passenger signUp(Scanner sc,Map<String,Passenger> passenger) throws InvalidDetailsException ;
	
	public Passenger signIn(Scanner sc,Map<String,Passenger> passenger)throws InvalidDetailsException ;

	public void bookTicket(Scanner sc , Map<String, BusDetails> bus);
	
	public void deleteTicket();
	
	public void bookingHistory();
	
	public void deleteAccount();
	
		
}
