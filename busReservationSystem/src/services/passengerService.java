package services;

import java.util.List;

public interface passengerService {
	
	public List listOfBus();
	
	public int busNumber();
	
	public String deleteTicket();
	
	public void signUp();
	
	public boolean signIn();
	
	public List bookingHistory();
	
	public void deleteAccount();
	
		
}
