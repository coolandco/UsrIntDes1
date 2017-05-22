package schnittstellenschichtWeb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import kontrollschicht.SachbearbeiterS;
import kontrollschicht.chooseUsrK;

public class sbaAS {
	
	private String user = "";
	
	
	public String bearbeiten(){
		System.out.println("1");
		if(user.equals("")){
			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(
					"Es wurde kein benutzer ausgewählt"));
			System.out.println("2");
			return null;
		} 
		
		chooseUsrK kontrolle = new chooseUsrK();
		System.out.println("3");
		try {
			kontrolle.chooseUser(user);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(
					e.getMessage()));
			return null;
		}
		System.out.println("4");
		
		return "/changeUsrAS.xhtml?user=" + user;
		
		
		
	}

	public String abmelden(){
		return null;
		
	}
	
	
	

	public String getUser() {//for jsf
		System.out.println("5");
		return new chooseUsrK().getPossibleUserNames()[0]; // null pointer can happen
	}

	public void setUser(String user) {
		System.out.println("7");
		this.user = user;
	}

	public String[] getUsers() {
		System.out.println("6");
		return new chooseUsrK().getPossibleUserNames();
	}
}
