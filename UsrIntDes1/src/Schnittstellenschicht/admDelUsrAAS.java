package Schnittstellenschicht;

import kontrollschicht.admAddUsrK;
import kontrollschicht.admDelUsrK;
import kontrollschicht.chooseUsrK;

public class admDelUsrAAS extends consoleHandler {
	
	//################################################
	//Singelton Pattern
    private static admDelUsrAAS instance;
    
    private admDelUsrAAS(){}
    
    public static admDelUsrAAS getInstance(){
        if(instance == null){
            instance = new admDelUsrAAS();
        }
        return instance;
    }
    
    public static void removeInstance(){
    	instance = null;
    }
   //################################################

    admDelUsrK kontrolle;
    
	@Override
	protected boolean befehl(String befehl) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public void �ffnen() {
		kontrolle = new admDelUsrK();
		
		chooseUsrAS.getInstance().�ffnen();//l�sst den benutzer ausw�hlen
		
		String choosenUser = chooseUsrAS.getInstance().getChoosenUser();
		
		if(choosenUser == null) {
			System.out.println("Es wurde kein benutzer ausgew�hlt");
			schlie�en();
			return;
		}
			
		
		kontrolle.enterName(choosenUser);//gibt das an die Kontrollschicht weiter
		
		try {
			kontrolle.f�hreDelUserDurch();//und versucht den benutzer zu l�schen
		} catch (Exception e) {
			System.out.println("Fehler:");
			System.out.println(e.getMessage());
			schlie�en();
			return;
		}
		
		
		System.out.println("Der benutzer " + choosenUser + " wurde erfolgreich gel�scht");
	}
	
	public void schlie�en() {
		kontrolle = null;
		removeInstance();
		
	}
    
    

}
