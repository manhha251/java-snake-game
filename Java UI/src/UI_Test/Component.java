package UI_Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Component extends JFrame {

	public JButton createButton(String titile, int x, int y, int widtht, int height, int font_size)
	{
		JButton btn = new JButton(titile);
		btn.setFont(new Font("Times New Roman", Font.ITALIC, font_size));
		btn.setBounds(x, y,widtht , height);
		return btn;
	}
	
	public JLabel createLabelgameTitile()
	{
		JLabel lb_title_game = new JLabel("SNAKE GAME");
		lb_title_game.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lb_title_game.setBounds(79, 11, 223, 54);
		return lb_title_game;
	}
	
	public JLabel createInformationlabel(String titile, int x, int y, int widtht, int height, int font_size)
	{
		JLabel lb_information = new JLabel(titile);
		lb_information.setFont(new Font("Times New Roman", Font.PLAIN, font_size));
		lb_information.setBounds(x, y, widtht, height);
		return lb_information;
	}
	
	public JComboBox createCombobox(int x, int y, int widtht, int height)
	{
		JComboBox cbb = new JComboBox();
		cbb.setBounds(x, y, widtht, height);
		return cbb;
	}
	public JTextField createTextbox(int x, int y, int widtht, int height)
	{
		JTextField txt = new JTextField();
		txt.setEditable(false);
		txt.setBounds(x, y, widtht, height);
		txt.setColumns(10);
		return txt;
	}
}
