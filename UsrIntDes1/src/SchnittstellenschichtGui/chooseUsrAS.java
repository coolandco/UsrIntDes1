package SchnittstellenschichtGui;


import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;

import kontrollschicht.chooseUsrK;

public class chooseUsrAS {

	//################################################
		//Singelton Pattern
	    private static chooseUsrAS instance;
	    
	    private chooseUsrAS(){}
	    
	    public static chooseUsrAS getInstance(){
	        if(instance == null){
	            instance = new chooseUsrAS();
	        }
	        return instance;
	    }
	    
	    public static void removeInstance(){
	    	instance = null;
	    }
	   //################################################

	    private chooseUsrK kontrolle;
	    
	    private JList<String> list;
	    private DefaultListModel<String> model;
	    private JScrollPane pane;
	    
	    
	    
	    
	    public void öffnen(){
			kontrolle = new chooseUsrK();
			
			//her goes the user table and slider and stuff
			
			model = new DefaultListModel<String>();
			list = new JList<String>(model);
			pane = new JScrollPane(list);
			
			list.setMinimumSize(new Dimension(150, 400));
			pane.setMinimumSize(new Dimension(150, 400));
			
			
			for(String user : kontrolle.getPossibleUserNames()){
				model.addElement(user);
			}
			
	    }
	    
	    
	    public JComponent getComponent(){
	    	
	    	return pane;
	    }
	    
	    //returns the currently choosen user
		public String getChoosenUser() {
			
			return list.getSelectedValue();
		}
	
}
