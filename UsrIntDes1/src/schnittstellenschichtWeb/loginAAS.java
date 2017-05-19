package schnittstellenschichtWeb;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import entityClass.Sachbearbeiter;
import kontrollschicht.LoginK;
@ManagedBean

public class loginAAS {

	private LoginK kontrolle;

	private String name = "name";
	private String passwort = "passwort";
	private String choosenRole = "1"; //Sachbearbeiter
	
	
	
	public String  login() {
		kontrolle = new LoginK();
		
		
		kontrolle.enterName(name);
		kontrolle.enterPassword(passwort);
		
		if (choosenRole.equals("2"))//admin
			kontrolle.cooseAdmin("y");
		else
			kontrolle.cooseAdmin("n");
		
		
		
		
		try {
			kontrolle.führeLoginDurch();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(e.getMessage(), e.getMessage()));
			return "/loginAAS.xhtml";
		}
		
		
		//goto next page
		if (choosenRole.equals("1"))//admin
			return "/sbaAS.xhtml";
		else
			return "/admAS.xhtml";
		
	}
	
	public void bevoelkern(){
		Sachbearbeiter.setHardImplementedLoginDetails();
		
	}


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}


	public String getChoosenRole() {
		return choosenRole;
	}


	public void setChoosenRole(String choosenRole) {
		this.choosenRole = choosenRole;
	}
}
