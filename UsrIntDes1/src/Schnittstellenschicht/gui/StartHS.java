package Schnittstellenschicht.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
    
    
    private JPanel contentPane;

	public static void main(String[] args) {
		
		Sachbearbeiter.setHardImplementedLoginDetails();//puts 2 accounts in the db
		
		StartHS.getInstance().öffnen();
	}

	
	public void öffnen() {
		
		//set up the jFrame:
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);


		
		setVisible(true);
		//setUpGui();
		
		
		LoginAAS.getInstance().öffnen();
	}
	
	
	public JPanel[] resetPanel(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 5, 5));
		
		
		//set up the panels as a 1-column-grid-layout filled with box grid layouts
		Panel panel_0 = new Panel();
		contentPane.add(panel_0);
		panel_0.setLayout(new BoxLayout(panel_0, BoxLayout.X_AXIS));
		
		Panel panel_1 = new Panel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		Panel panel_2 = new Panel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		Panel panel_3 = new Panel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		Panel panel_4 = new Panel();
		contentPane.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		return null;
		
	}
	
	
	

}
