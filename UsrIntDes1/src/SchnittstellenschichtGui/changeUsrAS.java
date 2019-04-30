package SchnittstellenschichtGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import kontrollschicht.SachbearbeiterS;
import kontrollschicht.changeUsrK;

public class changeUsrAS {
	
	// ################################################
		// Singelton Pattern
		private static changeUsrAS instance;

		private changeUsrAS() {
		}

		public static changeUsrAS getInstance() {
			if (instance == null) {
				instance = new changeUsrAS();
			}
			return instance;
		}

		public static void removeInstance() {
			instance = null;
		}
		// ################################################
		
		private JButton btnZurück;
		private JButton btnSpeichern;
		private JTextField txtName;
		private JTextField txtPasswort;
	    private JRadioButton rdbtnAdmin;
	    private JRadioButton rdbtnSachbearbeiter;
		
		
		private changeUsrK kontrolle;
		
		public void öffnen(){
			kontrolle = new changeUsrK();
			
			//Set up
	    	JPanel panels[] = StartHS.getInstance().getPanels();//get the set up content panels
	    	
	    	
	    	String usr = chooseUsrAS.getInstance().getChoosenUser();
	    	if(usr == null) {
	    		schließen();
	    		return;//TODO: do some error handling in kontrollschicht wenn usr == null ist
	    	}else
	    		kontrolle.setUser(usr);
	    	
	    	
	    	//row 1
	    	btnZurück = new JButton("Zurück");
	    	panels[0].add(btnZurück);
	    	btnSpeichern = new JButton("Speichern");
	    	panels[0].add(btnSpeichern);
	    	
	    	
	    	//row 2
			txtName = new JTextField();
			txtName.setText(usr);
			panels[1].add(txtName);
			txtName.setColumns(10);
			txtName.requestFocus();
			
			//row 3
			txtPasswort = new JTextField();
			txtPasswort.setText("");
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
			
			
			try {
				if(kontrolle.getCurrentRole().equals("admin"))
					rdbtnAdmin.setSelected(true);
				else
					rdbtnSachbearbeiter.setSelected(true);
			} catch (Exception e1) {
				schließen();
			}
	    	
	    	
	    	btnZurück.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					schließen();
					
				}
				
			});
	    	
	    	
	    	btnSpeichern.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//try to safe changes
					saveChanges();
					
				}
				
			});
	    	
	    	KeyListener kl = new KeyListener() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					System.out.println(e);
					
					if(e.getKeyCode() == KeyEvent.VK_S && e.isControlDown()){
						btnSpeichern.doClick();
												
					} else if(e.getKeyCode() == KeyEvent.VK_B && e.isControlDown()){
						btnZurück.doClick();
												
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
	    	
	    	
			//finish
			StartHS.getInstance().pack();
	    	
	    	
		}
		
		
		
		private void saveChanges() {
			
			try {
	
				if (!txtName.getText().equals(""))// checks name for empty
	
					kontrolle.setNewName(txtName.getText());// trys to set name
	
				else {
					JOptionPane.showMessageDialog(null, "Please check the name not empty");
					return;
				}
				
	
				if (!txtPasswort.getText().equals("")) { // if password is empty it
															// doesnt get changed
	
					kontrolle.setNewPassword(txtPasswort.getText());
				}
				
	
				if (kontrolle.getCurrentRole().equals("admin") && rdbtnSachbearbeiter.isSelected()) {
					kontrolle.setNewRole("Sachbearbeiter");
				}
				
	
				if (kontrolle.getCurrentRole().equals("sachbearbeiter") && rdbtnAdmin.isSelected()) {
					kontrolle.setNewRole("Admin");
				}
	
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return;
			}
			
			//we are here, that means every change has been taken over
			
			schließen();
			
		}
		
		

		private void schließen() {			
			removeInstance();
			
			StartHS.getInstance().resetPanel();
			
			//go back
			SwingUtilities.invokeLater(new Runnable() {
			    public void run() {
			    	if(SachbearbeiterS.getInstance().isAdminLoggedIn())
			    		admAS.getInstance().zurück();
			    	else
			    		sbaAS.getInstance().zurück();
			    }
			});
			
		}

}
