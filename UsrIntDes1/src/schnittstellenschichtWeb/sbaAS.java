package schnittstellenschichtWeb;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import kontrollschicht.SachbearbeiterS;
import kontrollschicht.chooseUsrK;

@ManagedBean
@SessionScoped

public class sbaAS {
	
	
	protected String user = "";
	protected String userTrans = "";
	
	
	public String bearbeiten(){

		if(chooseUsrOperations())
			return "/changeUsrAS.xhtml"; 
		else
			return null;//s.t. went wrong	

	}
	
	
	//this has to be called bevore new page for a choosen user openes
	//then there needs to be a managedproperty on "choosenUser"
	protected boolean chooseUsrOperations(){
		
		if(user.equals("")){
			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(
					"Es wurde kein benutzer ausgew‰hlt"));
			return false;
		} 
		
		chooseUsrK kontrolle = new chooseUsrK();

		try {
			kontrolle.chooseUser(user);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(
					e.getMessage()));
			return false;
		}
		
		return true;
	}
	

	public String abmelden(){
		
		SachbearbeiterS.removeInstance();
		schlieﬂen();
		
		return "/loginAAS.xhtml";
		
	}
	
	protected void schlieﬂen() {
		user = "";
				
	}
	
	
	

	public String getUser() {//for jsf

		return new chooseUsrK().getPossibleUserNames()[0]; // null pointer can happen
	}
	
	public String getUserTrans(){
		return userTrans;
	}
	

	public void setUser(String user) {
		System.out.println("user set: " + user);
		this.user = user;
		userTrans = user; //for transfer
	}

	public String[] getUsers() {

		return new chooseUsrK().getPossibleUserNames();
	}
}
