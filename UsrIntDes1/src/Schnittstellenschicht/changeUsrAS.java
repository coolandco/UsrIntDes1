package Schnittstellenschicht;

import kontrollschicht.changeUsrK;

public class changeUsrAS extends consoleHandler {

	// ################################################
	// Singelton Pattern
	private static changeUsrAS instance;

	private changeUsrAS() {
	}

	public static changeUsrAS getInstance() {
		if (instance == null) {
			instance = new changeUsrAS();
		}
		return instance;
	}

	public static void removeInstance() {
		instance = null;
	}
	// ################################################

	changeUsrK kontrolle;
	
	boolean ende = false;

	@Override
	protected boolean befehl(String befehl) {
		switch (befehl){
		case "changeName":
			changeName();
			return true;
		case "changePassword":
			changePassword();
			return true;
		case "changeRole":
			changeRole();
			return true;
		case "ende":
			schliessen();
			return true;
		}
		
		
		return false;
	}
	
	

	public void �ffnen(){
		kontrolle = new changeUsrK();
		
		System.out.println("W�hlen Sie erst einen benutzer, den Sie �ndern wollen:");
		
		chooseUsrAS.getInstance().�ffnen(true);//l�sst den benutzer ausw�hlen
		
		String choosenUser = chooseUsrAS.getInstance().getChoosenUser();
		
		if(choosenUser == null) {
			System.out.println("Es wurde kein benutzer ausgew�hlt");
			schliessen();
			return;
		}
				
		kontrolle.setUser(choosenUser);
		
		try {
			kontrolle.isAllowedToChange();//would throw exeption
		} catch (Exception e) {
			System.out.println(e.getMessage());
			schliessen();
			return;
		}
		
		while(ende == false) {//men�, f�r was ge�ndert werden soll
			System.out.println("");
			System.out.println("was m�chsten Sie mit dem benutzer \"" + choosenUser +"\" tun?");
			System.out.println("changeName");
			System.out.println("changePassword");
			System.out.println("changeRole");
			System.out.println("ende");
			
			newBefehl();
			
		}
		
	}
	
	
	public void schliessen(){
		ende = true;
		removeInstance();
		kontrolle = null;
	}



	private void changeName() {
		try {
			System.out.println("Aktueller Name ist " + kontrolle.getCurrentName());
			System.out.println("geben Sie einen neuen Namen ein:");
			kontrolle.setNewName(newRequest());
			
			System.out.println("Name ge�ndert");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ende = true;
			schliessen();
			return;
		}
				
	}
	
	private void changePassword() {
		try {
			System.out.println("geben Sie einen neues Passwort ein f�r Benutzer " + kontrolle.getCurrentName() + ":");
			kontrolle.setNewPassword(newRequest());
			
			System.out.println("Passwort ge�ndert");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ende = true;
			schliessen();
			return;
		}
	}
	
	
	private void changeRole() {
		try {
			System.out.println("Aktuelle Rolle des Benutzers " + 
					kontrolle.getCurrentName() + " ist " + kontrolle.getCurrentRole());
			System.out.println("Bitte geben Sie \"y\" f�r admin und \"n\" f�r Sachbearbeiter ein");
			kontrolle.setNewRole(newRequest());
			
			System.out.println("Rolle ge�ndert");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ende = true;
			schliessen();
			return;
		}
		
	}
	
}
