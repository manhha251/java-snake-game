package UI_Test;

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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class settings extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlayerName;

	/**
	 * Create the frame.
	 */
	public settings() {
		setTitle("Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_settings = new JPanel();
		pn_settings.setBorder(new TitledBorder(null, "Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pn_settings.setBounds(21, 82, 339, 177);
		contentPane.add(pn_settings);
		pn_settings.setLayout(null);
		
		JSlider volume = new JSlider();
		volume.setPaintTicks(true);
		volume.setBounds(117, 135, 212, 31);
		pn_settings.add(volume);
		
		txtPlayerName = new JTextField();
		txtPlayerName.setBounds(129, 26, 200, 26);
		pn_settings.add(txtPlayerName);
		txtPlayerName.setColumns(10);
		
		JComboBox cbb_windown_size = new JComboBox();
		cbb_windown_size.setBounds(129, 61, 106, 26);
		pn_settings.add(cbb_windown_size);
		
		JComboBox cbb_difficulty = new JComboBox();
		cbb_difficulty.setBounds(129, 98, 106, 26);
		pn_settings.add(cbb_difficulty);
		
		JLabel lb_player_name = new JLabel("Player Name:");
		lb_player_name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_player_name.setBounds(10, 26, 84, 20);
		pn_settings.add(lb_player_name);
		
		JLabel lb_window_size = new JLabel("Window Size:");
		lb_window_size.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_window_size.setBounds(10, 61, 84, 20);
		pn_settings.add(lb_window_size);
		
		JLabel lb_difficulty = new JLabel("Difficulty:");
		lb_difficulty.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_difficulty.setBounds(10, 100, 84, 20);
		pn_settings.add(lb_difficulty);
		
		JLabel lb_sounds = new JLabel("Sounds:");
		lb_sounds.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_sounds.setBounds(10, 140, 84, 20);
		pn_settings.add(lb_sounds);
		
		JLabel lb_game_title = new JLabel("SNAKE GAME");
		lb_game_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lb_game_title.setBounds(84, 11, 223, 54);
		contentPane.add(lb_game_title);
		
		JButton button = new JButton("Return");
		button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(Color.RED);
		button.setBounds(126, 313, 128, 23);
		contentPane.add(button);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnApply.setBackground(Color.WHITE);
		btnApply.setBounds(126, 276, 128, 23);
		contentPane.add(btnApply);
		
	 	//Event of components:
		/* 
			Event of return button
			use to return main menu
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				main_menu form_main_menu = new main_menu();
				form_main_menu.setVisible(true);
			}
		});
	}
}
