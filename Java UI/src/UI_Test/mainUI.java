package UI_Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

public class mainUI extends JFrame {
	
	private JLayeredPane layeredPane;
	private JPanel contentPane;
	
	Login login = new Login();
	Register register = new Register();
	mainMenu main_menu = new mainMenu();
	highScore high_score = new highScore();
	loadGame load_game = new loadGame();
	Settings settings = new Settings();
	gameBoard game_board = new gameBoard();
	
	/**
	 * the methods
	 *changePanel(JPanel panel) to change new panel
	 * 
	 */
	
	public void changePanel(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainUI frame = new mainUI();
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
	public mainUI() {

		setTitle("Home Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 410);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "name_7295731147900");
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel_login = login.contentPane;
		layeredPane.add(panel_login, "name_8470437678900");
		
		JPanel panel_register = register.contentPane;
		layeredPane.add(panel_register, "name_8525526148900");
		
		JPanel panel_main_menu = main_menu.contentPane;
		layeredPane.add(panel_main_menu, "name_8470437678900");
		
		JPanel panel_game_board = game_board.contentPane;
		layeredPane.add(panel_game_board, "name_8525526148900");
		
		JPanel panel_load_game = load_game.contentPane;
		layeredPane.add(panel_load_game, "name_8470437678900");
		
		JPanel panel_high_score = high_score.contentPane;
		layeredPane.add(panel_high_score, "name_8525526148900");
		
		JPanel panel_settings = settings.contentPane;
		layeredPane.add(panel_settings, "name_8525526148900");
		
		/*
		 * event of the login panel
		 * btn_register event open register panel
		 * btn_login event open menu panel
		 */
		login.btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {	
				setTitle("Register Page");
				changePanel(panel_register);
			}
		});
		
		login.btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {	
				setTitle("Main Menu");
				changePanel(panel_main_menu);
			}
		});
		
		/*
		 * Event of the register panel
		 * btn_login event open login panel
		 */
		register.btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setTitle("Home Screen");
				changePanel(panel_login);
			}
		});
		
		/*
		 * Event of the main_menu panel
		 * btn_new_game event open Game Board panel
		 * btn_load_game event open Load Game panel
		 * btn_high_score event open high score panel
		 * btn_settings event open settings panel
		 * main_menu.btn_logout event return home screen panel
		 */

		main_menu.btn_new_game.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Game Boar");
				setBounds(100, 100, 560, 410);
				changePanel(panel_game_board);
			}
		});
		
		main_menu.btn_load_game.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Load Game");
				changePanel(panel_load_game);
			}
		});
		
		main_menu.btn_high_score.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("High Score");
				changePanel(panel_high_score);
			}
		});
		
		main_menu.btn_settings.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Settings");
				changePanel(panel_settings);
			}
		});
		
		main_menu.btn_settings.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Settings");
				changePanel(panel_settings);
			}
		});
		
		main_menu.btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Home Sreen");
				changePanel(panel_login);
			}
		});
		/*
		 * Event of the game board panel
		 * btn_return event return main menu panel and save game score 
		 */
		game_board.btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Main Menu");
				setBounds(100, 100, 400, 410);
				changePanel(panel_main_menu);
			}
		});
		
		/*
		 * Event of the load game panel
		 * btn_return event return main menu panel
		 */
		load_game.btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Main Menu");
				changePanel(panel_main_menu);
			}
		});
		
		/*
		 * Event of the settimgs panel
		 * btn_return event return main menu panel
		 */
		settings.btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Main Menu");
				changePanel(panel_main_menu);
			}
		});
		
		/*
		 * Event of the high_score panel
		 * btn_return event return main menu panel
		 */
		high_score.btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Main Menu");
				changePanel(panel_main_menu);
			}
		});
	}

}
