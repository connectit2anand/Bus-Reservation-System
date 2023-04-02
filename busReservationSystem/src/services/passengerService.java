package services;
import java.util.*;

import entities.BusDetails;
import entities.Passenger;
import entities.Transaction;
import exception.InvalidDetailsException;


public interface PassengerService {
	
	public Passenger signUp(Scanner sc,Map<String,Passenger> passenger) throws InvalidDetailsException ;
	
	public Passenger signIn(Scanner sc,Map<String,Passenger> passenger)throws InvalidDetailsException ;

	public void bookTicket(Scanner sc ,Map<String,Passenger> passenger,
			Map<Long,Transaction> transactions,
			Map<String, BusDetails> busDetails, Passenger currentPassenger);
	
	public void deleteTicket(Scanner sc,Map<Long,Transaction> transactions);
	
	public void bookingHistory(String userName,Map<Long,Transaction> transactions);
	
	public void deleteAccount();

	public void addToWallet(Scanner sc, Map<String, Passenger> passenger, Passenger currentPassenger);
	
		
}
