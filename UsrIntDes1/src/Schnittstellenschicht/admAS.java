package Schnittstellenschicht;

import kontrollschicht.SachbearbeiterS;

public class admAS extends consoleHandler {
	
	//################################################
	//Singelton Pattern
    private static admAS instance;
    
    private admAS(){}
    
    public static admAS getInstance(){
        if(instance == null){
            instance = new admAS();
        }
        return instance;
    }
    
    public static void removeInstance(){
    	instance = null;
    }
   //################################################
	
    private boolean ende = false;
	
	@Override
	protected boolean befehl(String befehl) {
		
		switch (befehl){
		case "addUser":
			admAddUsrAAS.getInstance().öffnen();
			return true;
		case "removeUser":
			
			return true;
		case "changeUser":
			
			return true;
		case "beenden":
			schliessen();
			return true;
		}
		
		
		return false;
	}
	
	
	public void öffnen() {
		
		while(ende == false) {
			System.out.println("");
			System.out.println("was möchsten sie tun?");
			System.out.println("addUser");
			System.out.println("removeUser");
			System.out.println("changeUser");
			System.out.println("beenden");
			
			newBefehl();
		}
		
	}
	
	public void schliessen(){
		SachbearbeiterS.removeInstance(); //abmelden
		ende = true;
		removeInstance();
		
	}

}
