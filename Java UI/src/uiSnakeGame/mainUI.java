package uiSnakeGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.midi.Soundbank;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Component;

public class mainUI extends JFrame {
	Clip sound;
	int height, width;
	double vol = 1;
	
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
	 * changePanel(JPanel panel) to change new panel
	 * Clip setMusic(String musicLocation) to set a sound
	 * void setVolume(Clip sound, double vol) to set volume of sound
	 */
	
		Clip setMusic(String musicLocation)
		{	
			try {
				File musicFile = new File(musicLocation);
				if (musicFile.exists())
				{
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
					Clip clip  = AudioSystem.getClip();
					clip.open(audioInput);
					clip.start();
					return clip;
				}
				else {
					System.out.print("can not find");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		void setVolume(Clip sound, double vol)
		{
			FloatControl gain = (FloatControl)sound.getControl(FloatControl.Type.MASTER_GAIN);
			float dB = (float)(Math.log(vol) / Math.log(10) * 20);
			gain.setValue(dB);
		}
	
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
		height = 410;
		width = 400 ;
		
		setTitle("Home Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 0, width, height);
		setAlwaysOnTop(true);
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
		
		sound = setMusic("Sound\\\\open_sound.wav");
		setVolume(sound, 1);
		
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
				setBounds(200, 0, width+160, height);
				changePanel(panel_game_board);
				sound.stop();
				sound = setMusic("Sound\\\\game_sound.wav");
				setVolume(sound, vol);
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
				changePanel(panel_main_menu);
				setBounds(200, 0, width, height);
				
				sound.stop();
				sound = setMusic("Sound\\\\open_sound.wav");
				setVolume(sound, vol);
				
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
		 * btn_apply event save settings
		 */
		settings.btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Main Menu");
				changePanel(panel_main_menu);
			}
		});
		
		settings.volume.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				vol = 1.0*settings.volume.getValue()/100;
			}
		});
		
		settings.btn_apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String window_size = (String)settings.model_window_size.getSelectedItem();
				switch (window_size) {
				case "Small":
					height = width = 400;
					break;
				case "Normal":
					height = width = 600;
					break;
				case "Large":
					height = 780;
					width = 800;
					break;
				default:
					break;
				}
				setBounds(200, 0, width, height);
				
				setVolume(sound, vol);
				
				settings.Resize(width ,height);
				main_menu.Resize(width ,height);
				login.Resize(width,height);
				register.Resize(width, height);
				high_score.Resize(width, height);
				load_game.Resize(width, height);
				game_board.Resize(width, height);
			}
		});
		/*
		 * Event of the high_score panel
		 * btn_return event `return main menu panel
		 */
		high_score.btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt ) {
				setTitle("Main Menu");
				changePanel(panel_main_menu);
			}
		});
	}

}
