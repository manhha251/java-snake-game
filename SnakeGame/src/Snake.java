import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/*
 * Model for the snake object
 *
 * @author Luu Pham Manh Ha - 1752001
 */

public class Snake {

    private int scale;

    private int x;
    private int y;

    private int xa;
    private int ya;

    private GamePanel game;

    private LinkedList<Point> snake;

    public Snake(GamePanel game, int scale) {

        this.game = game;
        this.scale = scale;
        x = game.getPreferredSize().width / 2;
        y = game.getPreferredSize().height / 2;
        xa = scale;
        ya = 0;

        snake = new LinkedList<Point>();
        initSnake(5);
    }

    /*
     * Initialize a new Snake with give length
     * @param length: give length for snake
     */
    private void initSnake(int length) {

        for (int i = 0; i < length; i++) {

            snake.add(new Point(x - i * xa, y - i * ya));
        }
    }

    /*
     * move snake in current direction
     */
    public void move() {

        x += xa;
        y += ya;

        if (x >= game.getWidth()) {
            x = 0;
        } else if (x < 0) {
            x = game.getWidth() - scale;
        }

        if (y >= game.getHeight()) {
            y = 0;
        } else if (y < 0) {
            y = game.getHeight() - scale;
        }

        snake.getLast().setLocation(x, y);
        snake.addFirst(snake.removeLast());
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
                ya = -scale;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                xa = 0;
                ya = scale;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                xa = -scale;
                ya = 0;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                xa = scale;
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
            g.fillRect(x, y, scale, scale);
        }
    }
}
