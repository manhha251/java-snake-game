package UI_Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public main_menu() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title_game = new JLabel("SNAKE GAME");
		lb_title_game.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lb_title_game.setBounds(75, 24, 223, 54);
		contentPane.add(lb_title_game);
		
		JButton btn_new_game = new JButton("New Game");
		btn_new_game.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_new_game.setBounds(107, 89, 164, 33);
		contentPane.add(btn_new_game);
		
		JButton btn_load_game = new JButton("Load Game");
		btn_load_game.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_load_game.setBounds(107, 141, 164, 33);
		contentPane.add(btn_load_game);
		
		JButton btn_settings = new JButton("Settings");
		btn_settings.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_settings.setBounds(107, 246, 164, 33);
		contentPane.add(btn_settings);
		
		JButton btn_hight_score = new JButton("Hight Score");
		btn_hight_score.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_hight_score.setBounds(107, 194, 164, 33);
		contentPane.add(btn_hight_score);
		
		JButton btn_logout = new JButton("Logout");

		btn_logout.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_logout.setBounds(107, 298, 164, 33);
		contentPane.add(btn_logout);
		
		//Event of components:
		/*
		 	event of new game button 
		 	use to open boar game
		 */
		btn_new_game.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setVisible(false);
				game_board form_game_boar  =new game_board();
				form_game_boar.setVisible(true);
			}
		});
		
		/*
	 		event of load game button 
	 		use to open load game page 
		 */
		btn_load_game.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setVisible(false);
				load_game form_load_game  =new load_game();
				form_load_game.setVisible(true);
			}
		});
		
		/*
 			event of high score button 
 			use to open high score page 
		 */		
		btn_hight_score.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setVisible(false);
				high_score form_high_score  =new high_score();
				form_high_score.setVisible(true);
			}
		});

		/*
			event of setting button 
			use to open setting page 
		 */		
		btn_settings.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setVisible(false);
				settings form_settings  =new settings();
				form_settings.setVisible(true);				
			}
		});
		
		/*
			event of logout button 
			use to logout current user 
		 */		
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

			}
		});
	}

}
