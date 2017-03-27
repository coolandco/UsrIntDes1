package Schnittstellenschicht;

import kontrollschicht.LoginK;

public class LoginAAS extends consoleHandler {

	
	//################################################
	//Singelton Pattern
    private static LoginAAS instance;
    
    private LoginAAS(){}
    
    public static LoginAAS getInstance(){
        if(instance == null){
            instance = new LoginAAS();
        }
        return instance;
    }
    
    public static void removeInstance(){
    	instance = null;
    }
   //################################################
	
    LoginK kontrolle;
    
	
	@Override
	protected boolean befehl(String befehl) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public void öffnen() {
		kontrolle = new LoginK();
		
		System.out.println();
		System.out.println("Bitte geben Sie den Namen ein:");
		kontrolle.enterName(newRequest());
		
		System.out.println("Bitte geben Sie das Passwort ein:");
		kontrolle.enterPassword(newRequest());
		
		System.out.println("Möchten Sie als Admin eingeloggt werden? y/n");
		kontrolle.cooseAdmin(newRequest());
		
		try {
			kontrolle.führeLoginDurch();
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
