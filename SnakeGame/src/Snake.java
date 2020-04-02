import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/*
 * Model for the snake object
 *
 * @author Luu Pham Manh Ha - 1752001
 */

public class Snake {

    private static int rows, columns;

    private int scale;

    private int x;
    private int y;

    private int xa;
    private int ya;

    private static GamePanel game;

    private static LinkedList<Point> snake;

    public Snake(GamePanel game, int scale) {

        Snake.game = game;
        this.scale = scale;
        rows = game.getHeight() / scale;
        columns = game.getWidth() / scale;
        x = columns /2;
        y = rows / 2;
        xa = 1;
        ya = 0;

        initSnake(5);
    }

    /*
     * Initialize a new Snake with give length
     * @param length: give length for snake
     */
    private void initSnake(int length) {

        snake = new LinkedList<Point>();
        for (int i = 0; i < length; i++) {

            snake.add(new Point(x - i * xa, y - i * ya));
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /*
     * simulate move snake in current direction
     * @return: new head point
     */
    public Point tryMove() {

        int newHeadX = x + xa;
        int newHeadY = y + ya;

        return new Point(newHeadX, newHeadY);
    }

    public static boolean collision(int x, int y) {
        System.out.println(x + " " + y);

        if (snake.contains(new Point(x, y))) {
            System.out.println("Collision 1");
            return true;
        }

        if (x < 0 || x >= columns) {
            System.out.println("Collision 2");
            return true;
        }

        if (y < 0 || y >=columns) {
            System.out.println("Collision 3");
            return true;
        }

        return false;
    }

    /*
     * Change snake direction on key pressed
     */
    public void keyPressed(KeyEvent e) {
        int key_code = e.getKeyCode();

        switch (key_code) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                xa = 0;
                ya = -1;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                xa = 0;
                ya = 1;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                xa = -1;
                ya = 0;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                xa = 1;
                ya = 0;
                break;
        }
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

    public boolean ate(Apple apple) {

        Point applePoint = apple.getApple();
        return (snake.contains(applePoint));
    }

    public void addFirst(Point head) {

        snake.addFirst(head);
    }

    public void removeLast() {
        snake.removeLast();
    }

    public Point getLast() {

        return snake.getLast();
    }
}
