package services.impl;


import java.util.*;

import entities.Passenger;
import entities.User;
import exception.InvalidDetailsException;
import services.PassengerService;
public class PassengerImpl implements PassengerService{

	
	@Override
	public Passenger signUp(Scanner sc,Map<String,Passenger> passenger)throws InvalidDetailsException {
		
		System.out.println("Enter User Name");
		String username = sc.next();
		
		if(passenger.containsKey(username)) {
			InvalidDetailsException ide = new InvalidDetailsException("User Name Already Exists");
			throw ide;
		}
		
		System.out.println("Enter A Password");
		String password = sc.next();
		
		System.out.println("Enter Your Address");
		String address = sc.next();
		
		System.out.println("Enter You Email Address");
		String emailId = sc.next();
		
		Passenger p = new Passenger(username, password, address, emailId);
		
		passenger.put(username, p);
		System.out.println("Successfully Signed-Up");
		return p;
		
		
		
	}

	@Override
	public Passenger signIn(Scanner sc,Map<String,Passenger> passenger)throws InvalidDetailsException{
		
		System.out.println("Enter User Name");
		String username = sc.next();
		
		System.out.println("Enter A Password");
		String password = sc.next();
		

		if(!passenger.containsKey(username)) {
			InvalidDetailsException ide = new InvalidDetailsException("User Name Or Password Invalid");
			throw ide;
		}
		
		Passenger p = passenger.get(username);
		if(!p.getPassword().equals(password)){
			InvalidDetailsException ide = 
					new InvalidDetailsException("User Name Or Password Invalid");
			throw ide;
		}
		
		System.out.println("LoggedIn Successfully");
		return p;
	}

	@Override
	public void bookTicket(Passenger p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTicket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bookingHistory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub
		
	}
	

	
}
