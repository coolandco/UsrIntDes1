package Schnittstellenschicht.gui;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


import kontrollschicht.admDelUsrK;

public class admDelUsrAAS {
	
	//################################################
	//Singelton Pattern
    private static admDelUsrAAS instance;
    
    private admDelUsrAAS(){}
    
    public static admDelUsrAAS getInstance(){
        if(instance == null){
            instance = new admDelUsrAAS();
        }
        return instance;
    }
    
    public static void removeInstance(){
    	instance = null;
    }
   //################################################

    admDelUsrK kontrolle;
    
    
    public void öffnen(){
    	
    	kontrolle = new admDelUsrK();
    	
    	
    	kontrolle.enterName(chooseUsrAS.getInstance().getChoosenUser()); 	

    	
    	int result = JOptionPane.showOptionDialog(null,"Do you want to delete user " + chooseUsrAS.getInstance().getChoosenUser(),
    		    null,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
    	
    	if(result == JOptionPane.YES_OPTION){
    		try {
				kontrolle.führeDelUserDurch();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
    	}
    	
    	schließen();//missetat begangen
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
