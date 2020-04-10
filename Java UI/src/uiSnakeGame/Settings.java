package uiSnakeGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Settings extends JPanel {

	/*
	 * Component of the panel
	 */
	public JPanel contentPane;
	public JButton btn_return;
	public JButton btn_apply;
	
	JLabel lb_title_game;
	
	JPanel pn_settings;
	JLabel lb_sounds ;
	JLabel lb_player_name;
	JLabel lb_window_size ;
	JLabel lb_difficulty;
	JSlider volume;
	private JTextField txtPlayerName;
	
	JComboBox cbb_difficulty;
	JComboBox cbb_windown_size;
	
	public DefaultComboBoxModel model_window_size;
	public DefaultComboBoxModel model_difficult;
	Component component = new Component();
	
	/*
	 * create methods
	 * Resize(int width, int height) to change size of the panel
	 */
	public void Resize(int width, int height) {
		component.resizeLabel(lb_title_game, 34, 84, 11, 223, 54,width, height);
		
		component.resizeButton(btn_apply,14, 126, 276, 128, 23,width, height);
		component.resizeButton(btn_return,14, 126, 313, 128, 23,width, height);
		
		component.resizePanel(pn_settings, 26, 82, 335, 172, width, height);
		component.resizeLabel(lb_player_name, 14, 10, 26, 84, 20,width, height);
		component.resizeLabel(lb_window_size, 14, 10, 61, 84, 20,width, height);
		component.resizeLabel(lb_difficulty, 14, 10, 100, 84, 20,width, height);
		component.resizeLabel(lb_sounds, 14, 10, 135, 84, 20,width, height);
		
		component.resizeTextbox(txtPlayerName,11,129, 26, 200, 26,width,height);
		component.resizeCombobox(cbb_difficulty, 14,129, 98, 106, 26, width, height);
		component.resizeCombobox(cbb_windown_size, 14,129, 61, 106, 26, width, height);
		component.resizeSlider(volume, 117, 138, 212, 31, width, height);
	}
	
	/**
	 * Create the panel.
	 */
	public Settings() {
		//setTitle("Settings");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		pn_settings = new JPanel();
		pn_settings.setBounds(26, 82, 335, 172);
		pn_settings.setBorder(new TitledBorder(null, "Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		volume = new JSlider();
		volume.setBounds(117, 138, 212, 31);
		volume.setPaintTicks(true);
		
		/*
		txtPlayerName = new JTextField();
		txtPlayerName.setEditable(false);
		txtPlayerName.setBounds(129, 26, 200, 26);
		pn_settings.add(txtPlayerName);
		txtPlayerName.setColumns(10);
		*/
		txtPlayerName =  component.createTextbox(129, 26, 200, 26);
		pn_settings.add(txtPlayerName);
		
		/*
		JComboBox cbb_windown_size = new JComboBox();
		cbb_windown_size.setBounds(129, 61, 106, 26);
		pn_settings.add(cbb_windown_size);
		*/
		cbb_windown_size = component.createCombobox(129, 61, 106, 26);
		model_window_size = new DefaultComboBoxModel();
		model_window_size.addElement("Small");
		model_window_size.addElement("Normal");
		model_window_size.addElement("Large");
		cbb_windown_size.setModel(model_window_size);
		pn_settings.add(cbb_windown_size);
		
		/*
		JComboBox cbb_difficulty = new JComboBox();
		cbb_difficulty.setBounds(129, 98, 106, 26);
		pn_settings.add(cbb_difficulty);
		*/
		cbb_difficulty = component.createCombobox(129, 98, 106, 26);
		pn_settings.add(cbb_difficulty);
		model_difficult = new DefaultComboBoxModel();
		model_difficult.addElement("Easy");
		model_difficult.addElement("Normal");
		model_difficult.addElement("Hard");
		model_difficult.addElement("Very Hard");
		cbb_difficulty.setModel(model_difficult);
		/*
		JLabel lb_player_name = new JLabel("Player Name:");
		lb_player_name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_player_name.setBounds(10, 26, 84, 20);
		pn_settings.add(lb_player_name);
		*/
		lb_player_name = component.createInformationlabel("Window Size: ",10, 26, 84, 20, 14);
		pn_settings.add(lb_player_name);	
		
		/*
		JLabel lb_window_size = new JLabel("Window Size:");
		lb_window_size.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_window_size.setBounds(10, 61, 84, 20);
		pn_settings.add(lb_window_size);
		*/
		lb_window_size = component.createInformationlabel("Window Size: ",10, 61, 84, 20, 14);
		pn_settings.add(lb_window_size);		
		
		/*
		JLabel lb_difficulty = new JLabel("Difficulty:");
		lb_difficulty.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_difficulty.setBounds(10, 100, 84, 20);
		pn_settings.add(lb_difficulty);
		*/
		lb_difficulty = component.createInformationlabel("Difficulty: ",10, 100, 84, 20, 14);
		pn_settings.add(lb_difficulty);		
		
		/*
		JLabel lb_sounds = new JLabel("Sounds:");
		lb_sounds.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_sounds.setBounds(10, 140, 84, 20);
		pn_settings.add(lb_sounds);
		*/
		lb_sounds = component.createInformationlabel("Sounds: ", 10, 135, 84, 20, 14);
		pn_settings.add(lb_sounds);
		
		/*
		JLabel lb_game_title = new JLabel("SNAKE GAME");
		lb_game_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lb_game_title.setBounds(84, 11, 223, 54);
		contentPane.add(lb_game_title);
		*/
		lb_title_game = component.createLabelgameTitile();
		contentPane.add(lb_title_game);
		
		/*
		JButton button = new JButton("Return");
		button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(Color.RED);
		button.setBounds(126, 313, 128, 23);
		contentPane.add(button);
		*/
		btn_return = component.createButton("Return", 126, 313, 128, 23, 14);
		btn_return.setBackground(Color.RED);
		contentPane.add(btn_return);
		
		/*
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(126, 276, 128, 23);
		contentPane.add(btnApply);
		*/
		btn_apply = component.createButton("Apply", 126, 276, 128, 23, 14);
		contentPane.add(btn_apply);

		pn_settings.setLayout(null);
		pn_settings.add(volume);
		
		contentPane.setLayout(null);
		contentPane.add(pn_settings);
		
	 	//Event of components:
		/* 
			Event of return button
			use to return main menu
		 */
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
