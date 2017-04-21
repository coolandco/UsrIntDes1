package Schnittstellenschicht.gui;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entityClass.Sachbearbeiter;

public class StartHS extends JFrame {
	
	//################################################
		//Singelton Pattern
	    private static StartHS instance;
	    
	    private StartHS(){}
	    
	    public static StartHS getInstance(){
	        if(instance == null){
	            instance = new StartHS();
	        }
	        return instance;
	    }
	    
	    public static void removeInstance(){
	    	instance = null;
	    }
	   //################################################
	    
	    JPanel panel;

	public static void main(String[] args) {
		
		Sachbearbeiter.setHardImplementedLoginDetails();//puts 2 accounts in the db
		
		StartHS.getInstance().öffnen();
	}

	
	public void öffnen() {
		setUpGui();
		
	}
	
	

	private void setUpGui() {
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH); //maximize jframe
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //default operation on close
		
		panel = new JPanel();
		
		//Box box = Box.createHorizontalBox();
	    //box.add(Box.createHorizontalGlue());
	    
	    //add(box, BorderLayout.NORTH);
	    
		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);//create Boxlayout
		
		panel.setLayout(boxlayout); //add Boxlayout to panel
		
		
		panel.setBorder(new EmptyBorder(new Insets(30, 50, 30, 50)));//Setup Border
		
		

        JButton jbLogin = new JButton("Login");
        JButton jbBeenden = new JButton("Beenden");

        box.add(jbLogin);
        box.add(jbBeenden);
        
        add(panel);
        setVisible(true);
        

		
		
		
		
	}

}
