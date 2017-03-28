package kontrollschicht;

import entityClass.Sachbearbeiter;

public class SachbearbeiterS {
	
	//################################################
	//Singelton Pattern
    private static SachbearbeiterS instance;
    
    private SachbearbeiterS(){}
    
    public static SachbearbeiterS getInstance(){
        if(instance == null){
            instance = new SachbearbeiterS();
        }
        return instance;
    }
    
    public static void removeInstance(){
    	instance = null;
    }
   //################################################
    
    private Sachbearbeiter sba;//diese ist nach dem login gefüllt
    private boolean adminMode = false; //standardmäßig ist der admin mode aus
	
	
	/**
	 * Throws Exeption if Sachbearbeiter nicht gefunden.
	 * @param name
	 * @return
	 * @throws Exception
	 */	
	public Sachbearbeiter getEK(String name) throws Exception {
		Sachbearbeiter s = Sachbearbeiter.get(name);
		
		if(s != null)
			return Sachbearbeiter.get(name);//returns a Sachbearbeiter with given name
		else
			throw new Exception("Sachbearbeiter " + name + " nicht gefunden.");
	}
	
	
	public boolean EKexists(String name) throws Exception {
		Sachbearbeiter s = Sachbearbeiter.get(name);
		
		if(s != null)
			return true;
		else
			return false;
	}
	
	
	public void setLogin(Sachbearbeiter s){//führt den login durch
		sba = s;	
	}
	
	public void switchAdminModeOn() throws Exception{//schaltet den Admin Mode ein
		if(sba == null)
			throw new Exception("Admin mode kann nicht eingeschaltet werden");
		
		if(sba.getRole().equals("admin"))
			adminMode = true;
		else
			throw new Exception("Admin mode kann nicht eingeschaltet werden. Fehlende Berechtigung");
	}
	
	
	public boolean isSbaLoggedIn(){
		
		return ((sba != null) && sba.getRole().equals("sba")) ? true : false;//returns true if sba not null and sba.role == sba
	}
	
	public boolean isAdminLoggedIn(){
		
		return ((sba != null) && sba.getRole().equals("admin")) ? true : false;//returns true if sba not null and sba.role == admin
	}
	
	
	
	
	
	
	

}
