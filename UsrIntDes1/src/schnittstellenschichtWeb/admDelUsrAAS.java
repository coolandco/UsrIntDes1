package schnittstellenschichtWeb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import kontrollschicht.admDelUsrK;


@ManagedBean
@RequestScoped

public class admDelUsrAAS {

	@ManagedProperty(value = "#{admAS.choosenUser}")
    private String choosenUser;
	
	private admDelUsrK kontrolle;
	
	
	
	public String delete(){
		
		try {
			kontrolle.führeDelUserDurch();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(e.getMessage(), e.getMessage()));
			return null;
		}
		
		return zurueck();
	
	}
	
	
	
	public String zurueck() {
		
		return "/admAS.xhtml";
	}



	public String getChoosenUser() {
		return choosenUser;
	}
	
	
	public void setChoosenUser(String user) {
		//this is the first methode that is been called
		System.out.println("methode Set choosen user mit: " + user);
		
		
		this.choosenUser = user;
		
		kontrolle = new admDelUsrK();
		kontrolle.enterName(user);
		
	}
	
}
