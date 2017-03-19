package kontrollschicht;

import entityClass.Sachbearbeiter;

public class LoginK {

	
	private String name;
	private String passwort;
	
	
	
	public void enterName(String name){
		
		this.name = name;	
	}
	
	
	public void enterPassword(String pw){
		
		this.passwort = pw;
	}
	
	
	
	public boolean führeLoginDurch(boolean adminMode) throws Exception{
		
		Sachbearbeiter s = SachbearbeiterS.getInstance().getEK(name);//wenn Sachbearbeiter existiert; throws Exeption
		
		if ( !(s.getPassword().equals(passwort)) )//wenn passwort nicht stimmt
			throw new Exception("Passwort stimmt nicht mit " + name + " überein.");
		
		//Login anforderungen wurden geprüft
		SachbearbeiterS.getInstance().setLogin(s);
		
		if(adminMode)
			SachbearbeiterS.getInstance().switchAdminModeOn();
		
		return true; //if we are here, everything is right.
	}
	
	
	
	public boolean führeLoginDurch() throws Exception{
		
		return führeLoginDurch(false);//admin mode Off
	}
	
	
	
	
}
