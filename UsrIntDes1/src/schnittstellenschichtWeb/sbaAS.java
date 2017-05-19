package schnittstellenschichtWeb;

import kontrollschicht.SachbearbeiterS;
import kontrollschicht.chooseUsrK;

public class sbaAS {
	
	private String user = "";
	
	
	public String bearbeiten(){
		return null;
		
	}

	public String abmelden(){
		return null;
		
	}
	
	
	

	public String getUser() {//for jsf
		
		return new chooseUsrK().getPossibleUserNames()[0]; // null pointer can happen
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String[] getUsers() {
		return new chooseUsrK().getPossibleUserNames();
	}
}
