import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import entities.BusDetails;
import entities.Passenger;
import entities.Transaction;
import exception.InvalidDetailsException;
import services.AdminService;
import services.BusDetailServices;
import services.PassengerService;
import services.impl.AdminServiceImpl;
import services.impl.PassengerImpl;
import utility.FileExist;

public class Main {
	
	private static final String BUS_FILE_NAME = "busDetials.ser";

	public static void main(String[] args) {
		
		Map<String,Passenger> passenger= FileExist.passengerFile();
		Map<String,BusDetails> busDetails = FileExist.busDetails();
		List<Transaction> transaction = FileExist.transaction();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome , To Apna Bus Reservation System");
		
		int preference = 0;
		do {
			System.out.println("Please enter your preference, " + " '1' --> Admin login ,"
					+ " '2' --> Passenger Service , "
					+ " '0' for exit");
			preference = sc.nextInt();
			switch(preference){
			case 1:
				adminService(sc,busDetails);
			case 2:
				passengerService(sc,passenger, busDetails);
			}
			
		} while(preference != 0);
		
		
		
	}

	private static void passengerService(Scanner sc,
			Map<String, Passenger> passenger,
			Map<String, BusDetails> bus) {
		
		int preference = 0;
		String username = "";
		do {
			PassengerService psi = new PassengerImpl();
			System.out.println("Enter 1 for Sign Up");
			System.out.println("Enter 2 for Login");
			preference = sc.nextInt();
			try {
				switch(preference){
				case 1:
					username = psi.signUp(sc,passenger);
					break;
				case 2:
					username = psi.signIn(sc,passenger);	
					preference = 0;
					break;
				default: 
					throw new Exception("Please Enter Valid Preference");
				}
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			finally{
				updateBusSerFile(passenger);
			}
			
		} while(preference != 0);
		
		passengerServiceAfterLoggedIn(sc,passenger,bus, username);
		
		
	}

	private static void passengerServiceAfterLoggedIn(Scanner sc, Map<String, Passenger> passenger,
			Map<String, BusDetails> bus, String username) {
		System.out.println("Hello " + username + " please choose a service");
	}

	private static void updateBusSerFile(Map<String, Passenger> passenger) {
		try {
			ObjectOutputStream oos = 
					new ObjectOutputStream(new FileOutputStream("PassengerDetails.ser"));
			oos.writeObject(passenger);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void adminService(Scanner sc, Map<String, BusDetails> busDetails) {
		
		AdminService as = new AdminServiceImpl();
		try {
			as.login(sc);
		} catch(InvalidDetailsException e) {
			System.out.println(e.getMessage());
			return;
		}
		int preference = 0;
		do {
			System.out.println("Please enter your preference, " + " "
					+ "'1' --> Add Bus Details , '2' --> Update Bus Detils, "
					+ "'3' --> Delete Bus Details , '4' --> View Bookings, "
					+ "'5' --> View Booking By UserName Of Passenger , '6' --> View Bookings By Bus Name, "
					+ "'7' View Booking For Date Range, '0' For Exit");
			preference = sc.nextInt();
			try {
				switch(preference){
				case 1:
					as.addBusDetails(sc,busDetails);
					break;
				case 2:
					as.updateBusDetils(sc,busDetails);	
					System.out.println("Bus Details Successfully Updated");
					break;
				case 3:	
					as.deleteBusDetails(sc,busDetails);
					System.out.println("Bus Details Successfully Deleted");
					break;
				case 4:
					as.viewBookings(busDetails);
					break;
				case 5:
					as.viewbookingByUserNameOfPassenger();
					break;
				case 6:
					as.viewbookingsByBusName();
					break;
				case 7:
					as.viewBookingForDateRange();
					break;
				default: 
					throw new Exception("Please Enter Valid Preference");
				}
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			finally {
				updateSerFile(busDetails);
			}
		} while(preference != 0);
		
		
	}

	private static void updateSerFile(Map<String, BusDetails> busDetails) {
		try {
			ObjectOutputStream oos = 
					new ObjectOutputStream(new FileOutputStream("busDetials.ser"));
			oos.writeObject(busDetails);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
