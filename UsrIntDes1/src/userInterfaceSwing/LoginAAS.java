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

public class LoginAAS extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textField;

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
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{1, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblLogin = new JLabel("Login:");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 1;
		gbc_lblLogin.gridy = 3;
		contentPane.add(lblLogin, gbc_lblLogin);
		
		JLabel lblBenutzername = new JLabel("Benutzername:");
		GridBagConstraints gbc_lblBenutzername = new GridBagConstraints();
		gbc_lblBenutzername.anchor = GridBagConstraints.EAST;
		gbc_lblBenutzername.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenutzername.gridx = 1;
		gbc_lblBenutzername.gridy = 4;
		contentPane.add(lblBenutzername, gbc_lblBenutzername);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 1;
		gbc_lblPasswort.gridy = 5;
		contentPane.add(lblPasswort, gbc_lblPasswort);
		
		JLabel lblRolle = new JLabel("Rolle:");
		GridBagConstraints gbc_lblRolle = new GridBagConstraints();
		gbc_lblRolle.insets = new Insets(0, 0, 5, 5);
		gbc_lblRolle.gridx = 1;
		gbc_lblRolle.gridy = 6;
		contentPane.add(lblRolle, gbc_lblRolle);
	}

}
