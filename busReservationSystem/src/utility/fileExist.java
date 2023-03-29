package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entities.BusDetails;
import entities.Passenger;
import entities.Transaction;

public class FileExist {
	
	public static Map<Long,Passenger> passengerFile(){
		
		File f = new File("passenger.ser");
		Map<Long,Passenger> pFile = null;
		try {
			if(!f.exists()) {
				f.createNewFile();
				 pFile = new HashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(f));
				oos.writeObject(pFile);
			} else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				pFile = (Map<Long,Passenger>) ois.readObject();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pFile;	
	}
	
	public static Map<Long,BusDetails> busDetails(){
		
		File f = new File("busDetials.ser");
		Map<Long,BusDetails> bFile = null;
		try {
			if(!f.exists()) {
				f.createNewFile();
				bFile = new HashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(bFile);
			} else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				bFile = (Map<Long,BusDetails>) ois.readObject();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return bFile;
		
	}
	
	public static List<Transaction> transaction(){
		
		File f = new File("transaction.ser");
		List<Transaction> tFile = new ArrayList<>();
		try {
			if(!f.exists()) {
				f.createNewFile();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(tFile);
			} else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				tFile = (List<Transaction>) ois.readObject();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return tFile;
	}
	
}
