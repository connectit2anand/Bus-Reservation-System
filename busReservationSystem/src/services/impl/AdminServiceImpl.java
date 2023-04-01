package services.impl;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import entities.BusDetails;
import exception.DuplicateBusNumberException;
import exception.InvalidDetailsException;
import services.AdminService;
import services.BusDetailServices;

public class AdminServiceImpl implements AdminService {

	@Override
	public void login(Scanner sc) throws InvalidDetailsException {
		
		System.out.println("Enter The Admin User Name");
		String username = sc.next();
		System.out.println("Enter The Password");
		String password = sc.next();
		if(!username.equals("admin") || !password.equals("admin")) {
			InvalidDetailsException ide = 
					new InvalidDetailsException("Username or Password is invalid");
			throw ide;
		} 
		System.out.println("Successfully Logged In");
	}

	@Override
	public void addBusDetails(Scanner sc,Map<String,BusDetails> busDetails) throws DuplicateBusNumberException {
		
		System.out.println("Enter The Bus Number");
		String busNumber = sc.next();
		System.out.println("Enter The Total Number Of Seats");
		int totalSeats = sc.nextInt();
		
		Set<Map.Entry<String, BusDetails>> set = busDetails.entrySet();
		for(Map.Entry<String, BusDetails> me : set) {
			if(me.getKey().equals(busNumber)) {
				DuplicateBusNumberException dbn = new DuplicateBusNumberException("Bus Number Already Exists");
				throw dbn;				
			}
		}
		System.out.println("Enter bus source");
		String source = sc.next();
		System.out.println("Enter bus destination");
		String destination = sc.next();
		System.out.println("Enter price");
		int price = sc.nextInt();
		BusDetails bd = new BusDetails(busNumber, totalSeats, source, destination, price);
		busDetails.put(busNumber, bd);
	}

	@Override
	public void updateBusDetils(Scanner sc,Map<String,BusDetails> busDetails) throws InvalidDetailsException {
		
		System.out.println("Enter The Bus Number For Which You Want To Update Details");
		String busNumber = sc.next();
		if(!busDetails.containsKey(busNumber)) {
			InvalidDetailsException ide = new InvalidDetailsException("Invalid Bus Number");
			throw ide;
		}
		System.out.println("Enter the new source");
		String newSource = sc.next();
		System.out.println("Enter the new destination");
		String newDestination = sc.next();
		System.out.println("Enter the new price");
		int newPrice = sc.nextInt();
		BusDetails bus = busDetails.get(busNumber);
		bus.setSource(newSource);
		bus.setDestination(newDestination);
		bus.setPrice(newPrice);
		busDetails.put(busNumber,bus);
	}

	@Override
	public void deleteBusDetails(Scanner sc,Map<String,BusDetails> busDetails) throws InvalidDetailsException{
		
		System.out.println("Enter Bus Number Whose Details You Want To Delete");
		String busNumber = sc.next();
		if(busDetails.containsKey(busNumber)) {
			busDetails.remove(busNumber);
		} else {
			InvalidDetailsException ide = new InvalidDetailsException("Please Enter Valid Bus Number");
			throw ide;
		}
		
	}

	@Override
	public void viewBusDetails(Map<String,BusDetails> busDetails) {
		System.out.println("Bus Details");
		Set<Map.Entry<String,BusDetails>> set = busDetails.entrySet();
		for(Map.Entry<String, BusDetails> me : set) {
			System.out.println(me.getValue());
		}
	}

	@Override
	public void viewBookingForDateRange() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewbookingsByBusName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewbookingByUserNameOfPassenger() {
		// TODO Auto-generated method stub
		
	}
	
	

}
