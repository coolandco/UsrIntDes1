package SchnittstellenschichtGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import kontrollschicht.admAddUsrK;
import kontrollschicht.admDelUsrK;
import kontrollschicht.changeUsrK;

public class admAddUsrAAS {

	//################################################
		//Singelton Pattern
	    private static admAddUsrAAS instance;
	    
	    private admAddUsrAAS(){}
	    
	    public static admAddUsrAAS getInstance(){
	        if(instance == null){
	            instance = new admAddUsrAAS();
	        }
	        return instance;
	    }
	    
	    public static void removeInstance(){
	    	instance = null;
	    }
	   //################################################

	    admAddUsrK kontrolle;
	    
	    
	    private JButton btnZurück;
		private JButton btnSpeichern;
		private JTextField txtName;
		private JTextField txtPasswort;
	    private JRadioButton rdbtnAdmin;
	    private JRadioButton rdbtnSachbearbeiter;

		
		public void öffnen(){
			kontrolle = new admAddUsrK();
			
			//Set up
	    	JPanel panels[] = StartHS.getInstance().getPanels();//get the set up content panels
	    	   	
	    	
	    	//row 1
	    	btnZurück = new JButton("Zurück");
	    	panels[0].add(btnZurück);
	    	btnSpeichern = new JButton("Speichern");
	    	panels[0].add(btnSpeichern);
	    	
	    	
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
	    	
			//finish
			StartHS.getInstance().pack();
	    	
	    	
		
	    }
	    
	    
	    protected void saveChanges() {
			
	    	if (! txtName.getText().equals("") && 
	    			! txtPasswort.getText().equals("") &&
	    			( rdbtnAdmin.isSelected() || 
	    			  rdbtnSachbearbeiter.isSelected())){// checks nothing empty
	    		
				kontrolle.enterName(txtName.getText());//  set name
				kontrolle.enterPassword(txtPasswort.getText());
				
				if(rdbtnAdmin.isSelected())
					kontrolle.cooseAdmin("y");
				else
					kontrolle.cooseAdmin("n");
	    	
	    	}else {
				JOptionPane.showMessageDialog(null, "Please enter something in all data fields");
				return;
			}
	    	
	    	
	    	
	    	try {
				kontrolle.applyAddUser();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return;
			}    	
	    	
	    	
	    	schließen();//everything was applied
	    	return;
	    	
	    	
			
			
		}

		protected void schließen() {		
			removeInstance();
			
			StartHS.getInstance().resetPanel();
			
			//go back
			SwingUtilities.invokeLater(new Runnable() {
			    public void run() {
			        admAS.getInstance().zurück();
			    }
			});
			
		}
	
}
