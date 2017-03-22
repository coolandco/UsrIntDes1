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
		// TODO Auto-generated method stub
		return false;
	}
	
	public void öffnen() {
		
	}

}
