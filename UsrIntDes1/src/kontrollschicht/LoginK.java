package kontrollschicht;

import entityClass.Sachbearbeiter;

public class LoginK {

	
	private String name;
	private String passwort;
	private boolean adminMode = false;
	
	
	
	public void enterName(String name){

		this.name = name;	
	}
	
	
	public void enterPassword(String pw){
		
		this.passwort = pw;
	}
	
	public void cooseAdmin(String chooseAdmin){
		
		if(chooseAdmin.equalsIgnoreCase("y"))
			adminMode = true;
		else
			adminMode = false;
	}
	
	
	
	public boolean f�hreLoginDurch() throws Exception{
		
		Sachbearbeiter s = SachbearbeiterS.getInstance().getEK(name);//wenn Sachbearbeiter existiert; throws Exeption
		
		
		
		
		if ( !(s.getPassword().equals(passwort)) )//wenn passwort nicht stimmt
			throw new Exception("Passwort stimmt nicht mit " + name + " �berein.");
		
		//Login anforderungen wurden gepr�ft
		SachbearbeiterS.getInstance().setLogin(s);
		
		if(adminMode)
			SachbearbeiterS.getInstance().switchAdminModeOn();
		
		return true; //if we are here, everything is right.
	}
	
	
	
	
}
