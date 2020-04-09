package uiSnakeGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class gameBoard extends JPanel {

	public JPanel contentPane;
	
	public JButton btn_return ;
	JPanel pn_game_boar;
	
	JPanel pn_information;
	JLabel lb_information;
	JLabel lb_difficult;
	JLabel lb_player_name;
	JLabel lb_score;
	JLabel lb_apples_eaten;
	JLabel lb_snake_length ;
	JLabel user_name;
	JLabel difficulty;
	JLabel score;
	JLabel apples_eaten;
	JLabel snake_length;
	
	JPanel pn_help;
	JLabel lb_help;
	JLabel lb_move_up;
	JLabel lb_pause;
	JLabel lb_move_down;
	JLabel lb_move_right;
	JLabel lb_move_left;
	Component component = new Component();
	
	/*
	 * create methods
	 * Resize(int width, int height) to change size of the panel
	 */
	public void Resize(int width, int height) {
		component.resizePanel(pn_game_boar, 5, 5, 308, 351, width, height, 160);
		
		component.resizePanel(pn_information, 311, 5, 218, 167, width, height, 160);
		component.resizeLabel(lb_information, 20, 33, 11, 160, 29, width, height, 160);
		
		component.resizeLabel(lb_player_name, 14, 10, 51, 87, 22, width, height, 160);
		component.resizeLabel(user_name, 14, 112, 51, 96, 22, width, height, 160);
		
		component.resizeLabel(lb_difficult, 14, 10, 71, 66, 22, width, height, 160);
		component.resizeLabel(difficulty, 14, 112, 71, 96, 22, width, height, 160);
		
		component.resizeLabel(lb_score, 14, 10, 91, 66, 22, width, height, 160);
		component.resizeLabel(score, 14, 112, 91, 96, 22, width, height, 160);
		
		component.resizeLabel(lb_apples_eaten, 14, 10, 111, 87, 22, width, height, 160);
		component.resizeLabel(apples_eaten, 14, 112, 111, 96, 22, width, height, 160);
		
		component.resizeLabel(lb_snake_length, 14, 10, 131, 87, 22, width, height, 160);
		component.resizeLabel(snake_length, 14, 112, 131, 96, 22, width, height, 160);
		
		component.resizePanel(pn_help, 311, 171, 218, 185, width, height, 160);
		component.resizeLabel(lb_help, 20, 84, 11, 47, 29, width, height, 160);
		
		component.resizeLabel(lb_move_up, 14, 10, 111, 198, 22, width, height, 160);
		
		component.resizeLabel(lb_move_down, 14, 10, 91, 198, 22, width, height, 160);
		
		component.resizeLabel(lb_move_left, 14, 10, 51, 176, 22, width, height, 160);
		
		component.resizeLabel(lb_move_right, 14, 10, 71, 198, 22, width, height, 160);
		
		component.resizeLabel(lb_pause, 14, 10, 131, 87, 22, width, height, 160);
		
		component.resizeButton(btn_return, 15,60, 150, 87, 22, width, height, 160);
	}
	
	/**
	 * Create the frame.
	 */
	public gameBoard() {
		//setTitle("Game Board");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		//setContentPane(contentPane);
		
		pn_game_boar = new JPanel();
		pn_game_boar.setBounds(5, 5, 308, 351);
		pn_game_boar.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pn_game_boar);
		pn_game_boar.setLayout(null);
		
		pn_information = new JPanel();
		pn_information.setBounds(311, 5, 218, 167);
		pn_information.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pn_information);
		pn_information.setLayout(null);
		
		/*
		JLabel lb_information = new JLabel("Game Information");
		lb_information.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lb_information.setBounds(33, 11, 160, 29);
		pn_information.add(lb_information);
		*/
		lb_information = component.createInformationlabel("Game Information",33, 11, 160, 29, 20);
		pn_information.add(lb_information);
		
		/*
		JLabel lb_difficult = new JLabel("Difficulty:");
		lb_difficult.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_difficult.setBounds(10, 71, 66, 22);
		pn_information.add(lb_difficult);
		*/
		lb_difficult = component.createInformationlabel("Difficulty:",10, 71, 66, 22, 14);
		pn_information.add(lb_difficult);
		
		/*
		JLabel lb_player_name = new JLabel("Player Name:");
		lb_player_name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_player_name.setBounds(10, 51, 87, 22);
		pn_information.add(lb_player_name);
		*/
		lb_player_name = component.createInformationlabel("Player Name:",10, 51, 87, 22, 14);
		pn_information.add(lb_player_name);
		
		/*
		JLabel lb_score = new JLabel("Score:");
		lb_score.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_score.setBounds(10, 91, 66, 22);
		pn_information.add(lb_score);
		*/		
		lb_score = component.createInformationlabel("Score: ",10, 91, 66, 22, 14);
		pn_information.add(lb_score);
		
		/*
		JLabel lb_apples_eaten = new JLabel("Apples Eaten:");
		lb_apples_eaten.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_apples_eaten.setBounds(10, 111, 87, 22);
		pn_information.add(lb_apples_eaten);
		*/
		lb_apples_eaten = component.createInformationlabel("Apples Eaten:",10, 111, 87, 22, 14);
		pn_information.add(lb_apples_eaten);
		
		/*
		JLabel lb_snake_length = new JLabel("Snake Length:");
		lb_snake_length.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_snake_length.setBounds(10, 131, 87, 22);
		pn_information.add(lb_snake_length);
		*/
		lb_snake_length = component.createInformationlabel("Snake Length:",10, 131, 87, 22, 14);
		pn_information.add(lb_snake_length);
		
		/*
		JLabel user_name = new JLabel("Name");
		user_name.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		user_name.setBounds(112, 51, 96, 22);
		pn_information.add(user_name);
		*/
		user_name = component.createInformationlabel("Name",112, 51, 96, 22, 14);
		pn_information.add(user_name);
		
		/*
		JLabel difficulty = new JLabel("Difficulty");
		difficulty.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		difficulty.setBounds(112, 71, 96, 22);
		pn_information.add(difficulty);
		*/
		difficulty = component.createInformationlabel("Easy",112, 71, 96, 22, 14);
		pn_information.add(difficulty);
		
		/*
		JLabel score = new JLabel("Score");
		score.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		score.setBounds(112, 91, 96, 22);
		pn_information.add(score);
		*/		
		score = component.createInformationlabel("0",112, 91, 96, 22, 14);
		pn_information.add(score);
		
		/*
		JLabel apples_eaten = new JLabel("Apples eaten");
		apples_eaten.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		apples_eaten.setBounds(112, 111, 96, 22);
		pn_information.add(apples_eaten);
		*/
		apples_eaten = component.createInformationlabel("0",112, 111, 96, 22, 14);
		pn_information.add(apples_eaten);
		
		/*
		JLabel snake_length = new JLabel("Snake length");
		snake_length.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		snake_length.setBounds(112, 131, 96, 22);
		pn_information.add(snake_length);
		*/
		snake_length = component.createInformationlabel("1", 112, 131, 96, 22, 14);
		pn_information.add(snake_length);
		
		pn_help = new JPanel();
		pn_help.setBorder(new LineBorder(new Color(0, 0, 0)));
		pn_help.setBounds(311, 171, 218, 185);
		contentPane.add(pn_help);
		pn_help.setLayout(null);
		
		
		/*
		JLabel lb_help = new JLabel("Help");
		lb_help.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lb_help.setBounds(84, 11, 47, 29);
		pn_help.add(lb_help);
		*/
		lb_help = component.createInformationlabel("Help", 84, 11, 47, 29, 20);
		pn_help.add(lb_help);
		
		/*
		JLabel lb_move_up = new JLabel("Move Up: Up ArrowKey/ W");
		lb_move_up.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_move_up.setBounds(10, 111, 198, 22);
		pn_help.add(lb_move_up);
		*/
		lb_move_up = component.createInformationlabel("Move Up: Up ArrowKey/ W", 10, 111, 198, 22, 14);
		pn_help.add(lb_move_up);
		
		/*
		JLabel lb_pause = new JLabel("Pause : P");
		lb_pause.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_pause.setBounds(10, 131, 87, 22);
		pn_help.add(lb_pause);
		*/
		lb_pause = component.createInformationlabel("Pause : P", 10, 131, 87, 22, 14);
		pn_help.add(lb_pause);
		
		/*
		JLabel lb_move_down = new JLabel("Move Down: Down ArrowKey/ S");
		lb_move_down.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_move_down.setBounds(10, 91, 198, 22);
		pn_help.add(lb_move_down);
		*/
		lb_move_down = component.createInformationlabel("Move Down: Down ArrowKey/ S", 10, 91, 198, 22, 14);
		pn_help.add(lb_move_down);
		
		/*
		JLabel lb_move_right = new JLabel("Move Right: Right ArrowKey/ D");
		lb_move_right.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_move_right.setBounds(10, 71, 198, 22);
		pn_help.add(lb_move_right);
		*/
		lb_move_right = component.createInformationlabel("Move Right: Right ArrowKey/ D", 10, 71, 198, 22, 14);
		pn_help.add(lb_move_right);
		
		/*
		JLabel lb_move_left = new JLabel("Move Left: Left ArrowKey/ A");
		lb_move_left.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_move_left.setBounds(10, 51, 176, 22);
		pn_help.add(lb_move_left);
		*/
		lb_move_left = component.createInformationlabel("Move Left: Left ArrowKey/ A", 10, 51, 176, 22, 14);
		pn_help.add(lb_move_left);
		
		btn_return = component.createButton("Return", 60, 150, 87, 22, 15);
		btn_return.setBackground(Color.RED);
		pn_help.add(btn_return);
	}
}
