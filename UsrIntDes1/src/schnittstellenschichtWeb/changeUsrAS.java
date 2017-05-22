package schnittstellenschichtWeb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import kontrollschicht.changeUsrK;

public class changeUsrAS {
	
	private String choosenUser;
	
	private String name;
	private String passwort;
	private String choosenRole;
	
	private changeUsrK kontrolle;
	
	public String speichern(){
		
		try {
			
			kontrolle.setNewName(name);
			
			if(!passwort.equals(""))
				kontrolle.setNewPassword(passwort);
			
			if(choosenRole.equals("2"))
				kontrolle.setNewRole("admin");
			else 
				kontrolle.setNewRole("sachbearbeiter");

			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(
					e.getMessage()));
			return null;
		}
		
		
		return "/sbaAS.xhtml";
		
	}
	
	public String zurueck(){
	
		return "/sbaAS.xhtml";
	}
	
	
	
	public String getChoosenUser() {
		return choosenUser;
	}
	
	public void setChoosenUser(String choosenUser) {
		//this is the first mehrode that is been called
		
		this.choosenUser = choosenUser;
		
		kontrolle = new changeUsrK();
		kontrolle.setUser(choosenUser);
		
		try {
			name = kontrolle.getCurrentName();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(
					e.getMessage()));
		}
		
		passwort = "";
		
		
		try {
			if(kontrolle.getCurrentRole().equals("admin")){
				choosenRole = "2";
			} else {
				choosenRole = "1";
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(
					e.getMessage()));
		}

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswort() {
		return "";//do not show Password
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
