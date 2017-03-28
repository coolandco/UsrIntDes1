package Schnittstellenschicht;

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

	@Override
	protected boolean befehl(String befehl) {
		
		switch (befehl){
		case "changeUser":
			return true;
		case "abmelden":
			schliessen();
			return true;
		}
		return false;
	}
	
	public void öffnen() {
		
		System.out.println("");
		System.out.println("was möchsten sie tun?");
		System.out.println("changeUser");
		System.out.println("abmelden");
		
	}
	
	public void schliessen(){
		
		
	}

}
