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
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public void öffnen(){
		
	}
	
	public void schließen() {
		
		
	}
    
    

}
