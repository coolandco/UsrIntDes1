package Schnittstellenschicht;

import kontrollschicht.admAddUsrK;

public class admAddUsrAAS extends consoleHandler {
	
	//################################################
	//Singelton Pattern
    private static admAddUsrAAS instance;
    
    private admAddUsrAAS(){}
    
    public static admAddUsrAAS getInstance(){
        if(instance == null){
            instance = new admAddUsrAAS();
        }
        return instance;
    }
    
    public static void removeInstance(){
    	instance = null;
    }
   //################################################

    admAddUsrK kontrolle;
    
	@Override
	protected boolean befehl(String befehl) {
		
		return false;
	}
	


	public void öffnen() {
		kontrolle = new admAddUsrK();
		
		System.out.println();
		System.out.println("Bitte geben Sie den Namen ein:");
		kontrolle.enterName(newRequest());
		
		System.out.println("Bitte geben Sie das Passwort ein:");
		kontrolle.enterPassword(newRequest());
		
		System.out.println("Möchten Sie den Benutzer als Admin anlegen? y/n");
		kontrolle.cooseAdmin(newRequest());
		
		try {
			kontrolle.applyAddUser();
		} catch (Exception e) {
			System.out.println("FEHLER:");
			System.out.println(e.getMessage());
			schliessen();
		}
		
		
	}
	
	public void schliessen() {
		kontrolle = null;
		removeInstance();
	}
    
    

}
