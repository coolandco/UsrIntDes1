package userInterfaceSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JRadioButton;

public class LoginAAS extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPasswort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAAS frame = new LoginAAS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginAAS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 5, 5));
		
		Panel panel_0 = new Panel();
		contentPane.add(panel_0);
		panel_0.setLayout(new BoxLayout(panel_0, BoxLayout.X_AXIS));
		
		JButton btnBeenden = new JButton("Beenden");
		panel_0.add(btnBeenden);
		
		JButton btnLogin = new JButton("Login");
		panel_0.add(btnLogin);
		
		Panel panel_1 = new Panel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		txtName = new JTextField();
		txtName.setText("name");
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		Panel panel_2 = new Panel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		txtPasswort = new JTextField();
		txtPasswort.setText("passwort");
		panel_2.add(txtPasswort);
		txtPasswort.setColumns(10);
		
		Panel panel_3 = new Panel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JRadioButton rdbtnSachbearbeiter = new JRadioButton("Sachbearbeiter");
		panel_3.add(rdbtnSachbearbeiter);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		panel_3.add(rdbtnAdmin);
		
		Panel panel_4 = new Panel();
		contentPane.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
	}

}
