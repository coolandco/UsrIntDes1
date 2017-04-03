package kontrollschicht;

import java.util.regex.Pattern;

public class stringChecks {
	
	public static boolean checkPassword(String pw) {
		
		return (pw.equals("")) ? false : true;//if string empty password invalid
	}
	
	public static boolean checkName(String name){
		
		return Pattern.matches("[a-zA-Z_]+", name); 
		//characters a-z
		//characters A-Z
		//characters _
		//+ --> one or more
	}

}
