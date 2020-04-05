package UI_Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Component extends JFrame {

	/*
	  JButton createButton() to create JButton
	  JLabel createLabelgameTitile() to create JLabel for game titile
	  JLabel createInformationlabel(String titile, int x, int y, int widtht, int height, int font_size) to to create JLabel
	  JComboBox createCombobox(int x, int y, int widtht, int height) to create ComboBox
	  JTextField createTextbox(int x, int y, int widtht, int height) to create Text Box
	 */
	 
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
		txt.setEditable(true);
		txt.setBounds(x, y, widtht, height);
		txt.setColumns(10);
		return txt;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'p' ||e.getKeyChar() == 'P')
		{
			JOptionPane.showMessageDialog(null, "Pause");
		}
		else if (e.getKeyChar() == 'a' ||e.getKeyChar() == 'A')
		{
			JOptionPane.showMessageDialog(null, "Left");
		}
		else if (e.getKeyChar() == 's' ||e.getKeyChar() == 'S')
		{
			JOptionPane.showMessageDialog(null, "Down");
		}
		else if (e.getKeyChar() == 'd' ||e.getKeyChar() == 'D')
		{
			JOptionPane.showMessageDialog(null, "Right");
		}
		else if (e.getKeyChar() == 'w' ||e.getKeyChar() == 'W')
		{
			JOptionPane.showMessageDialog(null, "Up");
		}
	}
}
