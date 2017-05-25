package schnittstellenschichtWeb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class choosenUserTransfer {
	
	private String choosenUser = "";

	
	
	public String getChoosenUser() {
		System.out.println("transferuser get: " + choosenUser);
		return choosenUser;
	}

	public void setChoosenUser(String choosenUser) {
		System.out.println("transferuser set: " + choosenUser);
		this.choosenUser = choosenUser;
	} 

}
