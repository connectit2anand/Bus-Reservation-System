import java.util.List;
import java.util.Map;
import java.util.Scanner;
import entities.BusDetails;
import entities.Passenger;
import entities.Transaction;
import services.BusDetailServices;
import utility.FileExist;

public class Main {

	public static void main(String[] args) {
		Map<Long,Passenger> passenger= FileExist.passengerFile();
		Map<Long,BusDetails> busDetails = FileExist.busDetails();
		List<Transaction> transaction = FileExist.transaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome , in Product Management System");
		
		
		
		
	}
}
