import javax.swing.*;
import java.awt.*;

/*
 * Panel for main game board
 * Displayed the game while it's running
 * Draw the layout of the board as well as the snake, apple, obstacles,...
 *
 * @author Luu Pham Manh Ha - 1752001
 */

public class GamePanel extends JPanel {

    private int width, height, scale;

    private Snake snake;

    private MyKeyListener keyListener;

    public GamePanel(int width, int height, int scale) {

        this.width = width;
        this.height = height;
        this.scale = scale;
        setPreferredSize(new Dimension(width, height));
        snake = new Snake(this, 20);
        keyListener = new MyKeyListener(snake);

        addKeyListener(keyListener);
        setFocusable(true);
        setBackground(Color.black);
    }

    public void move() {
        snake.move();
    }

    /*
     * Paint all GI main components: layout, snake, apple, obstacles,...
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        paintBackGround(g2d);
        snake.paint(g2d);
    }

    private void paintBackGround(Graphics2D g2d) {

        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(0.25f));
        for (int i = 0; i < width; i += scale) {
            for (int j = 0; j < height; j += scale) {
                g2d.drawLine(i, j, i + scale - 1, j);
                g2d.drawLine(i, j, i, j + scale - 1);
            }
        }
    }
}
