package Schnittstellenschicht.gui;

import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LoginAAS {
	
	//################################################
		//Singelton Pattern
	    private static LoginAAS instance;
	    
	    private LoginAAS(){}
	    
	    public static LoginAAS getInstance(){
	        if(instance == null){
	            instance = new LoginAAS();
	        }
	        return instance;
	    }
	    
	    public static void removeInstance(){
	    	instance = null;
	    }
	   //################################################

	    
		private JTextField txtName;
		private JTextField txtPasswort;
	    
	    
	    public void öffnen() {
	    	
	    	JPanel panels[] = StartHS.getInstance().resetPanel();//get the set up content panels
	    			
			
			//now we can add stuff like buttons
			
			//row 1
			JButton btnBeenden = new JButton("Beenden");
			panels[0].add(btnBeenden);
			
			JButton btnLogin = new JButton("Login");
			panels[0].add(btnLogin);
			
			//row 2
			txtName = new JTextField();
			txtName.setText("name");
			panels[1].add(txtName);
			txtName.setColumns(10);
			
			//row 3
			txtPasswort = new JTextField();
			txtPasswort.setText("passwort");
			panels[2].add(txtPasswort);
			txtPasswort.setColumns(10);
			
			//row 4
			JRadioButton rdbtnSachbearbeiter = new JRadioButton("Sachbearbeiter");
			panels[3].add(rdbtnSachbearbeiter);
			
			JRadioButton rdbtnAdmin = new JRadioButton("Admin");
			panels[3].add(rdbtnAdmin);
	    }
}
