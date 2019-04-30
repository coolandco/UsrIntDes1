package SchnittstellenschichtGui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import kontrollschicht.SachbearbeiterS;

public class admAS implements backHandler{
	
	//################################################
	//Singelton Pattern
    private static admAS instance;
    
    private admAS(){}
    
    public static admAS getInstance(){
        if(instance == null){
            instance = new admAS();
        }
        return instance;
    }
    
    public static void removeInstance(){
    	instance = null;
    }
   //################################################
    
    private JButton btnAbmelden;
	private JButton btnChangeUsr;
    private JButton btnDelUsr;
    private JButton btnAddUsr;
    
    
	public void öffnen() {
		//Set up
		
    	JPanel panels[] = StartHS.getInstance().getPanels();//get the set up content panels
    	
    	//prepare list
    	chooseUsrAS.getInstance().öffnen();
    	
    	
		//now we can add stuff like buttons
		
		//row 1
    	btnAbmelden = new JButton("Abmelden");
		panels[0].add(btnAbmelden);
		
		
		
		btnChangeUsr = new JButton("Change User");
		panels[0].add(btnChangeUsr);
		
		btnDelUsr = new JButton("Delete User");
		panels[0].add(btnDelUsr);
		
		btnAddUsr = new JButton("Add User");
		panels[0].add(btnAddUsr);
		
		
		
		
		//row 2
		
		//remove those panels to extend later panel[1]
		//adjust panels
		panels[1].getParent().remove(panels[2]);
		panels[1].getParent().remove(panels[3]);
		panels[1].getParent().remove(panels[4]);
		StartHS.getInstance().getContentPane().setLayout(new GridLayout(2, 1, 5, 5));
		
		//panels[1] should be 1 big panel now
//		panels[1].setSize(panels[1].getWidth() ,  panels[1].getHeight() * 4); //TODO: doesnt work
		
		
		//add List
		panels[1].add(chooseUsrAS.getInstance().getComponent());
		
		
		
		
		
		
		//Action Listeners
		btnAbmelden.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				schließen();
				
			}
			
		});
		
		
		btnChangeUsr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//check if user has been choosen and open changeUserAS 
				if(chooseUsrAS.getInstance().getChoosenUser() != null)
					changeUsrAS.getInstance().öffnen();
			}
		});
		
		
		btnDelUsr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//check if user has been choosen 
				if(chooseUsrAS.getInstance().getChoosenUser() != null)
					admDelUsrAAS.getInstance().öffnen();
			}
		});
		
		
		btnAddUsr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admAddUsrAAS.getInstance().öffnen();
			}
		});
		
		
		
		//show
		
		StartHS.getInstance().pack();
		//StartHS.getInstance().repaint();
		
		
		
	}
	

	
	protected void schließen() {
		SachbearbeiterS.removeInstance(); //abmelden
		
		removeInstance();
		
		StartHS.getInstance().resetPanel();
		
		//go back
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        LoginAAS.getInstance().zurück();
		    }
		});
		
	}

	@Override
	public void zurück() {
		öffnen();
		
	}
}
