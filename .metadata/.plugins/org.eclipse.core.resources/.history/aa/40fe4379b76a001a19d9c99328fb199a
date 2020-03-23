package snake;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

public class Snake {
	
	private static final int INIT_LENGTH = 3;
	
	private int length;
	private LinkedList<Direction> direction_list;
	private LinkedList<Point> snake;
	private Tile[] snake_tiles;
	
	private Color head_color;
	private Color body_color;
	
	public Snake() {
		
		this.length = INIT_LENGTH;

		this.snake_tiles = new Tile[Config.BOARD_COLS * Config.BOARD_ROWS];
		this.snake = new LinkedList<>();
		this.direction_list = new LinkedList<>();
		
		setSnakeHeadColor(Color.red);
		setSnakeBodyColor(Color.green);
	}
	
	/* ----------------------- Snake Tile method ----------------------------------*/
	
	public void resetSnakeTile() {
		
		for (int i = 0; i < snake_tiles.length; i++) {
			snake_tiles[i] = null;
		}
	}
	
	public void setSnakeTile(Point point, Tile tile) {

		setSnakeTile(point.x, point.y, tile);
	}
	
	public void setSnakeTile(int x, int y, Tile tile) {

		snake_tiles[y * Config.BOARD_ROWS + x] = tile;
	}
	
	public Tile getSnakeTileAt(int x, int y) {
		return snake_tiles[y * Config.BOARD_ROWS + x];
	}
	
	/* ----------------------- Snake Color method ----------------------------------*/
	
	public void setSnakeHeadColor(Color c) {
		this.head_color = c;
	}
	
	public void setSnakeBodyColor(Color c) {
		this.body_color = c;
	}
	
	public Color getSnakeHeadColor() {
		return this.head_color;
	}
	
	public Color getSnakeBodyColor() {
		return this.body_color;
	}
	
	/* ----------------------- Snake List method ----------------------------------*/
	
	public void resetSnake() {
		snake.clear();
	}
	
	
	public Point removeSnakeTail() {
		length--;
		return snake.removeLast();
	}
	
	public void snakeGrow(Point tail) {
		length++;
		snake.add(tail);
	}
	
	public int getLength() {
		return this.length;
	}
	
	public Point peekSnakeHead() {
		return snake.peekFirst();
	}
	
	public void addSnakeHead(Point head) {
		snake.addFirst(head);
	}
	
	/* ----------------------- Direction method ----------------------------------*/
	
	public void clearDirectionList() {
		direction_list.clear();
	}
	
	public Direction getFirstDirection() {
		return direction_list.poll();
	}
	
	public Direction peekFirstDirection() {
		return direction_list.peekFirst();
	}
	
	public Direction peekLastDirection() {
		return direction_list.peekLast();
	}
	
	public int getDirectionListSize() {
		return direction_list.size();
	}
	
	public void addToDirectionList(Direction dir) {
		direction_list.add(dir);
	}
	
	public void addToLastDirectionList(Direction dir) {
		direction_list.addLast(dir);
	}
}
