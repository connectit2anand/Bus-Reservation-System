package services.impl;


import java.time.LocalDateTime;
import java.util.*;

import entities.BusDetails;
import entities.Passenger;
import entities.Transaction;
import entities.User;
import exception.InvalidDetailsException;
import services.PassengerService;
public class PassengerImpl implements PassengerService{

	
	@Override
	public Passenger signUp(Scanner sc,Map<String,Passenger> passenger)throws InvalidDetailsException {
		System.out.println("**********************************");
		System.out.println("* Enter User Name                *");
		System.out.println("**********************************");
		String username = sc.next();
		
		if(passenger.containsKey(username)) {
			InvalidDetailsException ide = new InvalidDetailsException("User Name Already Exists");
			throw ide;
		}
		System.out.println("**********************************");
		System.out.println("* Enter A Password               *");
		System.out.println("**********************************");
		String password = sc.next();
		
		System.out.println("**********************************");
		System.out.println("* Enter Your Address             *");
		System.out.println("**********************************");
		String address = sc.next();
		
		System.out.println("**********************************");
		System.out.println("* Enter You Email Address        *");
		System.out.println("**********************************");
		String emailId = sc.next();
		
		Passenger p = new Passenger(username, password, address, emailId);
		passenger.put(username, p);
		
		System.out.println("**********************************");
		System.out.println("* Successfully Signed-Up         *");
		System.out.println("**********************************");
		return p;
		
		
		
	}

	@Override
	public Passenger signIn(Scanner sc,Map<String,Passenger> passenger)throws InvalidDetailsException{
		System.out.println("**********************************");
		System.out.println("* Enter User Name                *");
		System.out.println("**********************************");
		String username = sc.next();
		
		System.out.println("**********************************");
		System.out.println("* Enter A Password               *");
		System.out.println("**********************************");
		
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
		System.out.println("**********************************");
		System.out.println("* LoggedIn Successfully          *");
		System.out.println("**********************************");
		return p;
	}

	@Override
	public void bookTicket(Scanner sc ,Map<String,Passenger> passenger,
			Map<Long,Transaction> transactions,
			Map<String, BusDetails> busDetails, Passenger currentPassenger) {
		
		System.out.println("**********************************");
		System.out.println("* Enter Source                   *");
		System.out.println("**********************************");
		String source = sc.next().toLowerCase();
		System.out.println("**********************************");
		System.out.println("* Enter Destination              *");
		System.out.println("**********************************");
		
		String destination = sc.next().toLowerCase();
		
		Set<Map.Entry<String,BusDetails>> bus = busDetails.entrySet();
		boolean isBusAvailable = false;
		boolean isFirstTime = true;
		
		Map<String,BusDetails> busesAvailableForUser = new HashMap<>();
		for(Map.Entry<String,BusDetails> me : bus) {
			if(me.getValue().getSource().toLowerCase().equals(source) && 
					me.getValue().getDestination().toLowerCase().equals(destination)) {
				if(isFirstTime) {
					System.out.println("*******************************************************************");
					System.out.println("* Following Buses Are Available for the given " + source + " To " + destination);
					System.out.println("*******************************************************************");
					
					isFirstTime = false;
				}
				busesAvailableForUser.put(me.getKey(), me.getValue());
				System.out.println(me.getValue());
				isBusAvailable = true;
			}
		} 
		if(!isBusAvailable) {
			System.out.println("*******************************************************************");
			System.out.println("* No Bus Available For " + source + " To " + destination );
			System.out.println("*******************************************************************");
			return;
		}
		System.out.println("*******************************");
		System.out.println("* Enter The Bus Number        *");
		System.out.println("*******************************");
		String busNumber = sc.next();
		while(true) {
			if(busesAvailableForUser.containsKey(busNumber)) {
				break;
			}
			System.out.println("*************************************");
			System.out.println("* Please Enter Valid Bus Number     *");
			System.out.println("*************************************");
			busNumber = sc.next();
		}
		BusDetails selectedBus = busesAvailableForUser.get(busNumber);
		System.out.println("*********************************************");
		System.out.println("* Enter Number Of Seats You Want TO Book    *");
		System.out.println("*********************************************");
		int numberOfSeats = sc.nextInt();
		if(numberOfSeats > selectedBus.getNoOfVacantSeats()) {
			System.out.println("*********************************************");
			System.out.println("* Only " + selectedBus.getNoOfVacantSeats() + " seats available");
			System.out.println("*********************************************");
			return;
		}
		int totalAmount =  numberOfSeats * selectedBus.getPrice();
		if(currentPassenger.getWalet() < totalAmount) {
			System.out.println("****************************************************************");
			System.out.println("* Insufficient Fund In Your Wallet                             *");
			System.out.println("Please Use Add To Wallet Service To Add Cash In Your Wallet");
			System.out.println("****************************************************************");
			return;
			
		}
		int remainingBalance = currentPassenger.getWalet() - totalAmount;
		currentPassenger.setWalet(remainingBalance);
		
		int remainingSeats = selectedBus.getNoOfVacantSeats() - numberOfSeats;
		int occupiedSeats = selectedBus.getNoOfOccupiedSeats() + numberOfSeats;
		selectedBus.setNoOfOccupiedSeats(occupiedSeats);
		selectedBus.setNoOfVacantSeats(remainingSeats);
		
		busDetails.put(busNumber, selectedBus);
		passenger.put(currentPassenger.getUsername(),currentPassenger);
		
		LocalDateTime currentTime = LocalDateTime.now();
		
		Transaction t = new Transaction(currentPassenger.getUsername(), busNumber,
				selectedBus.getPrice(),numberOfSeats,
				totalAmount, source, destination, currentTime);
		transactions.put(t.getId(), t);
		System.out.println("****************************************************************");
		System.out.println("* Ticked Successfully Booked WIth Transaction ID:"
				+ " " + t.getId());
		System.out.println("****************************************************************");
	}

	@Override
	public void deleteTicket(Scanner sc,Map<Long,Transaction> transactions) {
		System.out.println("*********************************************");
		System.out.println("* Please Enter The Transaction Id           *");
		System.out.println("*********************************************");
		Long transactionId = sc.nextLong();
		boolean isTransactionIdAvailable = false;
		if(transactions.containsKey(transactionId)){
			transactions.remove(transactionId);
			isTransactionIdAvailable = true;
			System.out.println("*****************************************");
			System.out.println("* Ticket Successfully Removed           *");
			System.out.println("*****************************************");
		}
		if(!isTransactionIdAvailable) {
			System.out.println("*****************************************");
			System.out.println("* Transaction ID Not Available          *");
			System.out.println("*****************************************");
		}
	}

	@Override
	public void bookingHistory(String userName,Map<Long,Transaction> transactions) {
		
		boolean isUsenamePresent = false;
		Set<Map.Entry<Long,Transaction>> trans = transactions.entrySet();
		for(Map.Entry<Long,Transaction> me : trans) {
			if(me.getValue().getUsername().equals(userName)) {
				if(!isUsenamePresent) {
					System.out.println("*****************************************");
					System.out.println("* Your Booking History                  *");
					System.out.println("*****************************************");
					isUsenamePresent = true;
				}
				System.out.println(me.getValue());
			}
		}
		if(!isUsenamePresent) {
			System.out.println("*****************************************");
			System.out.println("* No Booking History Available          *");
			System.out.println("*****************************************");
		}
		
		
	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToWallet(Scanner sc, Map<String, Passenger> passenger,
			Passenger currentPassenger) {
		System.out.println("**********************************************");
		System.out.println("* Your current wallet balance is: " + currentPassenger.getWalet());
		System.out.println("**********************************************");
		System.out.println("*****************************************");
		System.out.println("* Enter The Amount You Want To Add      *");
		System.out.println("*****************************************");
		int amountToWallet = sc.nextInt();
		if(amountToWallet <= 0) {
			System.out.println("*****************************************");
			System.out.println("* Please Enter Valid Amount             *");
			System.out.println("*****************************************");
			return;
		}
		currentPassenger.setWalet(currentPassenger.getWalet() + amountToWallet);
		String userName = currentPassenger.getUsername();
		passenger.put(userName, currentPassenger);
		System.out.println("*****************************************");
		System.out.println("* Balance added successfully            *");
		System.out.println("Current balance is " + currentPassenger.getWalet());
		System.out.println("*****************************************");
	}
	

	
}
