package UI_Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_password;
	private JTextField txt_player_name;

	/**
	 * Create the frame.
	 */
	public register() {
		setTitle("Register Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitileGame = new JLabel("SNAKE GAME");
		lbTitileGame.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lbTitileGame.setBounds(72, 11, 223, 54);
		contentPane.add(lbTitileGame);
		
		JPanel pn_register = new JPanel();
		pn_register.setLayout(null);
		pn_register.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Register", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn_register.setBounds(56, 60, 248, 224);
		contentPane.add(pn_register);
		
		JButton btn_login = new JButton("Login");
		btn_login.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btn_login.setBounds(10, 174, 91, 39);
		pn_register.add(btn_login);
		
		JButton btn_register = new JButton("Register");
		btn_register.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btn_register.setBounds(135, 174, 103, 39);
		pn_register.add(btn_register);
		
		JLabel lb_username = new JLabel("Username:");
		lb_username.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_username.setBounds(10, 35, 75, 17);
		pn_register.add(lb_username);
		
		JLabel lb_password = new JLabel("Password:");
		lb_password.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_password.setBounds(10, 84, 75, 17);
		pn_register.add(lb_password);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txt_username.setColumns(10);
		txt_username.setBounds(95, 30, 143, 28);
		pn_register.add(txt_username);
		
		txt_password = new JTextField();
		txt_password.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txt_password.setColumns(10);
		txt_password.setBounds(95, 79, 143, 28);
		pn_register.add(txt_password);
		
		JLabel lb_player_name = new JLabel("Player Name:");
		lb_player_name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_player_name.setBounds(10, 128, 75, 17);
		pn_register.add(lb_player_name);
		
		txt_player_name = new JTextField();
		txt_player_name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txt_player_name.setColumns(10);
		txt_player_name.setBounds(95, 123, 143, 28);
		pn_register.add(txt_player_name);
		
		JButton btn_exit = new JButton("EXIT");
		btn_exit.setBackground(Color.RED);
		btn_exit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btn_exit.setBounds(122, 295, 117, 39);
		contentPane.add(btn_exit);
		
		//event of components
		/*
		 	Event of exit button
			use to exit program
		 */		
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		/*
		 	Event of login button
			use to open login form
		 */
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setVisible(false);
				login form_login = new login();
				form_login.setVisible(true);
			}
		});
		
		/*
	 		Event of register button
			use to open register form
		 */
	}

}
