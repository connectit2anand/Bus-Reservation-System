package entities;
import java.util.*;

public class Passenger extends User{
	
	public Passenger(String username, String password, String address, String email) {
		super(username, password, address, email);
	}
	
	public int getWalet() {
		return walet;
	}

	public void setWalet(int walet) {
		this.walet = walet;
	}

	private int walet;
		
	
}
