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
	
	
	
	public boolean f�hreLoginDurch(boolean adminMode) throws Exception{
		
		Sachbearbeiter s = SachbearbeiterS.getInstance().getEK(name);//wenn Sachbearbeiter existiert; throws Exeption
		
		if ( !(s.getPassword().equals(passwort)) )//wenn passwort nicht stimmt
			throw new Exception("Passwort stimmt nicht mit " + name + " �berein.");
		
		//Login anforderungen wurden gepr�ft
		SachbearbeiterS.getInstance().setLogin(s);
		
		if(adminMode)
			SachbearbeiterS.getInstance().switchAdminModeOn();
		
		return true; //if we are here, everything is right.
	}
	
	
	
	public boolean f�hreLoginDurch() throws Exception{
		
		return f�hreLoginDurch(false);//admin mode Off
	}
	
	
	
	
}
