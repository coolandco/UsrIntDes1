package schnittstellenschichtWeb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import kontrollschicht.SachbearbeiterS;
import kontrollschicht.admAddUsrK;


@ManagedBean
@RequestScoped
public class admAddUsrAAS {

	private admAddUsrK kontrolle;

	private String name = "name";
	private String passwort = "passwort";
	private String choosenRole = "1"; //Sachbearbeiter
	
	
	
	public String anlegen() {
		kontrolle = new admAddUsrK();
		
		kontrolle.enterName(name);
		
		kontrolle.enterPassword(passwort);
		
		if (choosenRole.equals("2"))//admin
			kontrolle.cooseAdmin("y");
		else
			kontrolle.cooseAdmin("n");
		
		
		
		
		try {
			kontrolle.applyAddUser();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("frmCreds", new FacesMessage(e.getMessage(), e.getMessage()));
			return null;//do nothing
		}
		
		
		return zurueck();
		
	}
	
	
	public String zurueck(){
		
		//goto page bevore
		if (SachbearbeiterS.getInstance().isAdminLoggedIn())//admin
			return "/sbaAS.xhtml";
		else
			return "/admAS.xhtml";
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
