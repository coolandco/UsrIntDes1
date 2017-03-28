package kontrollschicht;

import entityClass.Sachbearbeiter;

public class admDelUsrK {
	
	
	private String name;
	
	public void enterName(String name){
		this.name = name;	
	}

	
	
	public void führeDelUserDurch() throws  Exception {
		
		if(! SachbearbeiterS.getInstance().EKexists(name))
			throw new Exception("Der benutzer mit dem namen " + name + " existiert nicht");
		
		
		Sachbearbeiter.get(name).delete();//deletes the Sachbearbeiter
		
	}
}
