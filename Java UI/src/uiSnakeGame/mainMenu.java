package uiSnakeGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainMenu extends JPanel {

	public JPanel contentPane;
	Component component = new Component();
	
	//component of the panel
	public JButton btn_new_game;
	public JButton btn_load_game;
	public JButton btn_high_score;
	public JButton btn_settings;
	public JButton btn_logout;
	JLabel lb_title_game;
	
	/*
	 * create methods
	 * Resize(int width, int height) to change size of the panel
	 */
	public void Resize(int width ,int height) {
		component.resizeLabel(lb_title_game, 34, 84, 11, 223, 54,width, height);
		component.resizeButton(btn_new_game, 20, 107, 89, 164, 33, width, height);
		component.resizeButton(btn_load_game, 20, 107, 141, 164, 33, width, height);
		component.resizeButton(btn_high_score, 20, 107, 194, 164, 33, width, height);
		component.resizeButton(btn_settings, 20, 107, 246, 164, 33, width, height);
		component.resizeButton(btn_logout, 20, 107, 298, 164, 33, width, height);
	}
	/**
	 * Create the Panel.
	 */
	public  mainMenu() {
		//setTitle("Main Menu");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		JLabel lb_title_game = new JLabel("SNAKE GAME");
		lb_title_game.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lb_title_game.setBounds(75, 24, 223, 54);
		contentPane.add(lb_title_game);
		*/
		lb_title_game = component.createLabelgameTitile();
		contentPane.add(lb_title_game);
		
		
		/*
		JButton btn_new_game = new JButton("New Game");
		btn_new_game.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_new_game.setBounds(107, 89, 164, 33);
		contentPane.add(btn_new_game);
		*/
		btn_new_game = component.createButton("New Game", 107, 89, 164, 33, 20);
		contentPane.add(btn_new_game);
		
		/*
		JButton btn_load_game = new JButton("Load Game");
		btn_load_game.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_load_game.setBounds(107, 141, 164, 33);
		contentPane.add(btn_load_game);
		*/
		btn_load_game =  component.createButton("Load Game", 107, 141, 164, 33, 20);
		contentPane.add(btn_load_game);
		/*
		JButton btn_settings = new JButton("Settings");
		btn_settings.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_settings.setBounds(107, 246, 164, 33);
		contentPane.add(btn_settings);
		*/
		btn_settings = component.createButton("Settings",107, 246, 164, 33, 20);
		contentPane.add(btn_settings);
		
		/*
		JButton btn_hight_score = new JButton("Hight Score");
		btn_hight_score.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_hight_score.setBounds();
		contentPane.add(btn_hight_score);
		*/
		btn_high_score =  component.createButton("Hight Score",107, 194, 164, 33,20);
		contentPane.add(btn_high_score);
		
		/*
		JButton btn_logout = new JButton("Logout");
		btn_logout.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		btn_logout.setBounds(107, 298, 164, 33);
		contentPane.add(btn_logout);
		*/
		btn_logout =component.createButton("Logout",107, 298, 164, 33,20);
		contentPane.add(btn_logout);
		//Event of components:
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
