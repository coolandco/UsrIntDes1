package kontrollschicht;

import entityClass.Sachbearbeiter;

public class admAddUsrK {
	

	
	private String name;
	private String passwort;
	private boolean adminMode = false;
	
	
	public void enterName(String name){

		this.name = name;	
	}
	
	
	public void enterPassword(String pw){
		
		this.passwort = pw;
	}
	
	
	public void cooseAdmin(String chooseAdmin){
		
		if(chooseAdmin.equalsIgnoreCase("y"))
			adminMode = true;
		else
			adminMode = false;
	}
	
	
	public boolean applyAddUser() throws Exception{
		
		try {
		
			if(SachbearbeiterS.getInstance().getEK(name) != null)
				throw new Exception("Der benutzer mit dem eingegebenen Benutzernamen existiert schon");
			
			if(checkUsername() == false)
				throw new Exception("Der eingegebene Benutzername kann nicht benutzt werden");
			
			if(checkPassword() == false)
				throw new Exception("Das eingegebene Passwort kann nicht benutzt werden");
			
		
		} catch (Exception e) {
			//TODO: tidy up?
			throw e; //but do not handle the exeption
		}
		
		
		new Sachbearbeiter(name,adminMode,passwort);
		
		
		
		return true;
			
	}
	
	


	private boolean checkPassword() {
		// TODO not implemented
		return true;
	}


	private boolean checkUsername() {
		// TODO not implemented
		return true;
	}

}
