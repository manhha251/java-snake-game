package model;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import config.Config;
import gameui.ScorePanel;
import observers.GameObjectObserver;
import util.Direction;

public class Board extends GameObject implements GameObjectObserver{
	
	private int width, height;
	
	private Snake snake;
	
	private Apple apple;
	
	private List<Update> updates;

	public Board(int width, int height) {
		
		super(Color.black);
		
		updates = new LinkedList<Update>();
		
		snake = new Snake(this, Snake.INIT_LENGTH);
		
		snake.addObserver(this);
		
		apple = new Apple();
		
		apple.addObserver(this);
		
		this.width = width;
		
		this.height = height;
	}
	
	public void setDirection(Direction d) {
		
		snake.setDirection(d);
	}
	
	public boolean isAlive() {
		
		return snake.isAlive();
	}
	
	public boolean outOfBoard(Point p) {
		
		return (p.getX() < 0 || p.getX() >= width 
			|| p.getY() < 0 || p.getY() >= height);
	}
	
	public boolean appleEaten(List<Point> snake) {
		
		Point p = apple.getPosition();
		if (snake.contains(p)) {
			
			apple.eaten(snake);
			return true;
		}
		
		return false;	
	}
	
	public void gameStart() {
		
		Thread snake_thread = new Thread(snake);
		
		snake_thread.start();
		
		apple.notifyObservers();
	}

	@Override
	public void update(GameObject object) {
		
		updates.addAll(object.getUpdates());
		notifyObservers();
	}

	@Override
	public List<Update> getUpdates() {
		
		List<Update> updates_list = new LinkedList<Update>();
		
		updates_list.addAll(updates);
		
		updates.clear();
		
		return updates_list;
	}
	
	public int getWidth() {
		
		return this.width;
	}
	
	public int getHeight() {
		
		return this.height;
	}
}
