package services;

import java.util.List;

import entities.Passenger;

public interface TransactionService {
	
	List<Passenger> passengerTransaction();
	
	List<Passenger> passengerAllTransaction();
}
