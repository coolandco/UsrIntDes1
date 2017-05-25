package schnittstellenschichtWeb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import kontrollschicht.SachbearbeiterS;
import kontrollschicht.changeUsrK;


@ManagedBean
@RequestScoped
public class changeUsrAS {
	
	//private String choosenUser;
	
	private String name;
	private String passwort;
	private String choosenRole;
	
	private changeUsrK kontrolle;
		
	
	@ManagedProperty(value = "#{sbaAS.userTrans}")
    private String userSba;
	
	
	
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
		
		return zurueck();
		
	}
	


	public String zurueck(){
	
		schließen();
		
		if(SachbearbeiterS.getInstance().isAdminLoggedIn())
			return "/admAS.xhtml";
    	else
    		return "/sbaAS.xhtml";
		
	}
	
	//zurücksetzen der props
	private void schließen() {
		name = null;
		passwort = null;
		choosenRole = null;
		
		kontrolle = null;
		
	}
	
	
	private void kontrolleUser(String user) {
		//this is the first methode that is been called
		System.out.println("methode Set choosen user mit: " + user);
		
		
		kontrolle = new changeUsrK();
		kontrolle.setUser(user);
		
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

	

	public void setUserSba(String user) {
		
		if(user != null && !user.equals(""))
			kontrolleUser(user);
		else
			kontrolleUser("");

	}
	
//	public void setUserAdm(String user){
//		
//		if(user != null && !user.equals(""))
//			kontrolleUser(user);
//		else
//			kontrolleUser("");
//	}



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
