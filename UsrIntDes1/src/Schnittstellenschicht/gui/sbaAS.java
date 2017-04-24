package Schnittstellenschicht.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import kontrollschicht.SachbearbeiterS;


public class sbaAS {
	
	//################################################
	//Singelton Pattern
    private static sbaAS instance;
    
    private sbaAS(){}
    
    public static sbaAS getInstance(){
        if(instance == null){
            instance = new sbaAS();
        }
        return instance;
    }
    
    public static void removeInstance(){
    	instance = null;
    }
   //################################################

    
    private JButton btnChangeUsr;
    private JButton btnAbmelden;
    
    
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
		
		
		//row 2
		
		//remove those panels to extend later panel[1]
		panels[1].getParent().remove(panels[2]);
		panels[1].getParent().remove(panels[3]);
		panels[1].getParent().remove(panels[4]);
		
		//panels[1] should be 1 big panel now
		//panels[1].setSize(panels[1].getWidth() ,  panels[1].getHeight() * 4); //TODO: doesnt work
		
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
    

}
