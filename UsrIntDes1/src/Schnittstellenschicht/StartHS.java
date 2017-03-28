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
	
    boolean ende = false;
    
	public static void main(String[] args) {
		
		Sachbearbeiter.setHardImplementedLoginDetails();//puts 2 accounts in the db
		
		StartHS.getInstance().öffnen();

	}
	
	

	private void öffnen() {
		
		while(ende == false){
		
			System.out.println();
			System.out.println("Hallo, bitte gebe einen der Folgenden befehle ein:");		
			System.out.println("login");
			System.out.println("beenden");
			
			newBefehl();
			
			if(SachbearbeiterS.getInstance().isSbaLoggedIn()){//prüft ob login erfolgreich war
				LoginAAS.getInstance().schliessen();
				sbaAS.getInstance().öffnen();
			}else if(SachbearbeiterS.getInstance().isAdminLoggedIn()){//prüft ob login erfolgreich war
				LoginAAS.getInstance().schliessen();
				admAS.getInstance().öffnen();//opens up the next oberfläche
			} else {
				System.out.println("Login war nicht erfolgreich, bitte versuche es von vorne!");
				öffnen();
			}
		}
		
		
	}
	

	
	
	@Override
	protected boolean befehl(String befehl) {
		
		switch (befehl){
		case "login":
			LoginAAS.getInstance().öffnen();
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
