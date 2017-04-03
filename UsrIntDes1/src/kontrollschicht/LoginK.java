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
	
	
	
	public boolean führeLoginDurch() throws Exception{
		
		try{
		
			Sachbearbeiter s = SachbearbeiterS.getInstance().getEK(name);//wenn Sachbearbeiter nicht existiert throws Exeption
			
			
			
			
			if ( !(s.getPassword().equals(passwort)) )//wenn passwort nicht stimmt
				throw new Exception("Passwort stimmt nicht mit " + name + " überein.");
			
			//Login anforderungen wurden geprüft
			SachbearbeiterS.getInstance().setLogin(s);
			
			if(adminMode)
				SachbearbeiterS.getInstance().switchAdminModeOn();
			
			return true; //if we are here, everything is right.
			
		} catch (Exception e) {
			
			
			SachbearbeiterS.removeInstance(); // so we remove every evidence of the login
			throw e; //but do not handle the exeption
		}
		
	}
	
	
	
	
}
