package Schnittstellenschicht;


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
    
    private boolean ende = false;
    
    
	@Override
	protected boolean befehl(String befehl) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public void öffnen(){
		kontrolle = new chooseUsrK();
		
		while(kontrolle.getChoosenUserName() == null){//as long as nothing is choosen
			
			for(String s : kontrolle.getPossibleUserNames())//print all user names
				System.out.println(s);
			
			System.out.println();
			System.out.println("Bitte geben Sie einen Namen oder \"abbrechen\" ein:");
			
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
	
	
	public String getChoosenUser(){
		
		return kontrolle == null ? null : kontrolle.getChoosenUserName(); //returns null if kontrolle is not set yet
	}
	
	
	
	public void schließen() {
		kontrolle = null;
		removeInstance();
		
	}
    
    

}
