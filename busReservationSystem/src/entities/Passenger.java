package entities;
import java.util.*;

public class Passenger extends User{
	
	private int walet;
	
	public Passenger(String username, String password, String address, String email) {
		super(username, password, address, email);
	}
		
	public int getWalet() {
		return walet;
	}

	public void setWalet(int walet) {
		this.walet = walet;
	}
}
