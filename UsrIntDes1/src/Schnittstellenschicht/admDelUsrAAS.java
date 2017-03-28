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
	
	
	public void öffnen() {
		kontrolle = new admDelUsrK();
		
		chooseUsrAS.getInstance().öffnen();//lässt den benutzer auswählen
		
		String choosenUser = chooseUsrAS.getInstance().getChoosenUser();
		
		if(choosenUser == null) {
			System.out.println("Es wurde kein benutzer ausgewählt");
			schließen();
			return;
		}
			
		
		kontrolle.enterName(choosenUser);//gibt das an die Kontrollschicht weiter
		
		try {
			kontrolle.führeDelUserDurch();//und versucht den benutzer zu löschen
		} catch (Exception e) {
			System.out.println("Fehler:");
			System.out.println(e.getMessage());
			schließen();
			return;
		}
		
		
		System.out.println("Der benutzer " + choosenUser + " wurde erfolgreich gelöscht");
	}
	
	public void schließen() {
		kontrolle = null;
		removeInstance();
		
	}
    
    

}
