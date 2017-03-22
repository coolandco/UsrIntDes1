package Schnittstellenschicht;

import java.io.Console;
import java.io.IOException;

import entityClass.Sachbearbeiter;
import kontrollschicht.SachbearbeiterS;

public class StartHS extends consoleHandler {
	
	
	//################################################
	//Singelton Pattern
    private static StartHS instance;
    
    private StartHS(){}
    
    public static StartHS getInstance(){
        if(instance == null){
            instance = new StartHS();
        }
        return instance;
    }
    
    public static void removeInstance(){
    	instance = null;
    }
   //################################################
	
	public static void main(String[] args) {
		
		Sachbearbeiter.setHardImplementedLoginDetails();//puts 2 accounts in the db
		
		StartHS.getInstance().�ffnen();

	}
	
	

	private void �ffnen() {
		System.out.println();
		System.out.println("Hallo, bitte gebe einen der Folgenden befehle ein:");		
		System.out.println("login");
		System.out.println("beenden");
		
		newBefehl();
		
		if(SachbearbeiterS.getInstance().isSbaLoggedIn()){//pr�ft ob login erfolgreich war
			sbaAS.getInstance().�ffnen();
		}else if(SachbearbeiterS.getInstance().isAdminLoggedIn()){//pr�ft ob login erfolgreich war
			sbaAS.getInstance().�ffnen();
		} else {
			System.out.println("Login war nicht erfolgreich, bitte versuche es von vorne!");
			�ffnen();
		}
		
		
	}
	

	
	
	@Override
	protected boolean befehl(String befehl) {
		
		switch (befehl){
		case "login":
			LoginAAS.getInstance().�ffnen();
			return true;
		case "beenden":
			schliessen();
			return true;
		}
		
		return false;
	}
	

	private void schliessen() {
		System.exit(0);
	}


}
