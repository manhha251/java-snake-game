package Model;

import Config.Config;
import Util.Direction;

import java.awt.*;
import java.util.LinkedList;

/*
 * Model for the snake object
 * Generated at center of the board upon game start
 *
 * @author Luu Pham Manh Ha - 1752001
 */

public class Snake implements RenderObject {

    private final int rows = Config.BOARD_ROWS;
    private final int columns = Config.BOARD_COLUMNS;
    private final int scale = Config.SCALE;

    private static LinkedList<Point> snakeBody;

    private Direction direction;

    public Snake() { }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void generate() {

        if (snakeBody == null)
            snakeBody = new LinkedList<Point>();
        else
            snakeBody.clear();

        int initX = rows / 2;
        int initY = columns / 2;
        int initLength = 3;
        direction = Direction.UP;

        for (int i = 0; i < initLength; i++) {

            snakeBody.add(new Point(initX - i * direction.x, initY - i * direction.y));
        }
    }

    public Point newHead() {

        Point head = snakeBody.getFirst();

        return new Point((int)head.getX() + direction.x, (int)head.getY() + direction.y);
    }

    /*
     * paint snake
     */
    public void paint(Graphics2D g) {

        g.setColor(Color.green);
        for (Point snakeBody : snakeBody) {

            int x = (int)snakeBody.getX();
            int y = (int)snakeBody.getY();
            g.fillRect(x * scale, y * scale, scale, scale);
        }
    }

    public boolean collision(Point point) {

        return snakeBody.contains(point);
    }

    public void update(Point newHead, boolean appleEaten) {

        snakeBody.getLast().setLocation(newHead);

        if (appleEaten) {

            snakeBody.addFirst(newHead);
        } else {

            snakeBody.addFirst(snakeBody.removeLast());
        }
    }
}
