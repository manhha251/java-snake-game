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

    private static LinkedList<Point> snake;

    private Direction direction;

    public Snake() { }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void generate() {

        if (snake == null)
            snake = new LinkedList<Point>();
        else
            snake.clear();

        int initX = rows / 2;
        int initY = columns / 2;
        int initLength = 3;
        direction = Direction.UP;

        for (int i = 0; i < initLength; i++) {

            snake.add(new Point(initX - i * direction.x, initY - i * direction.y));
        }
    }

    public Point newHead() {

        Point head = snake.getFirst();

        return new Point((int)head.getX() + direction.x, (int)head.getY() + direction.y);
    }

    /*
     * paint snake
     */
    public void paint(Graphics2D g) {

        g.setColor(Color.green);
        for (Point snakeBody : snake) {

            int x = (int)snakeBody.getX();
            int y = (int)snakeBody.getY();
            g.fillRect(x * scale, y * scale, scale, scale);
        }
    }

    public boolean collision(Point point) {

        return snake.contains(point);
    }

    public void update(Point newHead, boolean appleEaten) {

        snake.getLast().setLocation(newHead);

        if (appleEaten) {

            snake.addFirst(newHead);
        } else {

            snake.addFirst(snake.removeLast());
        }
    }
}
