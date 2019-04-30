package Schnittstellenschicht.gui;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import kontrollschicht.LoginK;
import kontrollschicht.SachbearbeiterS;

public class LoginAAS implements backHandler {
	
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

	    LoginK kontrolle;

	    private JButton btnLogin;
	    private JButton btnBeenden;
		private JTextField txtName;
		private JTextField txtPasswort;
	    private JRadioButton rdbtnAdmin;
	    private JRadioButton rdbtnSachbearbeiter;
	    
	    
	    public void öffnen() {
	    	//Set up
	    	kontrolle = new LoginK();
	    	JPanel panels[] = StartHS.getInstance().getPanels();//get the set up content panels
	    			
			
			//now we can add stuff like buttons
			
			//row 1
	    	btnBeenden = new JButton("Beenden");
			panels[0].add(btnBeenden);
			
			
			
			btnLogin = new JButton("Login");
			panels[0].add(btnLogin);
			
			
			
			//row 2
			txtName = new JTextField();
			txtName.setText("name");
			panels[1].add(txtName);
			txtName.setColumns(10);
			txtName.requestFocus();
			
			//row 3
			txtPasswort = new JTextField();
			txtPasswort.setText("passwort");
			panels[2].add(txtPasswort);
			txtPasswort.setColumns(10);
			
			
			
			//row 4
			rdbtnSachbearbeiter = new JRadioButton("Sachbearbeiter");
			panels[3].add(rdbtnSachbearbeiter);
			
			rdbtnAdmin = new JRadioButton("Admin");
			panels[3].add(rdbtnAdmin);
			
			ButtonGroup rdbtnGrp = new ButtonGroup();
			rdbtnGrp.add(rdbtnSachbearbeiter);
			rdbtnGrp.add(rdbtnAdmin);
			
			
			
			
			//Action Listeners
			btnBeenden.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					schließen();
					
				}
				
			});
			
			
			btnLogin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
						führeLoginDurch();
				}
			});
			
			
			KeyListener kl = new KeyListener() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					System.out.println(e);
					
					if(e.getKeyCode() == KeyEvent.VK_ENTER){
						btnLogin.doClick();
												
					} else if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown()){
						btnBeenden.doClick();
												
					}	
					
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
	    		
	    	};
	    	
	    	txtName.addKeyListener(kl);
	    	txtPasswort.addKeyListener(kl);
	    	rdbtnAdmin.addKeyListener(kl);
	    	rdbtnSachbearbeiter.addKeyListener(kl);
			
			
			
			
			//finish
			StartHS.getInstance().pack();
			
	    }
	    


		protected void führeLoginDurch() {
			//TODO: Do some checks
			
			//give login details to kontrolle
			kontrolle.enterName(txtName.getText());
			kontrolle.enterPassword(txtPasswort.getText());
			if(rdbtnAdmin.isSelected())
				kontrolle.cooseAdmin("y");//TODO not good in kontrollschicht
			else
				kontrolle.cooseAdmin("n");
			
			
			//try to login
			try {
				kontrolle.führeLoginDurch();
				
				schließen();//returns to StartHS
				return;
				
			} catch (Exception e) {
				//handle if login fails
				JOptionPane.showMessageDialog(null,
					    e.getMessage(),
					    "Login error",
					    JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		

		private void schließen() {
			//reset this instance and point back to the startHS to zurück();
			kontrolle = null;
			removeInstance();
			StartHS.getInstance().resetPanel();
			
			//go back for some reason
			SwingUtilities.invokeLater(new Runnable() {
			    public void run() {
			        StartHS.getInstance().zurück();
			    }
			});
			
		}
		
		
		@Override
		public void zurück() {
			öffnen();
			
		}
}
