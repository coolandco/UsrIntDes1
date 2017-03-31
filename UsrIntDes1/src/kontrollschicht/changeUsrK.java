package kontrollschicht;

import entityClass.Sachbearbeiter;

public class changeUsrK {
	
	private Sachbearbeiter choosenUser;
	
	

	public void setUser(String choosenUser) {
		
		this.choosenUser = Sachbearbeiter.get(choosenUser);
		
	}

	
	public String getCurrentName() throws Exception{
		pr�feIsUserChoosen();//throws Exception if no user is choosen
		
		return choosenUser.getName();
	}
	
	
	public String getCurrentRole() throws Exception{
		pr�feIsUserChoosen();//throws Exception if no user is choosen
		
		return (choosenUser.getRole().equals("admin")) ? "admin" : "sachbearbeiter";
	}
	
	
	public void setNewName(String newName) throws Exception{
		pr�feIsUserChoosen();//throws Exception if no user is choosen
		pr�feRechte();//pr�fen berechtigung
		
		//TODO: implement string checks, maybe static methodes in another class
		choosenUser.setName(newName);
		
	}
	
	public void setNewPassword(String newPassword) throws Exception{
		pr�feIsUserChoosen();//throws Exception if no user is choosen
		pr�feRechte();//pr�fen berechtigung
		
		//TODO: implement string checks, maybe static methodes in another class
		choosenUser.setPassword(newPassword);
		
	}
	
	public void setNewRole(String newRole) throws Exception{
		pr�feIsUserChoosen();//throws Exception if no user is choosen
		pr�feRechte();//pr�fen berechtigung
		
		//TODO: implement string checks, maybe static methodes in another class
		if(newRole.equals("y")){
			choosenUser.setRole("admin");
		} else {
			choosenUser.setRole("sba");
		}
	}
	
	public boolean isAllowedToChange() throws Exception {
		pr�feIsUserChoosen();//throws Exception if no user is choosen
		
		try {
			pr�feRechte();
		} catch (Exception e){
			throw new Exception("Sie d�rfen den ausgew�hlten Benutzer nicht �ndern");
		}
		
		return true;//everythings correct
	}
	
	//HELPERS#####################################################
	
	private void pr�feIsUserChoosen() throws Exception{
		if(choosenUser == null)
			throw new Exception("Benutzer wurde nicht richtig ausgew�hlt");
	}
	
	private void pr�feRechte() throws Exception{
		//throws if s.o. wants to change admin and a sba is logged on
		if(choosenUser.getRole().equals("admin") && SachbearbeiterS.getInstance().isSbaLoggedIn())
			throw new Exception("Fehlende Berechtigung");
	}
	
	

}
