package services;

import java.util.List;

import entities.Passenger;

public interface transactionService {
	
	public List<Passenger> passengerTransaction();
	
	public List<Passenger> passengerAllTransaction();
}
