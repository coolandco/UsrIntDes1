package Schnittstellenschicht;


import java.util.ArrayList;

import kontrollschicht.chooseUsrK;

public class chooseUsrAS extends consoleHandler {
	
	//################################################
	//Singelton Pattern
    private static chooseUsrAS instance;
    
    private chooseUsrAS(){}
    
    public static chooseUsrAS getInstance(){
        if(instance == null){
            instance = new chooseUsrAS();
        }
        return instance;
    }
    
    public static void removeInstance(){
    	instance = null;
    }
   //################################################

    private chooseUsrK kontrolle;
    
    private boolean markAdmins = false;
    
    
	@Override
	protected boolean befehl(String befehl) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public void öffnen(){
		kontrolle = new chooseUsrK();
		
		while(kontrolle.getChoosenUserName() == null){//as long as nothing is choosen
			
			ArrayList<String> admins = kontrolle.getAdminNames();
			
			for(String s : kontrolle.getPossibleUserNames()) {//print all user names
				if(markAdmins || admins.contains(s))//marks the addmins
					System.out.println(s + "*");
				else
					System.out.println(s);
			}
			
			System.out.println();
			System.out.println("Bitte geben Sie einen Namen oder \"abbrechen\" ein:");
			System.out.println("Alle admins wurden mit einem * markiert");
			
			String antwort = newRequest();
			
			if(antwort.equals("abbrechen")) {
				schließen();
				break; //exit loop
			}
				
			
			try {
				kontrolle.chooseUser(antwort);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Bitte erneut versuchen:");
				continue;//begins from start
			}
						
		}
		
	}
	
	
	public void öffnen(boolean markAdmins){
		this.markAdmins = markAdmins;
		
		öffnen();
		
	}
	
	
	public String getChoosenUser(){
		
		return kontrolle == null ? null : kontrolle.getChoosenUserName(); //returns null if kontrolle is not set yet
	}
	
	
	
	public void schließen() {
		kontrolle = null;
		removeInstance();
		
	}
    
    

}
