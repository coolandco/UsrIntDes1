package Schnittstellenschicht;

import kontrollschicht.SachbearbeiterS;

public class sbaAS extends consoleHandler {
	
	//################################################
	//Singelton Pattern
    private static sbaAS instance;
    
    private sbaAS(){}
    
    public static sbaAS getInstance(){
        if(instance == null){
            instance = new sbaAS();
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
		case "changeUser":
			changeUsrAS.getInstance().öffnen();
			return true;
		case "abmelden":
			schliessen();
			return true;
		}
		return false;
	}
	
	public void öffnen() {
		
		while(ende == false){
			System.out.println("");
			System.out.println("was möchsten sie tun?");
			System.out.println("changeUser");
			System.out.println("abmelden");
			newBefehl();
		}
		
	}
	
	public void schliessen(){
		
		SachbearbeiterS.removeInstance(); //abmelden
		ende = true;
		removeInstance();
		
		
	}

}
