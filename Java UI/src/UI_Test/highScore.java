package UI_Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class highScore extends JPanel {

	public JPanel contentPane;
	public JTable tb_high_score;


	/**
	 * Create the panel.
	 */
	public highScore() {
		Component component = new Component();
		//setTitle("High Score");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tb_high_score = new JTable();
		tb_high_score.setBounds(138, 77, 196, 166);
		contentPane.add(tb_high_score);
		
		/*
		JButton btn_easy = new JButton("Easy");
		btn_easy.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_easy.setBounds(49, 88, 89, 36);
		contentPane.add(btn_easy);
		*/
		JButton btn_easy = component.createButton("Easy", 47, 88, 90, 36, 13);
		contentPane.add(btn_easy);
		
		/*
		JButton btn_normal = new JButton("Normal");
		btn_normal.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_normal.setBounds(49, 124, 89, 36);
		contentPane.add(btn_normal);
		*/
		JButton btn_normal = component.createButton("Normal", 47, 124, 90, 36, 13);
		contentPane.add(btn_normal);
		
		/*
		JButton btn_very_hard = new JButton("Very Hard");
		btn_very_hard.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		btn_very_hard.setBounds(35, 195, 103, 36);
		contentPane.add(btn_very_hard);
		*/
		JButton btn_very_hard = component.createButton("Very Hard", 47, 195, 90, 36, 13);
		contentPane.add(btn_very_hard);
		
		/*
		JButton btn_hard = new JButton("Hard");
		btn_hard.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_hard.setBounds(49, 159, 89, 36);
		contentPane.add(btn_hard);
		*/
		JButton btn_hard = component.createButton("Hard", 47, 159, 90, 36, 13);
		contentPane.add(btn_hard);
		
		/*
		JLabel lb_title_game = new JLabel("SNAKE GAME");
		lb_title_game.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lb_title_game.setBounds(79, 11, 223, 54);
		contentPane.add(lb_title_game);
		*/
		JLabel lb_title_game = component.createLabelgameTitile();
		contentPane.add(lb_title_game);
		
		/*
		JLabel lb_your_high_score = new JLabel("Your High Score:");
		lb_your_high_score.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_your_high_score.setBounds(49, 257, 110, 21);
		contentPane.add(lb_your_high_score);
		*/
		
		JLabel lb_your_high_score = component.createInformationlabel("Your High Score:", 49, 257, 110, 21, 14);
		contentPane.add(lb_your_high_score);
		
		/*
		JLabel lb_difficulty = new JLabel("Difficulty: ");
		lb_difficulty.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_difficulty.setBounds(49, 279, 66, 21);
		contentPane.add(lb_difficulty);
		*/
		JLabel lb_difficulty = component.createInformationlabel("Difficulty:", 49, 279, 66, 21, 14);
		contentPane.add(lb_difficulty);
		
		/*
		JLabel lb_rank = new JLabel("Rank:");
		lb_rank.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb_rank.setBounds(49, 301, 66, 21);
		contentPane.add(lb_rank);
		*/
		JLabel lb_rank = component.createInformationlabel("Rank:",49, 301, 66, 21, 14);
		contentPane.add(lb_rank);
		
		/*
		JLabel rank = new JLabel("1");
		rank.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rank.setBounds(162, 301, 66, 21);
		contentPane.add(rank);
		*/
		JLabel rank = component.createInformationlabel("1",162, 301, 66, 21,14);
		contentPane.add(rank);
		
		/*
		JLabel difficulty = new JLabel("Easy");
		difficulty.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		difficulty.setBounds(162, 279, 66, 21);
		contentPane.add(difficulty);
		*/
		JLabel difficulty = component.createInformationlabel("Easy",162, 279, 66, 21,14);
		contentPane.add(difficulty);
		
		/*
		JLabel high_score = new JLabel("0");
		high_score.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		high_score.setBounds(162, 257, 110, 21);
		contentPane.add(high_score);
		*/
		JLabel high_score = component.createInformationlabel("0",162, 257, 110, 21,14);
		contentPane.add(high_score);
		
		/*
		JButton button = new JButton("Return");
		button.setFont(new Font("Times New Roman", Font.BOLD, 14));
		button.setBackground(Color.RED);
		button.setBounds(138, 327, 128, 23);
		contentPane.add(button);
		*/
		JButton btn_return = component.createButton("return", 138, 327, 128, 30, 15);
		btn_return.setBackground(Color.red);
		contentPane.add(btn_return);
		
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
