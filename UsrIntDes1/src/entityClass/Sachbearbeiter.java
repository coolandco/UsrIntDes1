package entityClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * this class is the Database of all Sachbearbeiter
 * 
 */
public class Sachbearbeiter {
	
	//db = Database
	private static Set<Sachbearbeiter> db = new HashSet<Sachbearbeiter>();
	
	public static void  setHardImplementedLoginDetails(){
		
		new Sachbearbeiter("leo", "sba", "abc");
		new Sachbearbeiter("kevin", "admin", "123");
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	
	public static String[] getAllNames(){
		
		ArrayList<String> names = new ArrayList<String>();
		
		for (Sachbearbeiter s : db ) {
			names.add(s.getName());
		}
		
		return names.toArray(new String[0]);//TODO: whatch out nullPointer ex
	}
	
	
	
	
	/**
	 * 
	 * @param name
	 * @return Returns a new Instance with same Values as Given Instance.
	 */
	public static Sachbearbeiter getCopy(String name){
		Sachbearbeiter s = get(name);
		
		return new Sachbearbeiter(s.getName(),s.getRole(),s.getPassword());
		
	}
	
	
	
	
	/**
	 * 
	 * @param name
	 * @return Returns Null if name not found in List
	 */
	public static Sachbearbeiter get(String name){
		
		for( Sachbearbeiter s: db){
			if(s.name.equals(name))
				return s;
		}
		return null;
	}
	
	
	//########################################################################################
	//here the instancial Stuff
	
	
	//Name des Sba
	private String name;
	
	//Role = admin oder sba
	private String role;
	
	//safes Password
	private String password;
	
	
	
	
	/**
	 * Creates instance of Sachbearbeiter and puts it into the db
	 */
	public Sachbearbeiter(){
		name = ""; //TODO: Redundant code. Its very less, so don't worry.
		role = "";
		password = "";
		db.add(this);
	}
	
	/**
	 * Creates instance of Sachbearbeiter and puts it into the db
	 * @param name
	 * @param role --> "sba" or "admin"
	 */
	
	public Sachbearbeiter(String name, String role, String pw){
		this.name = name;
		this.role = role;
		this.password = pw;
		db.add(this);
	}
	
	
	/**
	 * Creates instance of Sachbearbeiter and puts it into the db
	 * @param name
	 * @param role true--> admin | role false --> sba
	 */
	public Sachbearbeiter(String name, boolean role, String pw){
		this.name = name;
		this.role = role ? "admin" : "sba"; //if role == true --> admin
		this.password = pw;
		
		db.add(this);
	}
	
	
	/**
	 * this will copy the attributes from another instanz of sachbearbeiter to this instance.
	 * @param s
	 * TODO: what happens when "Null" as parameter?
	 */
	public void copyAttributes(Sachbearbeiter s){
		setName(s.getName());
		setRole(s.getRole());
		setPassword(s.getPassword());
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
