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

public class admAS extends sbaAS{
	
	
	
	
//	private String user = "";
//	private String choosenUser = "";
	
	
//	public String bearbeiten(){
//
//		if(chooseUsrOperations())
//			return "/changeUsrAS.xhtml"; 
//		else
//			return null;//s.t. went wrong	
//
//	}
	

//	public String abmelden(){
//		
//		SachbearbeiterS.removeInstance();
//		schlieﬂen();
//		
//		return "/loginAAS.xhtml";
//		
//	}
	
	private String choosenUserAdm = "";
	


	public String addNewUser(){
		
		return "/admAddUsrAAS.xhtml";
	}
	
	
	public String deleteUser(){
		
		if(chooseUsrOperations())
			return "/admDelUsrAAS.xhtml"; 
		else
			return null;//s.t. went wrong	
	}
	
	
	public String getChoosenUserAdm() {
		return choosenUserAdm;
	}


	public void setChoosenUserAdm(String choosenUserAdm) {
		this.choosenUserAdm = choosenUserAdm;
		super.choosenUser = choosenUserAdm;//maybe that fixes the problem
	}
	
	//this has to be called bevore new page for a choosen user openes
	//then there needs to be a managedproperty on "choosenUser"
//	private boolean chooseUsrOperations(){
//		
//		if(user.equals("")){
//			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(
//					"Es wurde kein benutzer ausgew‰hlt"));
//			return false;
//		} 
//		
//		chooseUsrK kontrolle = new chooseUsrK();
//
//		try {
//			kontrolle.chooseUser(user);
//		} catch (Exception e) {
//			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(
//					e.getMessage()));
//			return false;
//		}
//		
//		return true;
//	}
	
	
//	private void schlieﬂen() {
//		user = "";
//		choosenUser = "";
//				
//	}
	
	

//	public String getUser() {//for jsf
//
//		return new chooseUsrK().getPossibleUserNames()[0]; // null pointer can happen
//	}
//	
//	public String getChoosenUser() {
//		System.out.println("user getChoosenUser: " + user);
//		return user;
//	}
//
//	public void setUser(String user) {
//		System.out.println("user set: " + user);
//		this.user = user;
//	}
//
//	public String[] getUsers() {
//
//		return new chooseUsrK().getPossibleUserNames();
//	}
}
