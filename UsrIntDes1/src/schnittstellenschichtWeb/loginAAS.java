package schnittstellenschichtWeb;


import javax.faces.bean.ManagedBean;


@ManagedBean

public class loginAAS {


	public String name = "name";
	public String passwort = "passwort";
	
	public void  login() {
		LoggerWindow.log(name);
		LoggerWindow.log(passwort);
		
		
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
}
