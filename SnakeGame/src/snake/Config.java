package snake;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

public class Config extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6987717423315755027L;
	
	/*--------------------------Static config----------------------------------*/
	
	    /*--------------------------Font-----------------------------------*/

	final static Font MAIN_FONT = new Font("Monospaced", Font.BOLD, 20);
	final static Font SMALL_FONT = MAIN_FONT.deriveFont(Font.BOLD, 12);
	final static Font LARGE_FONT = MAIN_FONT.deriveFont(Font.BOLD, 30);
    
        /*--------------------------Size-------------------------------*/
    
	final static int BOARD_COLS = 25;
	final static int BOARD_ROWS = 25;
	final static int SIDE_PANEL_COLS = 15;
	final static int SIDE_PANEL_ROWS = 25;
	final static int DEFAULT_BLOCK_SIZE = 20;
    
        /*----------------------------Color-------------------------------*/
    
	final static Color background_color = Color.black;
	
	/*----------------------------------------------------------------------------*/
	
	private int BLOCK_SIZE;
	
	private Snake snake;
	
	private Clock clock;
}
