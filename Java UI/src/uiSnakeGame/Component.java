package uiSnakeGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Component extends JFrame {

	/*
	 * JButton createButton() to create JButton
	 * JLabel createLabelgameTitile() to create JLabel for game titile
	 * JLabel createInformationlabel(String titile, int x, int y, int widtht, int height, int font_size) to to create JLabel
	 * JComboBox createCombobox(int x, int y, int widtht, int height) to create ComboBox
	 * JTextField createTextbox(int x, int y, int widtht, int height) to create Text Box
	  
	 * resizeLabel(), resizeButton(), resizeTextbox(),resizePanel(),resizeList(),resizeCombobox(),resizeSlider()
	 * to change size of component 
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
		lb_title_game.setBounds(79, 11, 270, 80);

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
	
	public void resizeLabel(JLabel label, int default_font_size, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height) {
		int font_size, x,y,width, height;
		font_size = x= y=width = height = 0;
	
		font_size = (default_font_size*new_widtht)/400;
		
		x = (default_x*new_widtht)/400;
		y = (default_y*new_height)/400;
		
		width = (default_width*new_widtht)/400;
		height = (default_height*new_height)/400;
		
		label.setFont(new Font("Times New Roman", Font.PLAIN, font_size));
		label.setBounds(x, y, width, height);
	}
	
	public void resizeLabel(JLabel label, int default_font_size, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height, int extra_size) {
		int font_size, x,y,width, height;
		font_size = x= y=width = height = 0;
	
		font_size = (default_font_size*(new_widtht + extra_size))/(400+extra_size);
		
		x = (default_x*(new_widtht + extra_size))/(400+extra_size);
		y = (default_y*new_height)/400;
		
		width = (default_width*(new_widtht + extra_size))/(400+extra_size);
		height = (default_height*new_height)/400;
		
		label.setFont(new Font("Times New Roman", Font.PLAIN, font_size));
		label.setBounds(x, y, width, height);
	}
	
	public void resizeButton(JButton button, int default_font_size, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height) {
		int font_size, x,y,width, height;
		font_size = x= y=width = height = 0;
	
		font_size = (default_font_size*new_widtht)/400;
		
		x = (default_x*new_widtht)/400;
		y = (default_y*new_height)/400;
		
		width = (default_width*new_widtht)/400;
		height = (default_height*new_height)/400;
		
		button.setFont(new Font("Times New Roman", Font.PLAIN, font_size));
		button.setBounds(x, y, width, height);
	}
	
	public void resizeButton(JButton button, int default_font_size, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height,int extra_size) {
		int font_size, x,y,width, height;
		font_size = x= y=width = height = 0;
	
		font_size = (default_font_size*(new_widtht+extra_size))/(400+extra_size);
		
		x = (default_x*(new_widtht+extra_size))/(400+extra_size);
		y = (default_y*new_height)/400;
		
		width = (default_width*(new_widtht+extra_size))/(400+extra_size);
		height = (default_height*new_height)/400;
		
		button.setFont(new Font("Times New Roman", Font.PLAIN, font_size));
		button.setBounds(x, y, width, height);
	}
	
	public void resizeTextbox(JTextField text_field, int default_font_size, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height) {
		int font_size, x,y,width, height;
		font_size = x= y=width = height = 0;
	
		font_size = (default_font_size*new_widtht)/400;
		
		x = (default_x*new_widtht)/400;
		y = (default_y*new_height)/400;
		
		width = (default_width*new_widtht)/400;
		height = (default_height*new_height)/400;
		
		text_field.setFont(new Font("Times New Roman", Font.PLAIN, font_size));
		text_field.setBounds(x, y, width, height);
	}
	
	public void resizePanel(JPanel panel, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height) {
		int x,y,width, height;
		x= y=width = height = 0;
		
		x = (default_x*new_widtht)/400;
		y = (default_y*new_height)/400;
		
		width = (default_width*new_widtht)/400;
		height = (default_height*new_height)/400;
		
		panel.setBounds(x, y, width, height);
	}
	
	public void resizePanel(JPanel panel, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height,int extra_size) {
		int x,y,width, height;
		x= y=width = height = 0;
		
		x = (default_x*(new_widtht+extra_size))/(400+extra_size);
		y = (default_y*new_height)/410;
		
		width = (default_width*(new_widtht + extra_size))/(400+extra_size);
		height = (default_height*new_height)/410;
		
		panel.setBounds(x, y, width, height);
	}
	
	public void resizeCombobox(JComboBox comboBox ,int default_font_size, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height) {
		int font_size, x,y,width, height;
		font_size = x = y = width = height = 0;
		
		font_size = (default_font_size*new_widtht)/400;
		
		x = (default_x*new_widtht)/400;
		y = (default_y*new_height)/400;
		
		width = (default_width*new_widtht)/400;
		height = (default_height*new_height)/400;
		comboBox.setFont(new Font("Tahoma", Font.BOLD, font_size));
		comboBox.setBounds(x, y, width, height);
	}
	
	public void resizeSlider(JSlider slider, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height) {
		int x,y,width, height;
		
		x = (default_x*new_widtht)/400;
		y = (default_y*new_height)/400;
		
		width = (default_width*new_widtht)/400;
		height = (default_height*new_height)/400;
		
		slider.setBounds(x, y, width, height);
	}

	public void resizeTable(JTable table, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height) {
		int x,y,width, height;
		
		x = (default_x*new_widtht)/400;
		y = (default_y*new_height)/400;
		
		width = (default_width*new_widtht)/400;
		height = (default_height*new_height)/400;
		
		table.setBounds(x, y, width, height);
	}
	
	public void resizeList(JList list, int default_x, int default_y, int default_width,
			int default_height, int new_widtht ,int new_height) {
		int x,y,width, height;
		
		x = (default_x*new_widtht)/400;
		y = (default_y*new_height)/400;
		
		width = (default_width*new_widtht)/400;
		height = (default_height*new_height)/400;
		
		list.setBounds(x, y, width, height);
	}
}