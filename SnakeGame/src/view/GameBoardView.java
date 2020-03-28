package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import config.Config;
import model.Board;
import model.Point;
import model.Update;

public class GameBoardView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1558652551614550222L;
	
	private List<Update> updates;
	
	public GameBoardView(Board board) {
		
		initBoardView(board);
	}
	
	private void initBoardView(Board board) {
		
		setPreferredSize(new Dimension(board.getWidth(), board.getHeight()));
		setFocusable(true);
	}
	
	public void setUpdateList(List<Update> list) {
		
		updates.addAll(list);
		repaint();
		updates.clear();
	}
	
	@Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        drawingUpdate(g);
    }

	private void drawingUpdate(Graphics g) {
		// TODO Auto-generated method stub
		
		for (Update update_point: updates) {
			
			Point p = update_point.getPoint();
			Color c = update_point.getColor();
			
			int x = p.getX(), y = p.getY();
			
			g.setColor(c);
			g.fillRect(y + 1, x + 1, Config.BLOCK_SIZE - 2, Config.BLOCK_SIZE - 2);
			
			g.setColor(Color.white);
			g.drawLine(y, x, y, x + Config.BLOCK_SIZE - 1);
			g.drawLine(y, x, y + Config.BLOCK_SIZE - 1, x);
			g.drawLine(y + Config.BLOCK_SIZE - 1, x, y + Config.BLOCK_SIZE - 1, x + Config.BLOCK_SIZE - 1);
			g.drawLine(y, x + Config.BLOCK_SIZE - 1, y + Config.BLOCK_SIZE - 1, x + Config.BLOCK_SIZE - 1);
		}
	}

}
