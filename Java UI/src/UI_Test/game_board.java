package UI_Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class game_board extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public game_board() {
		setTitle("Game Board");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_game_boar = new JPanel();
		pn_game_boar.setBounds(5, 5, 308, 351);
		pn_game_boar.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pn_game_boar);
		pn_game_boar.setLayout(null);
		
		JPanel pn_information = new JPanel();
		pn_information.setBounds(311, 5, 218, 167);
		pn_information.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pn_information);
		pn_information.setLayout(null);
		
		JLabel lb_information = new JLabel("Game Information");
		lb_information.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lb_information.setBounds(33, 11, 160, 29);
		pn_information.add(lb_information);
		
		JLabel lb_difficult = new JLabel("Difficulty:");
		lb_difficult.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_difficult.setBounds(10, 71, 66, 22);
		pn_information.add(lb_difficult);
		
		JLabel lb_player_name = new JLabel("Player Name:");
		lb_player_name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_player_name.setBounds(10, 51, 87, 22);
		pn_information.add(lb_player_name);
		
		JLabel lb_score = new JLabel("Score:");
		lb_score.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_score.setBounds(10, 91, 66, 22);
		pn_information.add(lb_score);
		
		JLabel lb_apples_eaten = new JLabel("Apples Eaten:");
		lb_apples_eaten.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_apples_eaten.setBounds(10, 111, 87, 22);
		pn_information.add(lb_apples_eaten);
		
		JLabel lb_snake_length = new JLabel("Snake Length:");
		lb_snake_length.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_snake_length.setBounds(10, 131, 87, 22);
		pn_information.add(lb_snake_length);
		
		JLabel user_name = new JLabel("Name");
		user_name.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		user_name.setBounds(112, 51, 96, 22);
		pn_information.add(user_name);
		
		JLabel difficulty = new JLabel("Difficulty");
		difficulty.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		difficulty.setBounds(112, 71, 96, 22);
		pn_information.add(difficulty);
		
		JLabel score = new JLabel("Score");
		score.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		score.setBounds(112, 91, 96, 22);
		pn_information.add(score);
		
		JLabel apples_eaten = new JLabel("Apples eaten");
		apples_eaten.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		apples_eaten.setBounds(112, 111, 96, 22);
		pn_information.add(apples_eaten);
		
		JLabel snake_length = new JLabel("Snake length");
		snake_length.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		snake_length.setBounds(112, 131, 96, 22);
		pn_information.add(snake_length);
		
		JPanel pn_help = new JPanel();
		pn_help.setBorder(new LineBorder(new Color(0, 0, 0)));
		pn_help.setBounds(311, 171, 218, 185);
		contentPane.add(pn_help);
		pn_help.setLayout(null);
		
		JLabel lb_help = new JLabel("Help");
		lb_help.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lb_help.setBounds(84, 11, 47, 29);
		pn_help.add(lb_help);
		
		JLabel lb_move_up = new JLabel("Move Up: Up ArrowKey/ W");
		lb_move_up.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_move_up.setBounds(10, 111, 198, 22);
		pn_help.add(lb_move_up);
		
		JLabel lb_pause = new JLabel("Pause : P");
		lb_pause.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_pause.setBounds(10, 131, 87, 22);
		pn_help.add(lb_pause);
		
		JLabel lb_move_down = new JLabel("Move Down: Down ArrowKey/ S");
		lb_move_down.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_move_down.setBounds(10, 91, 198, 22);
		pn_help.add(lb_move_down);
		
		JLabel lb_move_right = new JLabel("Move Right: Right ArrowKey/ D");
		lb_move_right.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_move_right.setBounds(10, 71, 198, 22);
		pn_help.add(lb_move_right);
		
		JLabel lb_move_left = new JLabel("Move Left: Left ArrowKey/ A");
		lb_move_left.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_move_left.setBounds(10, 51, 176, 22);
		pn_help.add(lb_move_left);
		
	}
}
