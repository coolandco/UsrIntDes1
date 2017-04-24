package Schnittstellenschicht.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import entityClass.Sachbearbeiter;
import kontrollschicht.SachbearbeiterS;

public class StartHS extends JFrame implements backHandler {
	
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
		
		StartHS.getInstance().firstInit();
	}

	
	private void firstInit() {
		//set up the jFrame:
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setVisible(true);
		
		öffnen();
	}
	

	public void öffnen() {
		
		LoginAAS.getInstance().öffnen();//first show login window

	}
	

	@Override
	public void zurück() {
		
		//prüft ob login erfolgreich war
		if(SachbearbeiterS.getInstance().isSbaLoggedIn()){
			sbaAS.getInstance().öffnen();
		}else if(SachbearbeiterS.getInstance().isAdminLoggedIn()){//prüft ob login erfolgreich war
			admAS.getInstance().öffnen();//opens up the next oberfläche
		} else {
			System.exit(0);//the 3rd reason to go back is to exit.
		}
		
	}
	
	public JPanel[] getPanels() {
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 5, 5));
		
		
		//set up the panels as a 1-column-grid-layout filled with box grid layouts
		JPanel panel_0 = new JPanel();
		contentPane.add(panel_0);
		panel_0.setLayout(new BoxLayout(panel_0, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		
		panels.add(panel_0);
		panels.add(panel_1);
		panels.add(panel_2);
		panels.add(panel_3);
		panels.add(panel_4);
		
		return panels.toArray(new JPanel[5]);
	}
	
	public void resetPanel(){
		//TODO: maybe better possibillity to reset panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		repaint();
		
	}

	
	
	

}
