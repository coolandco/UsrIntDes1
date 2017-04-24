package Schnittstellenschicht.gui;

public class admAS {
	
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
    
	public void öffnen() {
		System.out.println("opened admAs");
		
	}
}
