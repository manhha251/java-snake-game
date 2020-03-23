package snake;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Apple{
	
	private static final int DEFAULT_SCORE = 100;

	private int score;
	
	private Color apple_color;
	
	private Tile apple_tile;
	private Point apple_point;
	
	Random r = new Random();
	
	public Apple() {
		setAppleScore(DEFAULT_SCORE);
		setAppleColor(Color.red);
		
		apple_tile = Tile.APPLE;
		apple_point = new Point(-1, -1); // not visible yet
	}
	
	public void setAppleScore(int score) {
		this.score = score;
	}
	
	public void setAppleColor(Color c) {
		this.apple_color = c;
	}
	
	public int getAppleScore() {
		return this.score;
	}
	
	public Color getAppleColor() {
		return this.apple_color;
	}
	
	public Tile getAppleTile() {
		return apple_tile;
	}
	
	public void setApplePoint(Point point) {
		this.apple_point = point;
	}
	
	public void setApplePos(int x, int y) {
		apple_point.x = x;
		apple_point.y = y;
	}
	
	public Point getApplePoint() {
		return this.apple_point;
	}
	
}
