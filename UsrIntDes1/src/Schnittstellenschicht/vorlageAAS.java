package Schnittstellenschicht;

import kontrollschicht.admAddUsrK;

public class vorlageAAS extends consoleHandler {
	
	//################################################
	//Singelton Pattern
    private static vorlageAAS instance;
    
    private vorlageAAS(){}
    
    public static vorlageAAS getInstance(){
        if(instance == null){
            instance = new vorlageAAS();
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
