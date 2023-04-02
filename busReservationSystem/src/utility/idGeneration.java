package utility;

public class IdGeneration {
	
	public static Long generatetId() {
		Long id = new Double(Math.random() * 100000).longValue();
		return id;
	}
}
