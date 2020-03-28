package model;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class Apple extends GameObject{
	
	private final static Color APPLE_COLOR = Color.red;
	
	private Point point;

	public Apple() {
		
		super(APPLE_COLOR);
		point = Point.getRandomPoint();
	}
	

	public void eaten(List<Point> snake) {
		// TODO Auto-generated method stub
		while (snake.contains(point)) {
			
			point = Point.getRandomPoint();
		}
		
		notifyObservers();
	}	

	@Override
	public List<Update> getUpdates() {
		
		List<Update> updates_list = new LinkedList<Update>();
		updates_list.add(new Update(this.getColor(), point));
		
		return updates_list;
	}

	public Point getPosition() {

		return point;
	}

}
