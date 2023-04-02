package services.impl;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import entities.BusDetails;
import entities.Transaction;
import exception.DuplicateBusNumberException;
import exception.InvalidDetailsException;
import services.AdminService;
import services.BusDetailServices;

public class AdminServiceImpl implements AdminService {

	@Override
	public void login(Scanner sc) throws InvalidDetailsException {
		System.out.println("**********************************");
		System.out.println("* Enter The Admin User Name      *");
		System.out.println("**********************************");
		String username = sc.next();
		System.out.println("**********************************");
		System.out.println("* Enter The Password             *");
		System.out.println("**********************************");
		String password = sc.next();
		if(!username.equals("admin") || !password.equals("admin")) {
			InvalidDetailsException ide = 
					new InvalidDetailsException("Username or Password is invalid");
			throw ide;
		} 
		System.out.println("**********************************");
		System.out.println("* Successfully Logged In         *");
		System.out.println("**********************************");
	}

	@Override
	public void addBusDetails(Scanner sc,Map<String,BusDetails> busDetails) throws DuplicateBusNumberException {
		System.out.println("**********************************");
		System.out.println("* Enter The Bus Number           *");
		System.out.println("**********************************");
		String busNumber = sc.next();
		System.out.println("***********************************");
		System.out.println("* Enter The Total Number Of Seats *");
		System.out.println("***********************************");
		int totalSeats = sc.nextInt();
		
		Set<Map.Entry<String, BusDetails>> set = busDetails.entrySet();
		for(Map.Entry<String, BusDetails> me : set) {
			if(me.getKey().equals(busNumber)) {
				DuplicateBusNumberException dbn = new DuplicateBusNumberException("Bus Number Already Exists");
				throw dbn;				
			}
		}
		System.out.println("**********************************");
		System.out.println("* Enter bus source               *");
		System.out.println("**********************************");
		String source = sc.next();
		System.out.println("**********************************");
		System.out.println("* Enter bus destination          *");
		System.out.println("**********************************");
		String destination = sc.next();
		System.out.println("**********************************");
		System.out.println("* Enter price                    *");
		System.out.println("**********************************");
		int price = sc.nextInt();
		BusDetails bd = new BusDetails(busNumber, totalSeats, source, destination, price);
		busDetails.put(busNumber, bd);
		System.out.println("**************************************");
		System.out.println("* Bus Details Successfully Added.    *");
		System.out.println("**************************************");
	}

	@Override
	public void updateBusDetils(Scanner sc,Map<String,BusDetails> busDetails) throws InvalidDetailsException {
		System.out.println("*************************************************************");
		System.out.println("* Enter The Bus Number For Which You Want To Update Details *");
		System.out.println("*************************************************************");
		String busNumber = sc.next();
		if(!busDetails.containsKey(busNumber)) {
			InvalidDetailsException ide = new InvalidDetailsException("Invalid Bus Number");
			throw ide;
		}
		System.out.println("********************************");
		System.out.println("* Enter the new source         *");
		System.out.println("********************************");
		String newSource = sc.next();
		System.out.println("********************************");
		System.out.println("* Enter the new destination    *");
		System.out.println("********************************");
		String newDestination = sc.next();
		System.out.println("********************************");
		System.out.println("* Enter the new price          *");
		System.out.println("********************************");
		int newPrice = sc.nextInt();
		BusDetails bus = busDetails.get(busNumber);
		bus.setSource(newSource);
		bus.setDestination(newDestination);
		bus.setPrice(newPrice);
		busDetails.put(busNumber,bus);
	}

	@Override
	public void deleteBusDetails(Scanner sc,Map<String,BusDetails> busDetails) throws InvalidDetailsException{
		System.out.println("********************************************************");
		System.out.println("* Enter Bus Number Whose Details You Want To Delete    *");
		System.out.println("********************************************************");
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
	public void viewbookingByUserNameOfPassenger(Map<Long,Transaction> transactions,Scanner sc) {
		System.out.println("***************************");
		System.out.println("* Enter The User Name     *");
		System.out.println("***************************");
		String username = sc.next();
		boolean userNameAvailable = false;
		System.out.println("***********************************************************************");
		Set<Map.Entry<Long, Transaction>> set = transactions.entrySet();
		for(Map.Entry<Long, Transaction> me : set) {
			if(me.getValue().getUsername().equals(username)) {
				userNameAvailable = true;
				System.out.println(me.getValue());
			}
		}
		System.out.println("********************************************************");
		if(!userNameAvailable) {
			System.out.println("*******************************");
			System.out.println("* User Name Does NOT Exist    *");
			System.out.println("*******************************");
		}
		
		
	}
	
	

}
